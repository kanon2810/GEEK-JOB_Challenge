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
out.print(request.getParameter("ｌ")+"<br>");
out.print(request.getParameter("S1")+"<br>");
out.print(request.getParameter("t")+"<br>");

out.print(request.getParameter("a")+"<br>");
out.print(request.getParameter("sa")+"<br>");
out.print(request.getParameter("hi")+"<br>");
out.print(request.getParameter("Ans")+"<br>");
out.print(request.getParameter("komi")+"<br>");
out.print(request.getParameter("it")+"<br>");
out.print(request.getParameter("S2")+"<br>");

out.print("ご協力ありがとうございました");

//out.print(request.getParameter("bit"));
        %>
    </body>
</html>
