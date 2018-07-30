<%-- 
    Document   : Login
    Created on : 2018/07/06, 22:01:07
    Author     : タカ
--%>
<%@page import="Syori.KYOUTSU"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%   String Wlog = (String) request.getAttribute("return"); String log = ""; if(Wlog==null){log = "";}else{log = Wlog;}%> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ユーザー認証を行います</title>
    </head>
    <body>
    <%=KYOUTSU.getInstance().home()%>    
    <center><br><br><br>
        <h1>ユーザー名とパスワードを入力してください</h1><br>
        <div style="border: 5px ridge #93F; padding: 10px; height: 12em; width: 15em">
            <center>
                <form action="LOG" method="post"><br><br>
                ユーザー名<input type="text" name="ID"><br><br>
                パスワード<input type="password" name="pass"><br><br>
                <input type="submit" name="login" value="ログイン"><br><br>
              
                 <%=log%>
                </form>
            </center>
        </div> <br><br>
         <a href="./Registration">登録画面へ進む</a>
    </center>
    </body>
</html>
