<%-- 
    Document   : jsp
    Created on : 2018/05/14, 17:38:39
    Author     : タカ
--%>
<%@page import="org.mypackage.sample.ResultData" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            ResultData data=(ResultData)request.getAttribute("URANAI");
            %>
            
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            if(data !=null){
                out.print("<h1>あなたの"+data.getD()+"の運勢は"+data.getLuck()+"です！！</h1>");
            }
        %>
        
        
    </body>
</html>
