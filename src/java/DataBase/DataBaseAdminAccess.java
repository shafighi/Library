/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;
import Forms.FilesDetails;
import Forms.Menu1Details;
import Forms.WaitingListDetails;
import Forms.toUTF8;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DataBaseAdminAccess {

    DataBaseConnection db ;

    public DataBaseAdminAccess() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException  {
        db = DataBaseConnection.getInstance();
    } 
    public String getPath(String levelup,String Subject) throws SQLException{
        String url = "select path from "+levelup+" where name='"+Subject+"';";
        ResultSet rs = db.getSt().executeQuery(url);  
        System.out.println(url + "shadishadi");
        rs.next();
        return rs.getString("path");
    }
    public void setNewFile(String name,String path,String show,String type,String levelup,String Subject,String accept) throws SQLException{
           System.out.append("gggggggggggggggg"+accept);
            String level=null;
           if(levelup.equals("levelone")){
               level = DataBaseConnection.DB_TABLE_FILES2;
           }else if(levelup.equals("leveltwo")){
               level = DataBaseConnection.DB_TABLE_FILES3;
           }else if(levelup.equals("levelthree")){
               level = DataBaseConnection.DB_TABLE_FILES4;
           }
           String  url ="INSERT INTO %s (name,path,showfile,typefile,%s,accept)values('%s','%s','%s','%s','%s','%s');";
           url = String.format(url,level,levelup,name,path,show,type,Subject,accept);
           System.out.println("insert"+url);
           db.getSt().execute(url);
        
    }
    public String AddNewSubject(String menu,String levelup,String name,String accept) throws SQLException{
            System.out.println("hooooy");
            String db_menu=null;
            String path =null;
            if(menu.equals("menu1")){
                db_menu = DataBaseConnection.DB_TABLE_MENU1;
            }else if(menu.equals("levelone")){
                db_menu = DataBaseConnection.DB_TABLE_MENU2;
            }else if(menu.equals("leveltwo")){
                db_menu = DataBaseConnection.DB_TABLE_MENU3;
            }else if(menu.equals("levelthree")){
                db_menu = DataBaseConnection.DB_TABLE_MENU4;
            }
            String url = "select * from "+ db_menu +";";
            System.out.println("1"+url);
            if(!menu.equals("menu1")){
                url = "select * from "+menu+" where name='"+levelup+"';";
                System.out.println("babajan: " + url);
                ResultSet rs = db.getSt().executeQuery(url);
                rs.next();
                path = rs.getString("path")+"/"+name;
                System.out.println("path: "+path);
                url ="INSERT INTO %s (name,%s,path,accept)values('%s','%s','%s','%s');";
                url = String.format(url,db_menu,menu,name,levelup,path,accept);
                System.out.println("2"+url);
            }else{
                path = "/"+name;
                url ="INSERT INTO %s (name,path,accept)values('%s','%s','%s');";
                url = String.format(url,db_menu,name,path,accept);
                System.out.println("3"+url);
            }
            String Directoy = DataBaseConnection.DB_FILESPATH+path;
            boolean success = (new File(Directoy)).mkdir();
            if (success) {
                  System.out.println("Directory: "+ Directoy + " created");
                  } 
                System.out.println("url="+url);
                db.getSt().execute(url);
                System.out.println("5"+url);
                return menu;   
    }
    public String DeleteSubject(String menu,String levelup,String subject) throws SQLException{
            System.out.println("delete");
            String db_menu=null;
            String url=null; 
            if(menu.equals("menu1")){
                db_menu = DataBaseConnection.DB_TABLE_MENU1;
            }else if(menu.equals("levelone")){
                db_menu = DataBaseConnection.DB_TABLE_MENU2;
            }else if(menu.equals("leveltwo")){
                db_menu = DataBaseConnection.DB_TABLE_MENU3;
            }else if(menu.equals("levelthree")){
                db_menu = DataBaseConnection.DB_TABLE_MENU4;
            }
            if(menu.equals("menu1")){
                ResultSet rs = db.getSt().executeQuery("select * from leveltwo where levelone='"+subject+"';");
                rs.beforeFirst();
                while(rs.next()){
                         ResultSet rs2 = db.getSt().executeQuery("select * from levelthree where leveltwo='"+rs.getString("name") +"';");
                         rs2.beforeFirst();
                         while(rs2.next()){
                             url = "DELETE FROM levelfour where levelthree='"+rs2.getString("name") +"';";
                             System.out.println("6"+url);
                             db.getSt().execute(url);
                             url = "DELETE FROM levelfourfiles where levelthree='"+rs2.getString("name") +"';";
                             System.out.println("6"+url);
                             db.getSt().execute(url);
                             
                         }
                         url = "DELETE FROM levelthree where leveltwo='"+rs.getString("name") +"';";
                         System.out.println("7"+url);
                         db.getSt().execute(url);
                         url = "DELETE FROM levelthreefiles where leveltwo='"+rs.getString("name") +"';";
                         System.out.println("7"+url);
                         db.getSt().execute(url);
                         rs2.close();
                }
                url = "DELETE FROM leveltwo where levelone='"+subject+"';";
                System.out.println("8"+url);
                db.getSt().execute(url);
                url = "DELETE FROM leveltwofiles where levelone='"+subject+"';";
                System.out.println("8"+url);
                db.getSt().execute(url);
                        
                ResultSet rs3 = db.getSt().executeQuery("select path from levelone where name='"+subject+"';");               
                rs3.next();
                File directory = new File(DataBaseConnection.DB_FILESPATH+rs3.getString("path"));
                if(!directory.exists()){
                   System.out.println("Directory does not exist.");
                   //System.exit(0);
                }else  deleteFolder(directory);
                rs3.close();
                      
                url = "DELETE FROM levelone where name='"+subject+"';";
                System.out.println("9"+url);
                db.getSt().execute(url); 
                rs.close();
                
            }
            if (menu.equals("levelone")){
                url = "select * from levelthree where leveltwo='"+subject+"';";
                ResultSet rs = db.getSt().executeQuery(url);
                System.out.println("hey"+url);
                rs.beforeFirst();
                while(rs.next()){
                         url = "DELETE FROM levelfour where levelthree='"+rs.getString("name") +"';";
                         db.getSt().execute(url);
                         url = "DELETE FROM levelfourfiles where levelthree='"+rs.getString("name") +"';";
                         System.out.println("hey2"+url);
                         db.getSt().execute(url); 
                }
                url = "DELETE FROM levelthree where leveltwo='"+subject+"';";
                db.getSt().execute(url);
                url = "DELETE FROM levelthreefiles where leveltwo='"+subject+"';";
                System.out.println("10"+url);
                db.getSt().execute(url);
                
                ResultSet rs3 = db.getSt().executeQuery("select path from leveltwo where name='"+subject+"';");               
                rs3.next();
                File directory = new File(DataBaseConnection.DB_FILESPATH+rs3.getString("path"));
                if(!directory.exists()){
                   System.out.println("Directory does not exist.");
                   //System.exit(0);
                }else  deleteFolder(directory);
                rs3.close();
                
                
                url = "DELETE FROM leveltwo where name='"+subject+"';";
                System.out.println("11"+url);
                db.getSt().execute(url);
                rs.close();
            }
            if (menu.equals("leveltwo")){
                 url = "DELETE FROM levelfour where levelthree='"+subject+"';";
                 System.out.println("12"+url);
                 db.getSt().execute(url);
                 url = "DELETE FROM levelfourfiles where levelthree='"+subject+"';";
                 System.out.println("12"+url);
                 db.getSt().execute(url);
                 
                ResultSet rs3 = db.getSt().executeQuery("select path from levelthree where name='"+subject+"';");               
                rs3.next();
                File directory = new File(DataBaseConnection.DB_FILESPATH+rs3.getString("path"));
                if(!directory.exists()){
                   System.out.println("Directory does not exist.");
                   //System.exit(0);
                }else  deleteFolder(directory);
                rs3.close(); 
                
                 url = "DELETE FROM levelthree where name='"+subject+"';";
                 System.out.println("13"+url);
                 db.getSt().execute(url);
            }
            if(menu.equals("levelthree")){
               ResultSet rs3 = db.getSt().executeQuery("select path from levelfour where name='"+subject+"';");               
               rs3.next();
               File directory = new File(DataBaseConnection.DB_FILESPATH+rs3.getString("path"));
               if(!directory.exists()){
                  System.out.println("Directory does not exist.");
                  //System.exit(0);
               }else  deleteFolder(directory);
               rs3.close();
               
               url = "DELETE FROM "+db_menu+" where name='"+subject+"';";
               System.out.println("14"+url);
               db.getSt().execute(url);
            }
           return "Success";      
    }
    public List GetWaitingList() throws SQLException{
        List list=new ArrayList();
        ResultSet rs = db.getSt().executeQuery("select * from "+DataBaseConnection.DB_TABLE_REQUEST+";");
        rs.beforeFirst();
        System.out.println("raftedge:D:D");
        while(rs.next()){
            System.out.println("raftedge:D:D"); 
              list.add(new WaitingListDetails(rs.getString("username"),rs.getString("password"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("email"),rs.getString("rol"),"0"));     
        }
        System.out.println("size: "+list.size());
        return list;
    }
    public List SetWaitingList( List list) throws SQLException{
        ResultSet rs = db.getSt().executeQuery("select * from "+DataBaseConnection.DB_TABLE_REQUEST+";");
        rs.beforeFirst();
        for(int i=0;i<list.size();i++){
            
            rs.next();
            //System.out.println("rs"+rs.getString("username"));
            WaitingListDetails temp = (WaitingListDetails) list.get(i);
            temp.setUsername(rs.getString("username"));
            temp.setPassword(rs.getString("password"));
            temp.setFirstName(rs.getString("FirstName"));
            temp.setLastName(rs.getString("LastName"));
            temp.setEmail(rs.getString("email"));
            temp.setRol(rs.getString("rol"));     
        }
        return list;
    }
    public void deleteFolder(File file) {
    	if(file.isDirectory()){
    		//directory is empty, then delete it
    		if(file.list().length==0){
 
    		   file.delete();
    		   System.out.println("Directory is deleted : " 
                                                 + file.getAbsolutePath());
 
    		}else{
 
    		   //list all the directory contents
        	   String files[] = file.list();
 
        	   for (String temp : files) {
        	      //construct the file structure
        	      File fileDelete = new File(file, temp);
 
        	      //recursive delete
        	     deleteFolder(fileDelete);
        	   }
 
        	   //check the directory again, if empty then delete it
        	   if(file.list().length==0){
           	     file.delete();
        	     System.out.println("Directory is deleted : " 
                                                  + file.getAbsolutePath());
        	   }
    		}
 
    	}else{
    		//if file, then delete it
    		file.delete();
    		System.out.println("File is deleted : " + file.getAbsolutePath());
    	}
    }
    public Vector<String> ChangeWaitingList(List list) throws SQLException{
        System.out.println("changeWaitingList");
        Vector<String> errors = new Vector<String>();
        for (int i=0;i<list.size();i++){
            WaitingListDetails item = new WaitingListDetails(null,null,null,null,null,null,null);
            item = (WaitingListDetails) list.get(i);
            if(item!=null){
                if (item.getAccept().equals("true")){
                    System.out.println(item.getFirstName());
                    errors.add(InsertNewMemberInfo(item));
                }else if(item.getAccept().equals("false")){
                    DeleteMemberRequest(item);
                }
            }
        }
        return errors;
    }
    public String InsertNewMemberInfo(WaitingListDetails item) throws SQLException{
        System.out.println("insert member info :"+item.getUsername()+item.getAccept());
        if(item.getUsername()!=null){
            String url = "select * from "+DataBaseConnection.DB_TABLE_USERINFO+" where username='"+item.getUsername()+"';";
            System.out.println("before"+url);
            ResultSet rs = db.getSt().executeQuery(url);
            if(!rs.next()){
                url = "select * from "+DataBaseConnection.DB_TABLE_USERINFO+" where email='"+item.getEmail()+"';";
                System.out.println(url);
                rs = db.getSt().executeQuery(url);
                if(!rs.next()){
                    
                    url ="INSERT INTO "+DataBaseConnection.DB_TABLE_USERINFO+" (username,password,firstName,lastName,email,rol)values('%s','%s','%s','%s','%s','%s');";
                    url = String.format(url,item.getUsername(),item.getPassword(),item.getFirstName(),item.getLastName(),item.getEmail(),item.getRol());
                    System.out.println("second"+url);
                    db.getSt().execute(url);
                    url ="INSERT INTO "+DataBaseConnection.DB_TABLE_LOGIN+" (username,password,rol)values('%s','%s','%s');";
                    url = String.format(url,item.getUsername(),item.getPassword(),item.getRol());
                    System.out.println("second"+url);
                    db.getSt().execute(url);
                    System.out.println("first"+url);
                    url = "DELETE FROM "+DataBaseConnection.DB_TABLE_REQUEST+" where username='"+item.getUsername()+"';";
                    System.out.println(url);
                    db.getSt().execute(url);
                    rs.close();
                    return "success";
                }else {
                    System.out.println("email");
                    rs.close();
                    return "Email";
                }   
            }else {
                    System.out.println("duplicate");
                    rs.close();
                    return "Duplicate";
            }
        }else {
            System.out.println("item was null");
            return "my";
                    }
        
    }
    public String DeleteMemberRequest(WaitingListDetails item) throws SQLException{
           String url = "DELETE FROM "+DataBaseConnection.DB_TABLE_REQUEST+" where username='"+item.getUsername()+"';";
           System.out.println(url);
           db.getSt().execute(url);
           return "success";      
    }
     public List GetMenuList(String levelup,String subject) throws SQLException{
        String level=null;
        if(levelup.equals("level")){
            level = DataBaseConnection.DB_TABLE_MENU1;
        }else if(levelup.equals("levelone")){
            level = DataBaseConnection.DB_TABLE_MENU2;
        }else if(levelup.equals("leveltwo")){
            level = DataBaseConnection.DB_TABLE_MENU3;
        }else if(levelup.equals("levelthree")){
            level = DataBaseConnection.DB_TABLE_MENU4;
        }
        String url = null;
        List list=new ArrayList();
        if(!levelup.equals("level"))
            url = "select * from "+level+" where "+levelup+"='"+subject+"';";
        else url = "select * from "+level+";";
        ResultSet rs = db.getSt().executeQuery(url);
        rs.beforeFirst();
        while(rs.next()){
            System.out.println("raftedgevahvah:D:Dhhhhhhhttttttttthh"+rs.getString("name"));
            list.add(new Menu1Details(rs.getString("name"),rs.getString("accept")));     
        }
        System.out.println("size: "+list.size());
        return list;
    }  
 
    public List GetMenu2files(String levelone) throws SQLException{
        List list=new ArrayList();
        String url = "select * from "+DataBaseConnection.DB_TABLE_FILES2+" where levelone='"+levelone+"';";
        ResultSet rs = db.getSt().executeQuery(url);
        rs.beforeFirst();
        while(rs.next()){
            System.out.println("raftedgevahvah:D:D");
            if(!rs.getString("accept").equals("false"))
              list.add(new FilesDetails(rs.getString("name"),rs.getString("path"),rs.getString("showfile"),rs.getString("typefile"),rs.getString("levelone")));     
        }
        System.out.println("size: "+list.size());
        return list;
    }
    public List GetMenu2filesWaiting(String levelone) throws SQLException{
        List list=new ArrayList();
        String url = "select * from "+DataBaseConnection.DB_TABLE_FILES2+" where levelone='"+levelone+"';";
        ResultSet rs = db.getSt().executeQuery(url);
        rs.beforeFirst();
        while(rs.next()){
            System.out.println("raftedgevahvah:D:D");
            if(rs.getString("accept").equals("false"))
              list.add(new FilesDetails(rs.getString("name"),rs.getString("path"),rs.getString("showfile"),rs.getString("typefile"),rs.getString("levelone")));     
        }
        System.out.println("size: "+list.size());
        return list;
    }   
    public List GetMenu3files(String levelone) throws SQLException{
        List list=new ArrayList();
        String url = "select * from "+DataBaseConnection.DB_TABLE_FILES3+" where leveltwo='"+levelone+"';";
        ResultSet rs = db.getSt().executeQuery(url);
        rs.beforeFirst();
        while(rs.next()){
            System.out.println("3333333333333333:D:D"); 
            if(!rs.getString("accept").equals("false"))
              list.add(new FilesDetails(rs.getString("name"),rs.getString("path"),rs.getString("showfile"),rs.getString("typefile"),rs.getString("leveltwo")));     
        }
        System.out.println("size: "+list.size());
        return list;
    }
        public List GetMenu3filesWaiting(String levelone) throws SQLException{
        List list=new ArrayList();
        String url = "select * from "+DataBaseConnection.DB_TABLE_FILES3+" where leveltwo='"+levelone+"';";
        ResultSet rs = db.getSt().executeQuery(url);
        rs.beforeFirst();
        while(rs.next()){
            System.out.println("3333333333333333:D:D");
            if(rs.getString("accept").equals("false"))
              list.add(new FilesDetails(rs.getString("name"),rs.getString("path"),rs.getString("showfile"),rs.getString("typefile"),rs.getString("leveltwo")));     
        }
        System.out.println("size: "+list.size());
        return list;
    }
  
    public List GetMenu4files(String levelone) throws SQLException{
        List list=new ArrayList();
        String url = "select * from "+DataBaseConnection.DB_TABLE_FILES4+" where levelthree='"+levelone+"';";
        ResultSet rs = db.getSt().executeQuery(url);
        rs.beforeFirst();
        while(rs.next()){
            System.out.println("3333333333333333:D:D"); 
            if(!rs.getString("accept").equals("false"))
            list.add(new FilesDetails(rs.getString("name"),rs.getString("path"),rs.getString("showfile"),rs.getString("typefile"),rs.getString("levelthree")));     
        }
        System.out.println("size: "+list.size());
        return list;
    }
        public List GetMenu4filesWaiting(String levelone) throws SQLException{
        List list=new ArrayList();
        String url = "select * from "+DataBaseConnection.DB_TABLE_FILES4+" where levelthree='"+levelone+"';";
        ResultSet rs = db.getSt().executeQuery(url);
        rs.beforeFirst();
        while(rs.next()){
            System.out.println("3333333333333333:D:D"); 
            if(rs.getString("accept").equals("false"))
            list.add(new FilesDetails(rs.getString("name"),rs.getString("path"),rs.getString("showfile"),rs.getString("typefile"),rs.getString("levelthree")));     
        }
        System.out.println("size: "+list.size());
        return list;
    }

    public void ChangeAcceptOfFile(String name, String accept, String toString,String levelup) throws SQLException {
            String db_menu = null;
            String url = null;
            if(levelup.equals("menu1")){
                db_menu = DataBaseConnection.DB_TABLE_MENU1;
            }else if(levelup.equals("levelone")){
                db_menu = DataBaseConnection.DB_TABLE_MENU2;
            }else if(levelup.equals("leveltwo")){
                db_menu = DataBaseConnection.DB_TABLE_MENU3;
            }else if(levelup.equals("levelthree")){
                db_menu = DataBaseConnection.DB_TABLE_MENU4;
            }
           if(accept.equals("delete")){
              url = "DELETE FROM %s where name='%s';"; 
              url = String.format(url,db_menu,name);
              System.out.println("delete1"+url);
           }else{
               url ="INSERT INTO %s where name='%s' (name,path,showfile,typefile,%s,accept)values(name,path,showfile,typefile,'%s','%s');";
               url = String.format(url,db_menu,name,levelup,levelup,accept);
               System.out.println("insert1"+url);
           }
           db.getSt().execute(url);
    }
    
    
    
}
