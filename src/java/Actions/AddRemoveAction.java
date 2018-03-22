package Actions;
import DataBase.DataBaseGuestAccess;
import Forms.AddRemoveForm;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
public class AddRemoveAction extends Action
{
  public ActionForward execute(
  ActionMapping mapping,
  ActionForm form,
  HttpServletRequest request,
  HttpServletResponse response) throws Exception{
      //DataBaseValidityLoginForm ServerLoginForm = new LoginForm();
      //DynaValidatorForm LoginForm = (DynaValidatorForm) form;
      //ServerLoginForm.setUsername(LoginForm.get("username").toString());
      //ServerLoginForm.setPassword(LoginForm.get("password").toString());
      //ServerLoginForm.validate(mapping, request);
      AddRemoveForm AddRemoveForm =(AddRemoveForm) form;
      List list=null;
      HttpSession session = request.getSession(true); 
      if(session.getAttribute("list")==null){
          DataBaseGuestAccess GuestAccess = new DataBaseGuestAccess();
          list= GuestAccess.GetMenu1List();
          AddRemoveForm.setList(list);
          session.setAttribute("list", list);
      }else{
          AddRemoveForm.setList((List)session.getAttribute("list"));
      }
      //ServerLoginForm.validate(mapping, request);
      return mapping.findForward(AddRemoveForm.getMenu());
    //BeanUtils.copyProperties( LoginForm, contact );
  }
}