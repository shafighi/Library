<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>

<head>
<title>Success</title>
</head>

<body>
<%
String fileName=(String)request.getAttribute("fileName");
System.out.println(fileName+"yessss");
%>

<p align="center">
    فایل بارگذاری شد
    </p>
<p align="center"><a href="upload/<%=fileName%>">
        
  برای دانلود اینجا کلیک کنید
    </a></p>
</body>

</html>