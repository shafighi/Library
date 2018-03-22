package Forms;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class Menu1Form extends ActionForm
{
  // privatae String accept = null;
   private List list=null;
       public List getList() {
        return list;
    }

    public void setList(List list) {
        System.out.println("set.ist");
        this.list = list;
    }
  //DataBaseGuestAccess newguest;
  // private static WaitingListForm instance = null; 
  /* public static WaitingListForm getInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
      if(instance == null) {
         instance = new WaitingListForm();
      }
      return instance;
   }*/
    public Menu1Form() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        // newguest= new DataBaseGuestAccess();
        list = new ArrayList();
        //list.add("salam!!!!:D");
        System.out.println("salam!!!!:D");
    }
    public Menu1Details getData(int index)
    {
        // make sure that orderList is not null
        if(this.list == null)
        {
            this.list = new ArrayList();
        }
 
        // indexes do not come in order, populate empty spots
        while(index >= this.list.size())
        {
            this.list.add(new Menu1Details(null,null));
        }
 
        // return the requested item
        return (Menu1Details) list.get(index);
    }

   /* public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        System.out.println("miad ya na?");
        this.accepts.add(accept);
        this.accept = accept;
    }
*/
   


  /**
 * Reset all properties to their default values.
 *
 * @param mapping The mapping used to select this instance
 * @param request The servlet request we are processing
 */
  public void reset(ActionMapping mapping, HttpServletRequest request) {
  this.list=null;

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
        HttpSession session = request.getSession(true); 
        session.setAttribute("form", "Menu1Form");
        session.setAttribute("levelUp", "level");
        ActionErrors errors = new ActionErrors();
        return errors;
  }
  
}
