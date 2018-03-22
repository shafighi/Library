package Forms;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
public class WaitingListSubmitForm extends ActionForm
{

  private List accept=null;
  //DataBaseGuestAccess newguest;
  
    public WaitingListSubmitForm() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        // newguest= new DataBaseGuestAccess();
        accept = new ArrayList();
        //list.add("salam!!!!:D");
        System.out.println("salam!!!!:D");
    }

    public List getAccept() {
        return accept;
    }

    public void setAccept(List accept) {
        this.accept = accept;
    }




  /**
 * Reset all properties to their default values.
 *
 * @param mapping The mapping used to select this instance
 * @param request The servlet request we are processing
 */
  public void reset(ActionMapping mapping, HttpServletRequest request) {
  this.accept=null;

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
        System.out.println("chi shode?ey baba222!");
        return errors;
  }
}
