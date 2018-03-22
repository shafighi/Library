<%-- 
    Document   : ChangeSuccess
    Created on : Aug 10, 2012, 8:48:48 PM
    Author     : shadi
--%>


<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %> 
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<p>
    <%=session.getAttribute( "username" ) %>
    عزیز
</p>
<p>
   رمز عبور شما با موفقیت تغییر کرد 
</p>
            <%
                String name = request.getParameter( "newPass" );
                session.setAttribute("password", name);
            %> 
<html:link page="/MainAdmin.do">
    برای ورود به صفحه ی اصلی اینجا را کلیک کنید  
</html:link>