<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>  
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html:form action="/MemberingAction">

<p>
    لطفا پس از عضویت ،برای استفاده از امکانات سایت منتظر تائید مسئول سایت باشید
</p>
<p id="Error" style="color: red"><html:errors prefix="errors.prefix" suffix="errors.suffix" locale="true"/></p>

<table style="border:2">
        <tr>
          <td align="center" colspan="2">
                عضویت        
          </td>
                
        </tr>
        
        <tr>
          <td align="right">
            نام کاربری
          </td>
          <td align="left">
            <html:text property="username" size="20" maxlength="30"/>

          </td>
        </tr>
        

        <tr>
          <td align="right">
     کلمه ی عبور
          </td>
          <td align="left">
              <html:password property="password" size="20" maxlength="30"/>
          </td>
        </tr>
        
       <tr>
          <td align="right">
   تکرار  کلمه ی عبور
          </td>
          <td align="left">
             <html:password property="password2" size="20" maxlength="30"/>
          </td>
        </tr>
        
        <tr>
          <td align="right">
         نام
          </td>
          <td align="left">
               <html:text property="firstName" size="20" maxlength="30"/>
            
            </td>
        </tr>
        
        <tr>
          <td align="right">
        نام خانوادگی
          </td>
          <td align="left">
            <html:text property="lastName" size="20" maxlength="30"/>
          </td>
        </tr>
        
        <tr>
          <td align="right">
       ایمیل
          </td>
          <td align="left">
            <html:text property="email" size="20" maxlength="30"/>
          </td>
        </tr>
        
        <tr>
          <td align="right">
            <html:submit>
                تایید
            </html:submit>
          </td>
          <td align="left">
            <html:cancel>
         باز نویسی
            </html:cancel>
          </td>
        </tr>
        
        
   </table>
</html:form>