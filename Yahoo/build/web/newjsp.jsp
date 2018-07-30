<%-- 
    Document   : newjsp
    Created on : 2018/07/10, 3:28:08
    Author     : タカ
--%>

<%@page import="Syori.UserDataDTO"%>
<%@page import="java.util.concurrent.TimeUnit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    
    </head>
 

    <body>
        <H1>ログインOK!!</H1>
   <%  UserDataDTO DTO = (UserDataDTO)session.getAttribute("DATA");
   out.println(DTO.getOutdate());
%>
    </body>
</html>
