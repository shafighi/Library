package Actions;
import DataBase.DataBaseAdminAccess;
import DataBase.DataBaseConnection;
import DataBase.DataBaseGuestAccess;
import Forms.UploadForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import java.io.*;
import java.util.List;
import javax.servlet.http.HttpSession;
/**

* @author Amit Gupta

* @Web http://www.roseindia.net

* @Email struts@roseindia.net

*/



/**

 * Struts File Upload Action Form.

 *

*/
public class UploadAction extends Action
{
  public ActionForward execute(
  ActionMapping mapping,
  ActionForm form,
  HttpServletRequest request,
  HttpServletResponse response) throws Exception{

      UploadForm uploadForm = (UploadForm)form;
      List list=null;
      HttpSession session = request.getSession(true); 
      if(session.getAttribute("list")==null){
          DataBaseGuestAccess GuestAccess = new DataBaseGuestAccess();
          list= GuestAccess.GetMenu1List();
          uploadForm.setList(list);
          session.setAttribute("list", list);
      }else{
          uploadForm.setList((List)session.getAttribute("list"));
      }
      //session.setAttribute("form", "UploadForm");


  // Process the FormFile
  FormFile myFile = uploadForm.getTheFile();
  String contentType = myFile.getContentType();
  //Get the file name
  String fileName  = myFile.getFileName();
  //int fileSize = myFile.getFileSize();
  byte[] fileData  = myFile.getFileData();
  
  //Get the servers upload directory real path name
 // String filePath = getServlet().getServletContext().getRealPath("/") +"upload";
  String filePath = DataBaseConnection.DB_FILESPATH+uploadForm.getPath();
  
  
  
  DataBaseAdminAccess AdminAccess = new DataBaseAdminAccess();
  System.out.println("hhhhhhhh"+uploadForm.getAccept());
  AdminAccess.setNewFile(fileName, filePath, uploadForm.getShow(),myFile.getContentType(),uploadForm.getLevelup(),session.getAttribute("SubMenu").toString(),uploadForm.getAccept());

  /* Save file on the server */
  if(!fileName.equals("")){  
      System.out.println("Server path:" +filePath);
      //Create file
      File fileToCreate = new File(filePath, fileName);
      //If file does not exists create file  
      if(!fileToCreate.exists()){
          FileOutputStream fileOutStream = new FileOutputStream(fileToCreate);
          fileOutStream.write(myFile.getFileData());
          fileOutStream.flush();
          fileOutStream.close();
      } 
  }
  //Set file name to the request object
  request.setAttribute("fileName",fileName);
  if(session.getAttribute("rol").equals("admin"))
    return mapping.findForward("AdminSuccess");
  else if(session.getAttribute("rol").equals("member"))
    return mapping.findForward("MemberSuccess");
  else return mapping.findForward("Success");
  }
} 