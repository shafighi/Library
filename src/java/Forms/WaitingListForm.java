package Forms;




import DataBase.DataBaseAdminAccess;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
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
public class WaitingListForm extends ActionForm
{
  // privatae String accept = null;
   private List waitingList=null;
  //DataBaseGuestAccess newguest;
  // private static WaitingListForm instance = null; 
  /* public static WaitingListForm getInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
      if(instance == null) {
         instance = new WaitingListForm();
      }
      return instance;
   }*/
    private List list=null;

    
    public List getList() {
        return list;
    }
    public void setList(List list) {
        System.out.println("set.ist");
        this.list = list;
    }
    public WaitingListForm() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        // newguest= new DataBaseGuestAccess();
        waitingList = new ArrayList();
        //list.add("salam!!!!:D");
        System.out.println("salam!!!!:D");
    }
    public WaitingListDetails getData(int index)
    {
        // make sure that orderList is not null
        if(this.waitingList == null)
        {
            this.waitingList = new ArrayList();
        }
 
        // indexes do not come in order, populate empty spots
        while(index >= this.waitingList.size())
        {
            this.waitingList.add(new WaitingListDetails(null, null, null, null, null, null, null));
        }
 
        // return the requested item
        return (WaitingListDetails) waitingList.get(index);
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
   
    public List getWaitingList() {
        return waitingList;
    }

    public void setWaitingList(List list) {
        System.out.println("set.waitinglist");
        this.waitingList = list;
    }

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
        ActionErrors errors = new ActionErrors();
        HttpSession session = request.getSession(true);
        try {
            if(waitingList!=null){
                
                System.out.println("too action formim alan");
                DataBaseAdminAccess AdminAction = new DataBaseAdminAccess();
                System.out.println(AdminAction.SetWaitingList(waitingList));
                Vector<String> error = AdminAction.ChangeWaitingList(AdminAction.SetWaitingList(waitingList));
                for(int i=0;i<error.size();i++){
                    if(!error.get(i).equals("success"))
                        errors.add(error.get(i),new ActionMessage("error."+error.get(i)));
                }
                
            }
             if(waitingList.size()!=0){session.setAttribute("waitingList","true");}else session.setAttribute("waitingList","false");
            session.setAttribute("form", "WaitingListForm");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WaitingListForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(WaitingListForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(WaitingListForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(WaitingListForm.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return errors;
  }
}
