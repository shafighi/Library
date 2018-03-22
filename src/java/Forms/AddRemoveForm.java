package Forms;
import DataBase.DataBaseAdminAccess;
import DataBase.DataBaseGuestAccess;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.*;
public class AddRemoveForm extends ActionForm
{
  private String newSubject=null;
  private String deleteSubject=null;
  DataBaseAdminAccess admin;
  private List list=null;
  String menu;
  String accept;

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = (accept);
    }
    
    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = (menu);
    }

    public String getDeleteSubject() {
        return deleteSubject;
    }

    public void setDeleteSubject(String deleteSubject) {       
        this.deleteSubject = toUTF8.toUTF8(deleteSubject);
    }
    
    public List getList() {
        return list;
    }
    
    public String getNewSubject() {
        return newSubject;
    }

    public void setNewSubject(String newSubject) {
        this.newSubject =toUTF8.toUTF8(newSubject);
    }

    public void setList(List list) {
        System.out.println("set.ist");
        this.list = list;
    }
  
    public AddRemoveForm() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        admin= new DataBaseAdminAccess();
        }

  /**
 * Reset all properties to their default values.
 *
 * @param mapping The mapping used to select this instance
 * @param request The servlet request we are processing
 */
  public void reset(ActionMapping mapping, HttpServletRequest request) {
  this.newSubject=null;
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
      System.out.println("paskojast?"+deleteSubject+"ha?");
        try {
            String temp2 =null;
            if(newSubject.length()>0){
                if(menu==null)System.out.println("menu:");
                if(session.getAttribute("SubMenu")==null)System.out.println("session");
                if(newSubject==null)System.out.println("newsub");
                //System.out.println("addRemoveForm: "+menu+session.getAttribute("SubMenu").toString()+newSubject);
                System.out.println("menu"+menu);
                if(!menu.equals("menu1")){
                    System.out.println("salam"+menu+"salam");
                    temp2 = admin.AddNewSubject(menu,session.getAttribute("SubMenu").toString(),newSubject,getAccept());
                }
                else 
                    temp2 = admin.AddNewSubject(menu,null,newSubject,getAccept());
            }
            if(deleteSubject.length()>0){
                if(!menu.equals("menu1")){
                    temp2 = admin.DeleteSubject(menu,session.getAttribute("SubMenu").toString(),deleteSubject);
                    System.out.println("!=menu1");
                }
                else {
                    temp2 = admin.DeleteSubject(menu,null,deleteSubject);
                    System.out.println("==menu1");
                }
            }
            try {
                DataBaseGuestAccess GuestAccess;
                GuestAccess = new DataBaseGuestAccess();
                list= GuestAccess.GetMenu1List();
                session.setAttribute("list",list);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AddRemoveForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(AddRemoveForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(AddRemoveForm.class.getName()).log(Level.SEVERE, null, ex);
            }

            if(temp2.equals("Fail")){ 
                    errors.add("name", new ActionMessage("error."+temp2));
            }         
            } catch (SQLException ex) {
            Logger.getLogger(AddRemoveForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        //errors.add("password",new ActionMessage("error."));
        return errors;
  }
}
