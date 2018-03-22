<%@page import="java.util.ArrayList"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %> 
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html:form action="/WaitingListAction"   >
        سلام
        , <%= session.getAttribute( "username" ) %>
          
<table id="WaitingListTable" >
<tr>
        <td>قبول</td>
        <td>رد</td>
        <td>نام کاربری</td>
        <td>نام</td>
        <td>نام خانوادگی</td>
        <td>ایمیل</td>
        <td>نقش</td>
    </tr>
    <logic:iterate id="data" name="WaitingListForm" property="waitingList" >

    <tr>       
        <td><html:checkbox name="data" value="true" property="accept" indexed="true"/></td>
        <td><html:checkbox name="data" value="false" property="accept" indexed="true"/></td>
        <td><bean:write name="data" property="username" /></td>
        <td><bean:write name="data" property="firstName"/></td>
        <td><bean:write name="data" property="lastName" /></td>
        <td><bean:write name="data" property="email"    /></td>
        <td><bean:write name="data" property="rol"      /></td>
    </tr>

  </logic:iterate>
    

         
        <tr>
        <td><html:submit>
        تمام
            </html:submit></td>
    </tr>
</table>
</html:form>

    
        
        
        
        
        
        
    


   
