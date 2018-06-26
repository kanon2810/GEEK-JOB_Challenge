<%-- 
    Document   : delete
    Created on : 2018/06/20, 11:18:28
    Author     : タカ
--%>
<%@page import="jums.JumsHelper" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>レコードの削除</h1>
        <form action="" method="post">
            <input type="text" name="del">
            <input type="submit" name="dele" value="削除"><br><br><br>
             <%=JumsHelper.getInstance().home()%><br>
            
        </form>
    </center>
    </body>
</html>
