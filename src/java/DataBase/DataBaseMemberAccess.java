/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Forms.FilesDetails;
import Forms.Menu1Details;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shadi
 */
public class DataBaseMemberAccess {

    DataBaseConnection db ;

    public DataBaseMemberAccess() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException  {
        db = DataBaseConnection.getInstance();
    }
    public String getPath(String levelup,String Subject) throws SQLException{
        ResultSet rs = db.getSt().executeQuery("select path from "+levelup+" where name='"+Subject+"';");               
        rs.next();
        return rs.getString("path");
    }
    
    /* 
     * when a person request to be member we insert his/her 
     * request to request table that admin should accept them 
     * later
     * check if there is same username or email ----------------------->should 
     * login table chack nashode
     */

    public String ChangeMemberPass(String username,String PrePassword,String password) throws SQLException {
        String url = "select * from "+DataBaseConnection.DB_TABLE_LOGIN+" WHERE username='"+username+"';";
        ResultSet rs = db.getSt().executeQuery(url);
        System.out.println("salaaaaa"+username);
        if(!rs.next()){
            System.out.println("va !"+password);
            return "null";
        }else if(rs.getString("password").compareTo(PrePassword)==0){
              System.out.println("hello");
              //url ="INSERT INTO "+DB_TABLE_LOGIN+" (username,password,rol) SELECT (username,'"+password+"',rol) FROM "+DB_TABLE_LOGIN+" WHERE username = '"+username+"';";
              url = "UPDATE "+DataBaseConnection.DB_TABLE_LOGIN+" SET password='"+password+"' WHERE username='"+username+"';";
              System.out.println(url);
              db.getSt().executeUpdate(url);
              return "changed";
            }else{
            System.out.println("mage mishe ?");
                return("wrongPassword");        
            }
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
        public List GetMenu1List() throws SQLException{
        List list=new ArrayList();
        String url = "select * from "+DataBaseConnection.DB_TABLE_MENU1+";";
        ResultSet rs = db.getSt().executeQuery(url);
        rs.beforeFirst();
        while(rs.next()){
            if(rs.getString("accept").equals("member")||rs.getString("accept").equals("guest")) 
              list.add(new Menu1Details(rs.getString("name"),rs.getString("accept")));     
        }
        System.out.println("size: "+list.size());
        return list;
    }
    public List GetMenu2List(String levelone) throws SQLException{
        List list=new ArrayList();
        String url = "select * from "+DataBaseConnection.DB_TABLE_MENU2+" where levelone='"+levelone+"';";
        ResultSet rs = db.getSt().executeQuery(url);
        rs.beforeFirst();
        while(rs.next()){
            if(rs.getString("accept").equals("member")||rs.getString("accept").equals("guest")) 
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
            if(rs.getString("accept").equals("member")||rs.getString("accept").equals("guest"))
              list.add(new FilesDetails(rs.getString("name"),rs.getString("path"),rs.getString("showfile"),rs.getString("typefile"),rs.getString("levelone")));     
        }
        System.out.println("size: "+list.size());
        return list;
    }
    public List GetMenu3List(String levelone) throws SQLException{
        List list=new ArrayList();
        String url = "select * from "+DataBaseConnection.DB_TABLE_MENU3+" where leveltwo='"+levelone+"';";
        ResultSet rs = db.getSt().executeQuery(url);
        rs.beforeFirst();
        while(rs.next()){
            System.out.println("333333333333:D:D"); 
            if(rs.getString("accept").equals("member")||rs.getString("accept").equals("guest"))
              list.add(new Menu1Details(rs.getString("name"),rs.getString("accept")));     
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
            if(rs.getString("accept").equals("member")||rs.getString("accept").equals("guest"))
              list.add(new FilesDetails(rs.getString("name"),rs.getString("path"),rs.getString("showfile"),rs.getString("typefile"),rs.getString("leveltwo")));     
        }
        System.out.println("size: "+list.size());
        return list;
    }
   public List GetMenu4List(String levelone) throws SQLException{
        List list=new ArrayList();
        String url = "select * from "+DataBaseConnection.DB_TABLE_MENU4+" where levelthree='"+levelone+"';";
        ResultSet rs = db.getSt().executeQuery(url);
        rs.beforeFirst();
        while(rs.next()){
            System.out.println("333333333333:D:D"); 
            if(rs.getString("accept").equals("member")||rs.getString("accept").equals("guest"))
              list.add(new Menu1Details(rs.getString("name"),rs.getString("accept")));     
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
            if(rs.getString("accept").equals("member")||rs.getString("accept").equals("guest"))
              list.add(new FilesDetails(rs.getString("name"),rs.getString("path"),rs.getString("showfile"),rs.getString("typefile"),rs.getString("levelthree")));     
        }
        System.out.println("size: "+list.size());
        return list;
    }
}
