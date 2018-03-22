package Forms;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.*;

public class SubMenuForm extends ActionForm
{
   private String linkName = null;
   private List list=null;
       public List getList() {
        return list;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        System.out.println("setLinkName: "+linkName);
        this.linkName = (linkName);
    }
    
    public void setList(List list) {
        System.out.println("set.ist");
        this.list = list;
    }

    public SubMenuForm() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        // newguest= new DataBaseGuestAccess();
        list = new ArrayList();
        //list.add("salam!!!!:D");
        System.out.println("salam!!!!:D");
    }

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
        System.out.println("linkName"+toUTF8.toUTF8(linkName));
        session.setAttribute("SubMenu",toUTF8.toUTF8(linkName));
        //session.setAttribute("levelUp","levelone");
        ActionErrors errors = new ActionErrors();
        return errors;
  }
  
}
