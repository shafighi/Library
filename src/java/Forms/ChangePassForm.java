package Forms;




import DataBase.DataBaseGuestAccess;
import DataBase.DataBaseMemberAccess;
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
* @author Deepak Kumar
* @Web http://www.roseindia.net
* @Email roseindia_net@yahoo.com
*/

/**
 * Form bean for the Address Entry Screen.
 *
*/
public class ChangePassForm extends ValidatorForm
{
  private String rol=null;
  private String prePass=null;
  private String newPass=null;
  private String reNewPass=null;
  DataBaseGuestAccess newguest;
     private List list=null;
       public List getList() {
        return list;
    }

    public void setList(List list) {
        System.out.println("set.ist");
        this.list = list;
    }
  
    public ChangePassForm() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
         newguest= new DataBaseGuestAccess();
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String NewPass) {
        this.newPass = (NewPass);
    }

    public String getPrePass() {
        return prePass;
    }

    public void setPrePass(String PrePass) {
        this.prePass = (PrePass);
    }

    public String getReNewPass() {
        return reNewPass;
    }

    public void setReNewPass(String ReNewPass) {
        this.reNewPass = (ReNewPass);
    }


  /**
 * Reset all properties to their default values.
 *
 * @param mapping The mapping used to select this instance
 * @param request The servlet request we are processing
 */
  public void reset(ActionMapping mapping, HttpServletRequest request) {
  this.prePass=null;
  this.newPass=null;
  this.reNewPass=null;
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
                                            
            //String result = newguest.CheckUserPass();
            // System.out.println(result);
            HttpSession session = request.getSession(true); 
            if (session.getAttribute("password").equals(getPrePass())){
               if(getNewPass().equals(getReNewPass())){
                System.out.println(session.getAttribute("password"));
                DataBaseMemberAccess member = new DataBaseMemberAccess();
                member.ChangeMemberPass(session.getAttribute("username").toString(),getPrePass(), getNewPass());
               }else errors.add("PrePass",new ActionMessage("error.RePassIncorrect"));
            session.setAttribute("form", "ChangePassForm");
            }else errors.add("PrePass",new ActionMessage("error.PrePassIncorrect"));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ChangePassForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(ChangePassForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ChangePassForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ChangePassForm.class.getName()).log(Level.SEVERE, null, ex);
            }
          
           // if(result.compareTo("success")!=0 ){        
                
             //    errors.add("username",new ActionMessage("error."+result));
           // }
           
        return errors;
  }
}
