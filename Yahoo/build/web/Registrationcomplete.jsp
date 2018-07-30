<%-- 
    Document   : Registrationcomplete
    Created on : 2018/07/08, 18:49:05
    Author     : タカ
--%>
<%@page import="Syori.KYOUTSU"%>
<%@page import="Syori.UserDate"%>
<%UserDate DT = (UserDate)request.getAttribute("utd");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>確認画面</title>
         


    </head>
    <body background="folder/sora1.jpg">
   <%=KYOUTSU.getInstance().home()%>
   <center>
   <h1>登録確認</h1><br><br>
        
           <table border="1">

 　<tr>
      <th bgcolor="#00FFFF" width="150">  　ユーザーネーム　 </th>
      <td bgcolor="white" width="350" ><%=DT.getName()%></td>
     </tr>
     <tr>
         <th bgcolor="#00FFFF" width="150">   　パスワード</th>
         <td bgcolor="white" width="350"> <%=DT.getPassword().replaceAll("[0-9a-zA-Z]", "●")%></td>
     </tr>   
     <tr>
         <th bgcolor="#00FFFF" width="150">   メールアドレス</th>
         <td bgcolor="white" width="350"> <%=DT.getMail()%></td>
      </tr>  
      <tr>
          <th bgcolor="#00FFFF" width="150">  住所</th>
          <td bgcolor="white" width="350"><%=DT.getAddress()%></td>
　　　</tr>
 </table>
        <h2>上記の通りご登録しました。再度ご確認ください。</h2>
        <br><br>
         <a href="./Top.jsp">トップへ</a>
   </center>
    </body>
</html>
