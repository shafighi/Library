 package Forms;


import java.util.List;
import org.apache.struts.action.*;
import org.apache.struts.upload.FormFile;



/**
* @author Amit Gupta
* @Web http://www.roseindia.net
* @Email struts@roseindia.net
*/

/**
 * Form bean for Struts File Upload.
 *
*/
public class UploadForm extends ActionForm
{
  private FormFile theFile;
  private List list=null;
  private String path=null;
  private String show=null;
  private String levelup=null;
  private String subject=null;
  private String accept=null;

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = (accept);
    }
  

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = (subject);
    }

    public String getLevelup() {
        return levelup;
    }

    public void setLevelup(String levelup) {
        this.levelup = (levelup);
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = (show);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = toUTF8.toUTF8(path);
    }
  
    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

  /**
 * @return Returns the theFile.
 */
  public FormFile getTheFile() {
  return theFile;
  }
  /**
 * @param theFile The FormFile to set.
 */
  public void setTheFile(FormFile theFile) {
  this.theFile = theFile;
  }
} 