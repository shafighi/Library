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

public class Menu1Action extends Action
{
  public ActionForward execute(
  ActionMapping mapping,
  ActionForm form,
  HttpServletRequest request,
  HttpServletResponse response) throws Exception{
      Menu1Form menu1Form =(Menu1Form)form;
      List list=null;
      HttpSession session = request.getSession(true); 
      session.setAttribute("rol","guest");
      session.setAttribute("username","guest");
      if(session.getAttribute("list")==null){
          DataBaseGuestAccess GuestAccess = new DataBaseGuestAccess();
          list= GuestAccess.GetMenu1List();
          menu1Form.setList(list);
          session.setAttribute("list", list);
      }else{
          menu1Form.setList((List)session.getAttribute("list"));
      }
      menu1Form.validate(mapping, request);


      return mapping.findForward("Success");
  }
}