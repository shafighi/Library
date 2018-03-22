<%@page import="DataBase.DataBaseAdminAccess"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>  
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%if(session.getAttribute("rol").equals("admin")){%>
 <table id="AddRemove" > 
<html:form action="AddRemoveAction"   >
   <html:errors locale="true" />
   <%  request.setCharacterEncoding("UTF-8"); %>
   
       
       <tr class="hide">
          <td align="left"><html:text property="menu" size="10" maxlength="30" value="menu1"/></td> 
        </tr>
       
        <tr>
          <td align="right">
        موضوع   
          </td>
          <td align="left"><html:text property="newSubject" size="10" maxlength="30" /></td>
                    <td align="left">عضو<html:checkbox property="accept"  value="member"/></td> 
          <td align="left">مهمان<html:checkbox property="accept"  value="guest"/></td>
                    <td align="left">
                        <html:submit styleClass="ok">
               اضافه
            </html:submit>
          </td>
        </tr>
        <tr>
          <td align="right">
        موضوع  
          </td>
          <td align="left"><html:text property="deleteSubject" size="10" maxlength="30"/></td>
          <td></td>
          <td></td>
                    <td align="left">
                        <html:submit styleClass="ok">
                حذف
            </html:submit>
          </td>
        </tr>
       
</html:form>
        </table>
 <%}%>
  