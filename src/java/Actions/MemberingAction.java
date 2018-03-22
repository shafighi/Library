package Actions;



import DataBase.DataBaseGuestAccess;
import Forms.MemberingForm;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class MemberingAction extends Action
{
  public ActionForward execute(
  ActionMapping mapping,
  ActionForm form,
  HttpServletRequest request,
  HttpServletResponse response) throws Exception{
      MemberingForm memberingForm =(MemberingForm)form;
      List list=null;
      HttpSession session = request.getSession(true); 
      if(session.getAttribute("list")==null){
          DataBaseGuestAccess GuestAccess = new DataBaseGuestAccess();
          list= GuestAccess.GetMenu1List();
          memberingForm.setList(list);
          session.setAttribute("list", list);
      }else{
          memberingForm.setList((List)session.getAttribute("list"));
      }
      memberingForm.validate(mapping, request);
      return mapping.findForward("MemberingSuccess");
  }
}