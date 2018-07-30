<%-- 
    Document   : Mydeleteresult
    Created on : 2018/07/21, 7:10:10
    Author     : タカ
--%>

<%@page import="Syori.KYOUTSU"%>
<%@page import="Syori.UserDataDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%UserDataDTO UD = (UserDataDTO)session.getAttribute("DATA");%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除完了</title>
        <link rel="stylesheet" href="style2.css"> 
          <style>   span.sample {position:absolute; left:1000px;} </style>
    </head>
    <body>
         <p class="sample"><%=KYOUTSU.getInstance().home()%><span class="sample"><%=KYOUTSU.getInstance().login(UD)%></span></p><br>
     
<div id='stars'></div>
<div id='stars2'></div>
<div id='stars3'></div>
<div id='title'>
  <span>
  </span>
  <br>
  <span>
   削除が完了しました
  </span>
</div>
    </body>
  
</html>
