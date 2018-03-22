package Forms;




import DataBase.DataBaseGuestAccess;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.*;


/**
* @author Deepak Kumar
* @Web http://www.roseindia.net
* @Email roseindia_net@yahoo.com
*/

/**
 * Form bean for the Address Entry Screen.
 *
*/
public class LoginForm extends ActionForm
{
  private String username=null;
  private String password=null;
  private String rol=null;
  DataBaseGuestAccess newguest;
     private List list=null;
       public List getList() {
        return list;
    }

    public void setList(List list) {
        System.out.println("set.ist");
        this.list = list;
    }
  
    public LoginForm() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
         newguest= new DataBaseGuestAccess();
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = (rol);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = (password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = (username);
    }


  

  /**
 * Reset all properties to their default values.
 *
 * @param mapping The mapping used to select this instance
 * @param request The servlet request we are processing
 */
  public void reset(ActionMapping mapping, HttpServletRequest request) {
  this.username=null;
  this.password=null;
  }

  /**
 * Reset all properties to their default values.
 *
 * @param mapping The mapping used to select this instance
 * @param request The servlet request we are processing
 * @return errors
 */
  public ActionErrors validate( 
  ActionMapping mapping, HttpServletRequest request ) {
            ActionErrors errors = new ActionErrors(); 
           // ActionErrors errors = super.validate(mapping, request);
        try {
            String result = newguest.CheckUserPass(getUsername(),getPassword());
            System.out.println(result);
            setRol(result);
            HttpSession session = request.getSession(true); 
            session.setAttribute("rol", rol);
            if((result.compareTo("member")!=0 && result.compareTo("admin")!=0)){ 
                System.out.println("form"+result);
                if(result.equals("wrongPassword")){
                    errors.add("password",new ActionMessage("error."+result));
                }
                else errors.add("username",new ActionMessage("error."+result));
            }else setRol(result);
            session.setAttribute("form", "LoginForm");

        } catch (SQLException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(errors+"hey");
        return errors;
  }
}
