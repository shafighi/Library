package Forms;




import DataBase.DataBaseGuestAccess;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
import org.apache.struts.Globals;
import org.apache.struts.action.*;
import org.apache.struts.validator.ValidatorForm;

/**
 * Form bean for the Address Entry Screen.
 *
*/
public class MemberingForm extends ActionForm
{
  private String username=null;
  private String password=null;
  private String password2=null;
  private String firstName=null;
  private String lastName=null;
  private String email=null;
  DataBaseGuestAccess newguest;
     private List list=null;
       public List getList() {
        return list;
    }

    public void setList(List list) {
        System.out.println("set.ist");
        this.list = list;
    }
  
    public MemberingForm() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
         newguest= new DataBaseGuestAccess();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String LastName) {
        this.lastName = (LastName);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = (email);
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = (password2);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = (username);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String FirstName) {
        this.firstName = (FirstName);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = (password);
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
  this.firstName=null;
  this.lastName=null;
  this.email=null;
  this.password2=null;
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
        try {
            if(password.equals(password2)){
                String result = newguest.InsertNewMemberRequest(username, password, firstName, lastName, email,"member");
                if(result.compareTo("success")!=0){               
                    errors.add("username",new ActionMessage("error."+result));
                }
            }else errors.add("PassCompare",new ActionMessage("error.PassCompare"));
        HttpSession session = request.getSession(true); 
        session.setAttribute("form", "MemberingForm");

            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MemberingForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MemberingForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MemberingForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return errors;
  }
}
