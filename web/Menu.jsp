<%@page contentType="text/html" pageEncoding="UTF-8" %>
<table id="LeftMenu">
    <tr><td><FORM><INPUT class="menu" TYPE="BUTTON" VALUE="موضوعات" ONCLICK="window.location.href='AdminFirstMenu.do'"></FORM></td></tr>
    <tr><td><FORM><INPUT class="menu" TYPE="BUTTON" VALUE="اخبار" ONCLICK="window.location.href='News.do'"></FORM></td></tr>
    <tr><td><FORM><INPUT class="menu" TYPE="BUTTON" VALUE="تماس با ما" ONCLICK="window.location.href='http://www.computerhope.com'"></FORM></td></tr>
    <%if(!session.getAttribute("rol").equals("guest")){%>
    <tr><td><FORM><INPUT class="menu" TYPE="BUTTON" VALUE="پروفایل" ONCLICK="window.location.href='WaitingList.do'"></FORM></td></tr>   
    <%if(session.getAttribute("rol").equals("admin")){%>
    <tr><td><FORM><INPUT class="menu" TYPE="BUTTON" VALUE="لیست انتظار" ONCLICK="window.location.href='WaitingList.do'"></FORM></td></tr>   
    <tr><td><FORM><INPUT class="menu" TYPE="BUTTON" VALUE="ویرایش موضوعات" ONCLICK="window.location.href='AddRemove.do'"></FORM></td></tr>   
    <%}}%>
</table>
<div class="announce">
<h3> اخبار</h3>
<p>
<strong> 16 مرداد 91</strong>
<br/>
ایران در المپیک 11 ام شد:دی
</p>
<p class="textright"><a href="index.html">
        اطلاعات بیشتر
    </a></p>
</div>