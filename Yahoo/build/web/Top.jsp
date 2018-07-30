<%-- 
    Document   : Top
    Created on : 2018/07/06, 17:52:28
    Author     : タカ
--%>
<%@page import="Syori.UserDataDTO"%>
<%@page import="Syori.KYOUTSU"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
String OUT  = (String)request.getAttribute("OUT"); 
UserDataDTO DTO = (UserDataDTO)session.getAttribute("DATA");
%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>KAGOYUMEショッピング</title>
        <style>
            span.sample {position:absolute; top:337px; left:885px; }
            span.sample2 {position:absolute; left:1000px;} 
            </style>
            
    </head>
    <body> 
        <span class="sample2"><%=KYOUTSU.getInstance().login(DTO)%></span>
    <center><br><br><br><br><br><br><br><br><br><br>
        <img src="folder/kagoyume.png"><br>
        <form action="./Search" method="get">
            <input type="text" name="query" style="width:20em;font-size:150%;border:4px #FF0099 solid;" placeholder="何かお探しですか？">
            <span class="sample">  <input type="image" src="folder/search.jpg" style="width:250" height="40" name="search"></span><br><br><br>
            <input type="hidden" name="hit">
            
   <h1>        <%if (OUT == null) {
                     out.println("");
                } else {
                     out.println(OUT);
                }
               %></h1> 
               <br><br><br><br>
               <%if(DTO==null){%>
               <a href="Resurrection">もしかして…あなたのアカウントまだ取り返せるかも…</a>
               <%}%>
    </center>
</body>
</html>
