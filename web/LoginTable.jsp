<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>  
<%@page contentType="text/html" pageEncoding="UTF-8" %>

    <html:form action="/LoginAction"   >
    <html:errors locale="true" />
   <table id="LoginTable" >
       <tr><td>
ورود
        </td>
        <td></td>
       </tr>
        <tr>
          <td>
         نام کاربری            
          </td>
          <td>
              <html:text styleClass="click" property="username" size="10px" maxlength="20px"/>
          </td>
        </tr>
        <tr>
          <td>
     کلمه عبور
          </td>
          <td>
              <html:password styleClass="click" property="password" size="10px" maxlength="20px"/>
          </td>
        </tr>
        <tr>
          <td>
            <html:submit styleClass="click">
                ورود
            </html:submit>
          </td>
          <td>
            <html:cancel styleClass="click">
                بازنویسی
            </html:cancel>
          </td>
        </tr>
  </table>
   </html:form>
             <%
                //String name = request.getParameter( "username" );
                session.setAttribute( "username", "guest" );
            %>  
    
<html:link page="/Membering.do">
    برای عضویت کلیک کنید 
</html:link>