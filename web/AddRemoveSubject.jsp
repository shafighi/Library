
<%@page import="Forms.toUTF8"%>
<%@page import="Forms.FilesDetails"%>
<%@page import="DataBase.DataBaseAdminAccess"%>
<%@page import="Forms.Menu1Details"%>
<%@page import="java.util.List"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %> 
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html:form action="AdminSubMenu2">
<%request.setCharacterEncoding("UTF-8");%>
<html:form action="AddRemoveAction">
   <html:errors locale="true" />
   <p>
       
   </p>
   <table id="AddRemove" >  
       <tr class="hide">
          <td align="right">
          </td>
          <td align="left"><html:text property="menu" size="10" maxlength="30" value="levelone"/></td> 
        </tr>
       
        <tr>
          <td align="right">
        موضوع  
          </td>
          <td align="left">
          <html:select property="newSubject" size="10" maxlength="30">        
                <%DataBaseAdminAccess AdminAccess = new DataBaseAdminAccess();  
                List list= AdminAccess.GetMenu2List();
                for(int i=0;i<list.size();i++){
                    Menu1Details details = (Menu1Details)list.get(i); 
                %><option><%=details%></option>
                <%}%>
          </html:select></td> 
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

        <tr>

        </tr>
        
  
        <table/>