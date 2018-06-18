<%-- 
    Document   : ROGIN0
    Created on : 2018/06/15, 16:43:05
    Author     : タカ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <style>
            body{
                background: -moz-linear-gradient(top, #FFF, #FFC778 30%, #F89174 60%, #748af8);
                background: -webkit-linear-gradient(top, #FFF, #FFC778 30%, #F89174 60%, #748af8);
                background: linear-gradient(to bottom, #FFF, #FFC778 30%, #F89174 60%, #748af8);
            }
            </body>
        </style>
    </head>
    <body>
       <center>
        <br><br><br><br><br><br><br>IDとパスワード登録を行います<br><br><br><br><br>
       
            <form action="./rogin.jsp" method="post">
            <br>
            ユーザーID<input type="text" name="id" ><font size="1" color="red">*最低８文字</font><br>
             パスワード<input type="password" name="pass" ><font size="1" color="red">*最低７文字</font><br>
             <input type="submit" name="sub" value="登録" ></form> 
        
        <form action="./ROGUIN.jsp" method="post"> 
            <input type="submit"  name="end" value="登録済みの方" >
          </form>
             <%
                 request.setCharacterEncoding("UTF-8");
               request.getParameter("trun");
             %>
        
    </center>
    </body>
</html>
