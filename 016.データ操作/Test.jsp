<%-- 
    Document   : Test
    Created on : 2018/05/30, 14:02:21
    Author     : タカ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        request.setCharacterEncoding("UTF-8");
        
out.print(request.getParameter("txtName")+"<br>");
out.print(request.getParameter("rdoSample")+"<br>");
out.print(request.getParameter("mulText")+"<br>");
//out.print(request.getParameter("bit"));
        %>
    </body>
</html>
