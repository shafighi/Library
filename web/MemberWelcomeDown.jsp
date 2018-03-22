<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %> 
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%//<bean:write name="MemberingForm" property="username"/> %>
   سلام,
   <%= session.getAttribute( "username" ) %>

<p>   خوش آمدید    </p>
<p>
  درخواست عضویت شما با موفقیت ثبت شد .
    حال باید منتظر تائید مسئول سایت باشید .
    با تشکر از درخواست عضویت شما.
</p>
