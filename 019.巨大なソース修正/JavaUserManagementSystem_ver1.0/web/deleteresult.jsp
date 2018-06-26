<%-- 
    Document   : deleteresult
    Created on : 2018/06/20, 11:24:04
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
    <center><br><br><br><br>
          <form action="" method="post">
              <h1>削除しました！</h1>
              <input type="submit" name=return value="検索結果画面に戻る"><br><br>
               <%=JumsHelper.getInstance().home()%><br>
          </form>
    </center>
    </body>
</html>
