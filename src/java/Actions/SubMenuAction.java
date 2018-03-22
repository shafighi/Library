package Actions;
import DataBase.DataBaseAdminAccess;
import DataBase.DataBaseGuestAccess;
import Forms.Menu1Form;
import Forms.WaitingListDetails;
import Forms.WaitingListForm;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SubMenuAction extends Action
{
  public ActionForward execute(
  ActionMapping mapping,
  ActionForm form,
  HttpServletRequest request,
  HttpServletResponse response) throws Exception{
      List list=null;
      HttpSession session = request.getSession(true); 
      if(session.getAttribute("list")==null){
          DataBaseGuestAccess GuestAccess = new DataBaseGuestAccess();
          list= GuestAccess.GetMenu1List();
          session.setAttribute("list", list);
      }
      System.out.println("actionsubmenu");
      String level = session.getAttribute("levelUp").toString();
      if(level.equals("level")){
          session.setAttribute("levelUp", "levelone");
      }else
      if(level.equals("levelone")){
          session.setAttribute("levelUp", "leveltwo");
      }else
      if(level.equals("leveltwo")){
          session.setAttribute("levelUp", "levelthree");
      }else 
      if(level.equals("levelthree")){
          session.setAttribute("levelUp","levelfour");
      }
                  
      return mapping.findForward("success");
  }
}