package Actions;
import DataBase.DataBaseGuestAccess;
import Forms.ChangePassForm;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
public class ChangePassAction extends Action
{
  public ActionForward execute(
  ActionMapping mapping,
  ActionForm form,
  HttpServletRequest request,
  HttpServletResponse response) throws Exception{
            ChangePassForm changePassForm =(ChangePassForm) form;
      List list=null;
      HttpSession session = request.getSession(true); 
      if(session.getAttribute("list")==null){
          DataBaseGuestAccess GuestAccess = new DataBaseGuestAccess();
          list= GuestAccess.GetMenu1List();
          changePassForm.setList(list);
          session.setAttribute("list", list);
      }else{
          changePassForm.setList((List)session.getAttribute("list"));
      }
      changePassForm.validate(mapping, request);
      if(session.getAttribute("rol").equals("member")){
         return mapping.findForward("MemberChangePassSuccess");
      }else if(session.getAttribute("rol").equals("admin")){
         return mapping.findForward("AdminChangePassSuccess");
      }else return mapping.findForward("ChangePassSuccess");
  }
}