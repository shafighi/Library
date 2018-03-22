/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

/**
 *
 * @author shadi
 */
public class WaitingListDetails {
  private String username=null;
  private String password=null;
  private String firstName=null;
  private String lastName=null;
  private String email=null;
  private String rol=null;
  private String accept=null;

   public  WaitingListDetails(String username, String password, String firstName, String lastName, String email, String rol,String accept) {
        System.out.println("waitinglistdetails"); 
        setUsername((username));
        setPassword((password));
        setFirstName((firstName));
        setLastName((lastName));
        setEmail((email));
        setRol((rol));
        setAccept((accept));  
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        System.out.println(firstName+"detail:"+accept);
        this.accept = accept;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
  
}
