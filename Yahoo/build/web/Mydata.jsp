<%-- 
    Document   : Mydata
    Created on : 2018/07/08, 19:22:09
    Author     : タカ
--%>
<%@page import="java.text.NumberFormat"%>
<%@page import="Syori.KYOUTSU"%>
<%@page import="Syori.UserDate"%>
<%@page import="Syori.UserDataDTO"%>
<%UserDataDTO us = (UserDataDTO)session.getAttribute("DATA");%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ユーザーデータ</title>
        <style>
 span.sample {position:absolute; top:10px; left:1000px }
</style>
    </head>
    <body>
        <p class="sample"><%=KYOUTSU.getInstance().home()%><span class="sample">ようこそ<%=us.getName()%>さん</span></p>
    <center>
        <table border="1">
   
   <h1>ユーザー情報</h1>  <br><br>
       
  <tr>
      <th bgcolor="#ff6600" width="250"><h2>ユーザーネーム</h2></th>
      <td width="400"><h2><%=us.getName()%></H2></td>
</tr>
 <tr>
     <th bgcolor="#ff6600" width="250"><h2>パスワード</h2></th>
     <td width="400"><font size="5">非公開</font>&emsp;パスワードを忘れた場合は<a href="Myupdata">こちら</a></td>
</tr>
 <tr>
     <th bgcolor="#ff6600" width="250"><h2>メールアドレス</h2></th>
<td width="400"><h2><%=us.getMail()%></h2></td>
</tr>
<th bgcolor="#ff6600" width="250"><h2>住所</h2></th>
<td width="400"><h2><%=us.getAddress()%></h2></td>
</tr>
<th bgcolor="#ff6600" width="250"><h2>登録日時</h2></th>
<td width="400"><h2><%=us.Format(us.getNewDate())%></h2></td>
</tr>
     
       <br><br>
        </table>

<form action="Myhistory" method="post">
    <input type="image" src="folder/tyumon.png" style="width:340" height="65" name="search">
</form>
<form action="Myupdata" metod="post">
     <input type="image" src="folder/kousin.png" style="width:340" height="65" name="search">
</form>
         <form action="Mydelete" metod="post">
     <input type="image" src="folder/off.png" style="width:340" height="65" name="search">
</form>
    </center>
    </body> 
</html>