<%-- 
    Document   : Mydeleteresult2
    Created on : 2018/07/25, 11:20:37
    Author     : タカ
--%>

<%@page import="Syori.UserDataDTO"%>
<%@page import="Syori.KYOUTSU"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%UserDataDTO UD = (UserDataDTO)session.getAttribute("DATA");%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>さよなら</title>
           <style>   span.sample {position:absolute; left:1000px;} </style>
    </head>
    <body background="folder/holla.jpg">　
        <p class="sample"><%=KYOUTSU.getInstance().home()%><span class="sample"><%=KYOUTSU.getInstance().login(UD)%></span>
    <center>
           <br><br><br><br><br><br><br><br><img src="folder/moji.png">
    </center>
    </body>
</html>
