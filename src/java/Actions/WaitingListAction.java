package Actions;
import DataBase.DataBaseAdminAccess;
import DataBase.DataBaseGuestAccess;
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

public class WaitingListAction extends Action
{
  public ActionForward execute(
  ActionMapping mapping,
  ActionForm form,
  HttpServletRequest request,
  HttpServletResponse response) throws Exception{
      DataBaseAdminAccess AdminAccess = new DataBaseAdminAccess();
      List WaitingList= AdminAccess.GetWaitingList();
      WaitingListForm WaitingListForm =(WaitingListForm)form;
      WaitingListForm.validate(mapping, request);
      WaitingListForm.setWaitingList(WaitingList);
      
      List list=null;
      HttpSession session = request.getSession(true); 
      if(session.getAttribute("list")==null){
          DataBaseGuestAccess GuestAccess = new DataBaseGuestAccess();
          list= GuestAccess.GetMenu1List();
          WaitingListForm.setList(list);
          session.setAttribute("list", list);
      }else{
          WaitingListForm.setList((List)session.getAttribute("list"));
      }
      //session.setAttribute("form", "WaitingListForm");
      if(session.getAttribute("waitingList").equals("false")){
          System.out.println("WaitingListNullSuccess");
                    return mapping.findForward("WaitingListNullSuccess");
       }
                System.out.println("WaitingListSuccess");
      return mapping.findForward("WaitingListSuccess");
  }
}