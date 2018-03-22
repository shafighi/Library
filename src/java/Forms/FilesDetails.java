/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

/**
 *
 * @author shadi
 */
public class FilesDetails {
  private String name=null;
  private String path=null;
  private String show=null;
  private String type=null;
  private String levelone=null;
  private String accept = null;


    public FilesDetails(String name,String path ,String show,String type,String levelone) {
        
        setName((name));
        setLevelone((levelone));
        setPath((path));
        setShow((show));
        setType((type));
    }
    public FilesDetails() {
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = (accept);
    }
    
    public String getLevelone() {
        return levelone;
    }

    public void setLevelone(String levelone) {
        this.levelone =(levelone);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = (path);
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = (show);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = (type);
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = (name);
    }
}
