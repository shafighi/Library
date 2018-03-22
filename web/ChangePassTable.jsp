<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>  
<%@page contentType="text/html" pageEncoding="UTF-8" %>

    <html:form action="/ChangePassAction"   >
    <html:errors locale="true" />
   <table id="ChangePassTable" >
        <tr>
          <td align="center" colspan="2">
                <font size="4">ورود</font>
        </tr>
        
        <tr>
          <td align="left">
        کلمه ی عبور قبلی            
          </td>
          <td align="left">
              <html:password property="prePass" size="10" maxlength="30"/>
              </td>

        </tr>
        
        <tr>
          <td align="left">
 کلمه ی عبور جدید
          </td>
          <td align="left">
              <html:password property="newPass" size="10" maxlength="30"/>
          </td>
        </tr>
        
        <tr>
          <td align="left">
     تکرار کلمه ی عبور جدید
          </td>
          <td align="left">
              <html:password property="reNewPass" size="10" maxlength="30"/>
          </td>
        </tr>
        
        <tr>
          <td align="right">
            <html:submit>
                ورود
            </html:submit>
          </td>
          <td align="left">
            <html:cancel>
                بازنویسی
            </html:cancel>
          </td>
        </tr>
  </table>
   </html:form>
   
