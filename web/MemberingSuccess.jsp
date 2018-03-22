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
<bean:write name="name" property="firstName" />
<p>
  عزیز
</p>
<p>
  شما با موفقیت مراحل ثبت نام را طی کردید. 
</p>
<p>
 پس از تایید مسئول سایت می توانید از امکانات عضویت استفاده کنید. 
</p>
<p>
 تا قبل از تایید مسئول سایت می توانید به صورت مهمان ، از امکانات سایت استفاده کنید. 
</p>
            <%
                session.setAttribute("usename", "guest");
            %> 
<html:link page="/Main.do">
    برای ورود به صفحه ی اصلی و استفاده در حالت مهمان اینجا را کلیک کنید.  
</html:link>