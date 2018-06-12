<%-- 
    Document   : form
    Created on : 2018/06/12, 12:18:38
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
    <center>
        <form action="./kennsaku.jsp" method="post">
            <font size="5">名前を入力してください</font><br>
           
            名前 <input type="text" name="name"><br>
        <input type="submit" name="mit" value="次に進む"><br>
        </form>
    </center> 
    </body>
</html>
