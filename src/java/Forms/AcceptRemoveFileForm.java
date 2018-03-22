package Forms;
import DataBase.DataBaseAdminAccess;
import DataBase.DataBaseGuestAccess;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.*;
public class AcceptRemoveFileForm extends ActionForm
{
  
  DataBaseAdminAccess admin;
  private List list=null;
  private String accept= null;
  private String name= null;
  private String levelup = null;

    public String getLevelup() {
        return levelup;
    }

    public void setLevelup(String levelup) {
        this.levelup = levelup;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
  
    public List getList() {
        return list;
    }
    
    public void setList(List list) {
        System.out.println("set.ist");
        this.list = list;
    }
  
    public AcceptRemoveFileForm() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
    }
  /**
 * Reset all properties to their default values.
 *
 * @param mapping The mapping used to select this instance
 * @param request The servlet request we are processing
 */
  public void reset(ActionMapping mapping, HttpServletRequest request) {
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
      HttpSession session = request.getSession(true); 
      List list=(List) session.getAttribute("list");

        try {
                admin.ChangeAcceptOfFile(name,accept,session.getAttribute("submenu").toString(),levelup);
                DataBaseGuestAccess GuestAccess;
                GuestAccess = new DataBaseGuestAccess();
                list= GuestAccess.GetMenu1List();
                session.setAttribute("list",list);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AcceptRemoveFileForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AcceptRemoveFileForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AcceptRemoveFileForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AcceptRemoveFileForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        //errors.add("password",new ActionMessage("error."));
        return errors;
  }
}
