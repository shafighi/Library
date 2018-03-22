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
public class DataBaseGuestAccess {
    private static final String DATABASE = "library";
    private static final String DBPASS = "fikpik";
    private static final String DBUSER = "root";
    public static final String DB_TABLE_USERINFO = "userinfo";
    public static final String DB_TABLE_REQUEST = "memrequest";
    public static final String DB_TABLE_LOGIN = "login";
    public static final String DB_TABLE_MENU1 = "levelone";
    public static final String DB_TABLE_MENU2 = "leveltwo";
    public static final String DB_TABLE_FILES2 = "leveltwofiles";
    public static final String DB_TABLE_MENU3 = "levelthree";
    public static final String DB_TABLE_FILES3 = "levelthreefiles";
    public static final String DB_TABLE_MENU4 = "levelfour";
    public static final String DB_TABLE_FILES4 = "levelfourfiles";

    DataBaseConnection db ;

    public DataBaseGuestAccess() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException  {
        db = DataBaseConnection.getInstance();
    }
    /* 
     * when a person request to be member we insert his/her 
     * request to request table that admin should accept them 
     * later
     * check if there is same username or email ----------------------->should 
     * login table chack nashode
     */
    public String InsertNewMemberRequest(String username,String password,String firstName,String lastName,String email,String rol)throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{        
        if(CheckInfoValidity(username, password, firstName, lastName, email, rol)){
            ResultSet rs = db.getSt().executeQuery("select * from "+DB_TABLE_REQUEST+" where username='"+username+"';");
            if(!rs.next()){
                rs = db.getSt().executeQuery("select * from "+DB_TABLE_REQUEST+" where email='"+email+"';");
                if(!rs.next()){
                    String url ="INSERT INTO "+DB_TABLE_REQUEST+" (username,password,firstName,lastName,email,rol)values('%s','%s','%s','%s','%s','%s');";
                    url = String.format(url,username,password,firstName,lastName,email,rol);
                    System.out.println("membering: "+url);
                    db.getSt().execute(url);
                    rs.close();
                    return "success";
                }else {
                    rs.close();
                    return "Email";
                }   
            }else {
                    rs.close();
                    return "Duplicate";
            }
            
        }else {
            return "EmailForm";
        }
    }
    /*
     * --------------------------->should remove prints after completing 
     * check illegal chars ------------------------------->should implement
     * check illegal mail (whithout @)
     * check illegal rol (but member,admin,manager)
     */
    private boolean CheckInfoValidity(String username,String password,String firstName,String lastName,String email,String rol){        
       /* if(rol.compareTo("member")!=0 && rol.compareTo("admin")!=0 && rol.compareTo("manager")!=0){
            System.out.println("the rol is not valid");
            return false;
        }else*/
        if(!(email.contains("@yahoo.com") || email.contains("@gmail.com"))){
            System.out.println("the mail is not valid");
            return false;
        }else
            return true;
    }
    /*
     * --------------------------->should remove prints after completing 
     * check in userinfo table 
     * show if user is not there or pass is incorrect and link to membering-------------->should implement
     * if user pass is correct change rol -------------------->should implement
     * check request table
     * show if user is there that should be accept by admin---------------->should implement
     * show  if pass is incorrect ------------------>should implement
     * 
     */
    public String CheckUserPass(String username,String password) throws SQLException {
        String url = "select * from "+DB_TABLE_LOGIN+" WHERE username='"+username+"';";
        ResultSet rs = db.getSt().executeQuery(url);
        if(!rs.next()){
            rs = db.getSt().executeQuery("select * from "+DB_TABLE_REQUEST+" WHERE username='"+username+"';");
            if(rs.next()){
                if(rs.getString("password").compareTo(password)==0){
                    return("adminW8ing");
                    
                }else {
                   return("wrongPassword");
                     
                }
            }else{
                System.out.println("notmember in data base guest access !");
                return("notMember");
                
            }
        }else{
            if(rs.getString("password").compareTo(password)==0){
                return(rs.getString("rol"));
                //change roll
                
            }else{
                return("wrongPassword");
                
            }
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
        String url = "select * from "+DB_TABLE_MENU1+";";
        ResultSet rs = db.getSt().executeQuery(url);
        rs.beforeFirst();
        while(rs.next()){
            System.out.println("raftedgevahvah:D:D");
            if(rs.getString("accept").equals("guest"))
              list.add(new Menu1Details(rs.getString("name"),rs.getString("accept")));     
        }
        System.out.println("size: "+list.size());
        return list;
    }
    public List GetMenu2List(String levelone) throws SQLException{
        List list=new ArrayList();
        String url = "select * from "+DB_TABLE_MENU2+" where levelone='"+levelone+"';";
        ResultSet rs = db.getSt().executeQuery(url);
        rs.beforeFirst();
        while(rs.next()){
            System.out.println("raftedgevahvah:D:D");
            if(rs.getString("accept").equals("guest"))
              list.add(new Menu1Details(rs.getString("name"),rs.getString("accept")));     
        }
        System.out.println("size: "+list.size());
        return list;
    }    
    public List GetMenu2files(String levelone) throws SQLException{
        List list=new ArrayList();
        String url = "select * from "+DB_TABLE_FILES2+" where levelone='"+levelone+"';";
        ResultSet rs = db.getSt().executeQuery(url);
        rs.beforeFirst();
        while(rs.next()){
            System.out.println("raftedgevahvah:D:D");
            if(rs.getString("accept").equals("guest"))
              list.add(new FilesDetails(rs.getString("name"),rs.getString("path"),rs.getString("showfile"),rs.getString("typefile"),rs.getString("levelone")));     
        }
        System.out.println("size: "+list.size());
        return list;
    }
    public List GetMenu3List(String levelone) throws SQLException{
        List list=new ArrayList();
        String url = "select * from "+DB_TABLE_MENU3+" where leveltwo='"+levelone+"';";
        ResultSet rs = db.getSt().executeQuery(url);
        rs.beforeFirst();
        while(rs.next()){
            System.out.println("333333333333:D:D"); 
            if(rs.getString("accept").equals("guest"))
              list.add(new Menu1Details(rs.getString("name"),rs.getString("accept")));     
        }
        System.out.println("size: "+list.size());
        return list;
    }    
    public List GetMenu3files(String levelone) throws SQLException{
        List list=new ArrayList();
        String url = "select * from "+DB_TABLE_FILES3+" where leveltwo='"+levelone+"';";
        ResultSet rs = db.getSt().executeQuery(url);
        rs.beforeFirst();
        while(rs.next()){
            System.out.println("3333333333333333:D:D"); 
            if(rs.getString("accept").equals("guest"))
              list.add(new FilesDetails(rs.getString("name"),rs.getString("path"),rs.getString("showfile"),rs.getString("typefile"),rs.getString("leveltwo")));     
        }
        System.out.println("size: "+list.size());
        return list;
    }
   public List GetMenu4List(String levelone) throws SQLException{
        List list=new ArrayList();
        String url = "select * from "+DB_TABLE_MENU4+" where levelthree='"+levelone+"';";
        ResultSet rs = db.getSt().executeQuery(url);
        rs.beforeFirst();
        while(rs.next()){
            System.out.println("333333333333:D:D"); 
            if(rs.getString("accept").equals("guest"))
              list.add(new Menu1Details(rs.getString("name"),rs.getString("accept")));     
        }
        System.out.println("size: "+list.size());
        return list;
    }    
    public List GetMenu4files(String levelone) throws SQLException{
        List list=new ArrayList();
        String url = "select * from "+DB_TABLE_FILES4+" where levelthree='"+levelone+"';";
        ResultSet rs = db.getSt().executeQuery(url);
        rs.beforeFirst();
        while(rs.next()){
            System.out.println("3333333333333333:D:D"); 
            if(rs.getString("accept").equals("guest"))
              list.add(new FilesDetails(rs.getString("name"),rs.getString("path"),rs.getString("showfile"),rs.getString("typefile"),rs.getString("levelthree")));     
        }
        System.out.println("size: "+list.size());
        return list;
    }
    
}
