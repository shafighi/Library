/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

/**
 *
 * @author shadi
 */
public class Menu1Details {
  private String name=null;
  private String accept=null;

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }
  
    public Menu1Details(String name,String accept) {
        setName((name));
        setAccept(accept);
    }
    public Menu1Details() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
