/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;
import java.sql.*;
/**
 *
 * @author shadi
 */
public class DataBaseConnection {
    private static final String DATABASE = "library";
    private static final String DBPASS = "fikpik";
    private static final String DBUSER = "root";
    public static final String DB_TABLE_USERINFO = "userinfo";
    public static final String DB_TABLE_REQUEST = "memrequest";
    public static final String DB_FILESPATH = "D:/java/my";
    public static final String DB_TABLE_LOGIN = "login";
    public static final String DB_TABLE_MENU1 = "levelone";
    public static final String DB_TABLE_MENU2 = "leveltwo";
    public static final String DB_TABLE_FILES2 = "leveltwofiles";
    public static final String DB_TABLE_MENU3 = "levelthree";
    public static final String DB_TABLE_FILES3 = "levelthreefiles";
    public static final String DB_TABLE_MENU4 = "levelfour";
    public static final String DB_TABLE_FILES4 = "levelfourfiles";
    
    private Statement st;
    private Connection connection;
    private static DataBaseConnection instance = null; 
   
    private DataBaseConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://localhost:3306/"+DATABASE+"?user="+DBUSER+"&password="+DBPASS;
        connection = DriverManager.getConnection(url);
        //st = connection.createStatement();
    }
   public static DataBaseConnection getInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
      if(instance == null) {
         instance = new DataBaseConnection();
      }
      return instance;
   }
    public void close() throws SQLException{
        st.close();
        connection.close();
    }
    public Statement getSt() throws SQLException {
        st = connection.createStatement();
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }
    
}
