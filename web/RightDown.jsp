<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<p>   خوش آمدید    </p>
سلام
    <%
        String name = session.getAttribute("username").toString();
        if(name.equals("null") || name.equals("guest")){
              String temp = request.getParameter( "username" );
              if(temp!=null){
                  name = temp;
                  session.setAttribute("username", name );
              }
              String pass = request.getParameter( "password" );
              if(pass!=null)session.setAttribute("password", pass);
        }
    %>  
    <%=name%>
<p>&NegativeMediumSpace;</p>
<html:link page="/ChangeUser.do">
     تغییر کلمه ی کاربری 
</html:link>
<br/>    
<html:link page="/ChangePass.do">
     تغییر رمزعبور 
</html:link>
<br/>
<html:link page="/Main.do">    
    خارج شدن 
</html:link>
<br/> 
