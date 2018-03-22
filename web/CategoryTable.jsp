<%@page import="DataBase.DataBaseGuestAccess"%>
<%@page import="DataBase.DataBaseMemberAccess"%>
<%@page import="DataBase.DataBaseAdminAccess"%>
<%@page import="Forms.Menu1Details"%>
<%@page import="java.util.List"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html:form action="AdminSubMenu">
    <table id="LeftMenu">
        <%
        //List list=(List)session.getAttribute("list");
        //session.setAttribute("levelUp", "level");
        if(!session.getAttribute("levelUp").equals("levelthree")){
        List list=null;
        String subject = null;
        if(session.getAttribute("levelUp").equals("level"))
            subject = "";
               else subject = session.getAttribute("SubMenu").toString();
        if(session.getAttribute("rol").equals("admin")){
            DataBaseAdminAccess AdminAccess = new DataBaseAdminAccess();  
            list= AdminAccess.GetMenuList(session.getAttribute("levelUp").toString(),subject);
        }else if(session.getAttribute("rol").equals("member")){
            DataBaseMemberAccess MemberAccess = new DataBaseMemberAccess();  
            list= MemberAccess.GetMenuList(session.getAttribute("levelUp").toString(),subject);
        }else if(session.getAttribute("rol").equals("guest")){
            DataBaseGuestAccess GuestAccess = new DataBaseGuestAccess();  
            list= GuestAccess.GetMenuList(session.getAttribute("levelUp").toString(),subject);
        }
        session.setAttribute("list",list);
        for(int i=0;i<list.size();i++){
            Menu1Details details = (Menu1Details)list.get(i); 
        %>
            <tr><td><html:submit styleClass="click" property="linkName"><%=details.getName()%></html:submit></td></tr>
        <%}}%>
    </table>
</html:form>
<div class="announce">
<h3>
    اخبار
</h3>
<p><strong>
        16 مرداد 91
    </strong><br />
ایران در المپیک 11 ام شد:دی
</p>
<p class="textright"><a href="index.html">
        اطلاعات بیشتر
    </a></p>
</div>