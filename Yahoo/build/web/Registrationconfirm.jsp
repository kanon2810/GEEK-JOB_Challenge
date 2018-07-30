<%-- 
    Document   : Registration
    Created on : 2018/07/08, 5:08:14
    Author     : タカ
--%>

<%@page import="Syori.KYOUTSU"%>
<%@page import="Syori.UserDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%UserDate us = (UserDate)session.getAttribute("ud");%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録完了画面</title>
        
<style> span.sample {position:absolute; top:10px; left:1000px }</style> 

    </head>
    
    <body background="folder/sora1.jpg">
         <%=KYOUTSU.getInstance().home()%>
    <center><br><br><br><br>
        <h1>入力した内容は以下の通りで宜しいでしょうか？</h1><br>

        <table border="1">

 　<tr>
      <th bgcolor="#99CCFF" width="150">  　ユーザーネーム　 </th>
      <td bgcolor="white" width="350" ><%=us.getName()%></td>
     </tr>
     <tr>
         <th bgcolor="#99CCFF" width="150">   　パスワード</th>
         <td bgcolor="white" width="350"> <%=us.getPassword().replaceAll("[0-9a-zA-Z]", "●")%></td>
     </tr>   
     <tr>
         <th bgcolor="#99CCFF" width="150">   メールアドレス</th>
         <td bgcolor="white" width="350"> <%=us.getMail()%></td>
      </tr>  
      <tr>
          <th bgcolor="#99CCFF" width="150">  住所</th>
          <td bgcolor="white" width="350"><%=us.getAddress()%></td>
　　　</tr>
 </table>
   <br><br><br><br>
        <form action="Registrationcomplete" method="post">
            <input type="submit" name="yes" value="はい">
              </form>
        <form action="Registration" method="post">
            <input type="submit" name="no" value="いいえ">
              </form>
       
    </center>
    </body>
</html>
