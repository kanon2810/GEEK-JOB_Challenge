<%-- 
    Document   : boolean
    Created on : 2018/06/16, 21:41:42
    Author     : タカ
--%>
<%@page import="java.sql.*"%>
<%@page import="kanri.LOGIN"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>   
       body{background-color:#0FF} 
    </style>
    </head>
    <body>
    <center><br><br><br><br><br><br><br>
        <%
              HttpSession date=request.getSession();
              String id=(String)date.getAttribute("ID");
            String pass=(String)date.getAttribute("PASS");
    
       %>
       <font size="4" color="red">認証に成功しました</font>
       
      
       <br><br>

  <form action="./out.jsp" method="post">
             <input type="submit" name="LOGUOUT" value="ログアウト">
        </form>
        <form action="./ZAIKO1.jsp" method="post">
             <input type="submit" name="next" value="管理ページへ">
        </form>
    </center>
    </body>
</html>
