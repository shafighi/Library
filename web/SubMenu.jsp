<%@page import="DataBase.DataBaseGuestAccess"%>
<%@page import="DataBase.DataBaseMemberAccess"%>
<%@page import="Forms.FilesDetails"%>
<%@page import="DataBase.DataBaseAdminAccess"%>
<%@page import="Forms.Menu1Details"%>
<%@page import="java.util.List"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<table>
    <%
    List list = null;
    if(session.getAttribute("rol").equals("admin")){
        DataBaseAdminAccess AdminAccess = new DataBaseAdminAccess();  
        list = AdminAccess.GetMenu2files(session.getAttribute("SubMenu").toString());
    }else if(session.getAttribute("rol").equals("member")){
        DataBaseMemberAccess MemberAccess = new DataBaseMemberAccess();             
        list= MemberAccess.GetMenu2files(session.getAttribute("SubMenu").toString());
    }else if(session.getAttribute("rol").equals("guest")){
        DataBaseGuestAccess GuestAccess = new DataBaseGuestAccess();  
        list= GuestAccess.GetMenu2files(session.getAttribute("SubMenu").toString());                               
    }
    String levelUp = session.getAttribute("levelUp").toString();          
    for(int i=0;i<list.size();i++){
        FilesDetails details = (FilesDetails)list.get(i); 
        %>
        <html:form action="acceptRemoveFile">
            <tr><td><a href="<%=details.getPath()%><%=details.getName()%>"><%=details.getShow()%></a></td> 
            
            <td class="hide"><html:submit property="levelup"  value="<%=levelUp%>"/></td> 
                <%if(session.getAttribute("rol").equals("admin")){%> <td align="left">حذف<html:submit property="accept"  value="delete"/></td><%}%>
                <td class="hide"><html:text property="name" value="<%=details.getName()%>"/></td>
            </tr>
        </html:form>
    <%}%>

    <%
    if(session.getAttribute("rol").equals("admin")){
    DataBaseAdminAccess AdminAccess4 = new DataBaseAdminAccess();  
    List list4 = AdminAccess4.GetMenu2filesWaiting(session.getAttribute("SubMenu").toString());
    for(int i=0;i<list4.size();i++){
        FilesDetails details = (FilesDetails)list4.get(i); 
    %>
         <html:form action="acceptRemoveFile">
         <tr>
             <td class="hide"><html:submit property="levelup"  value="<%=levelUp%>"/></td> 
             <td align="left">قبول برای عضو<html:submit property="accept"  value="member"/></td> 
             <td align="left">قبول برای  مهمان<html:submit property="accept"  value="guest"/></td>
             <td align="left">رد<html:submit property="accept"  value="delete"/></td>
             <td class="hide"><html:text property="name" value="<%=details.getName()%>"/></td>
             <td><a href="<%=details.getPath()%><%=details.getName()%>"><%=details.getShow()%></a></td>
         </tr>
         </html:form>
    <%}%>
</table>

<table id="AddRemove" >
<html:form action="AddRemoveAction">
<html:errors locale="true" />
<br/>
       <tr class="hide">
          <td align="right"></td>
          <td align="left"><html:text property="menu" size="10" maxlength="30" value="<%=levelUp%>"/></td> 
       </tr>
       
       <tr>
          <td align="right">  موضوع  </td>
          <td align="left"><html:text property="newSubject" size="10" maxlength="30"/></td> 
          <td align="left">عضو<html:checkbox property="accept"  value="member"/></td> 
          <td align="left">مهمان<html:checkbox property="accept"  value="guest"/></td>
          <td align="left"><html:submit styleClass="ok">اضافه</html:submit></td>
       </tr>

       <tr>
          <td align="right">  موضوع </td>
          <td><html:select property="deleteSubject">
                <%
                DataBaseAdminAccess AdminAccess5 = new DataBaseAdminAccess();  
                List list5= AdminAccess5.GetMenuList(session.getAttribute("levelUp").toString(),session.getAttribute("SubMenu").toString());
                for(int i=0;i<list5.size();i++){
                    Menu1Details details = (Menu1Details)list5.get(i);
                %>
                    <html:option value="<%=details.getName()%>"><%=details.getName()%></html:option>
                <%}%>
          </html:select></td>
          <td></td>
          <td></td>         
          <td align="left"><html:submit styleClass="ok">حذف                </html:submit></td>
       </tr>
</html:form><%}%>
       
<%if(!session.getAttribute("rol").equals("guest")){%>
    <html:form action="/FileUpload" method="post" enctype="multipart/form-data">
        <tr class="hide">
            <%
            DataBaseAdminAccess AdminAccess3 = new DataBaseAdminAccess();
            String level =null;
           // if(levelUp.equals("levelone"))level="leveltwo";
             //   else if(levelUp.equals("leveltwo"))level="levelthree";
               //     else if (levelUp.equals("levelthree"))level="levelfour"; 
            String path  = AdminAccess3.getPath(levelUp,session.getAttribute("SubMenu").toString());
            %>
            <td align="left"><html:text property="path" size="10" maxlength="30" value="<%=path%>"/></td> 
        </tr> 

        <tr class="hide">
            <td align="left"><html:text property="levelup" size="10" maxlength="30" value="<%=levelUp%>"/></td> 
        </tr>

        <tr>
            <td align="right">  نام نمایش فایل</td>
            <td align="left"><html:text size="10" property="show"/></td>
            <td align="left">عضو<html:checkbox property="accept"  value="member"/></td> 
            <td align="left">مهمان<html:checkbox property="accept"  value="guest"/></td>
            <td align="center" colspan="2"><html:submit styleClass="ok">بارگذاری</html:submit></td>
        </tr>

        <tr>
            <td align="left"><html:file size="10" property="theFile"/></td>
        </tr>
    </html:form><%}%>
</table>

          