<%-- 
    Document   : Myupdataresult
    Created on : 2018/07/20, 21:23:09
    Author     : タカ
--%>
<%@page import="Syori.KYOUTSU"%>
<%@page import="Syori.UserDataDTO"%>
<% UserDataDTO UD = (UserDataDTO)session.getAttribute("RDATA");%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>更新完了</title>
        <style>span.sample {position:absolute; top:10px; left:1000px}</style>
    </head>
    <body background="folder/sora2.jpg">
        <p class="sample"><%=KYOUTSU.getInstance().home()%><span class="sample"><%=KYOUTSU.getInstance().login(UD)%></span></p><br>
    <center>
 
 
        <h1> 更新しました</h1><br><br><br><br>
 <table border="1">

 　<tr>
      <th bgcolor="#00FF7F" width="150">  　ユーザーネーム　 </th>
      <td bgcolor="#EDFFBE" width="350" ><%=UD.getName()%></td>
     </tr>
     <tr>
         <th bgcolor="#00FF7F" width="150">   　パスワード</th>
         <td bgcolor="#EDFFBE" width="350"> <%=UD.getPassword().replaceAll("[0-9a-zA-Z]", "●")%></td>
     </tr>   
     <tr>
         <th bgcolor="#00FF7F" width="150">   メールアドレス</th>
         <td bgcolor="#EDFFBE" width="350"> <%=UD.getMail()%></td>
      </tr>  
      <tr>
          <th bgcolor="#00FF7F" width="150">  住所</th>
          <td bgcolor="#EDFFBE" width="350"><%=UD.getAddress()%></td>
　　　</tr>
 </table>
    </center>
    </body>
</html>
