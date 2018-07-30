<%-- 
    Document   : Null
    Created on : 2018/07/22, 15:53:58
    Author     : タカ
--%>

<%@page import="Syori.UserDataDTO"%>
<%@page import="Syori.KYOUTSU"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%UserDataDTO DTO = (UserDataDTO)session.getAttribute("DATA");%> 
<html>
    <head>
         <script src="dousa.js" charset="UTF-8"></script>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>申し訳ございません</title>
        <style>span.sample {position:absolute; top:10px; left:1000px }
        a {color: white}</style>
    <link rel="stylesheet" href="style.css"> 
    <link rel="stylesheet" href="anime.css">
    </head>
    <body>
        <p class="sample"><%=KYOUTSU.getInstance().home()%><span class="sample"><font color="white"><%=KYOUTSU.getInstance().login(DTO)%></font></span></p>
  <div id='c'>
  <div class='s'></div>
  <div class='s'></div>
  <div class='s'></div>
  <div class='s'></div>
  <div class='s'></div>
  <div class='s'></div>
</div><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br>

       <div class="textboard">
             <audio src="DQ.mp3" autoplay></audio>
             <p class="test1" ><span class="typeWriter">おきのどくですが、あなたのアカウントは破棄された可能性が考えられます<br></span></p>
             &ensp;&ensp;&ensp;&ensp;<a ID="moji2" style="visibility:hidden;">▶</a>
<span onmouseover="document.all.item('moji2').style.visibility='visible'" onmouseout="document.all.item('moji2').style.visibility='hidden'">
    <a href="./Top.jsp">トップに戻る</a></span>
&ensp;&ensp;&ensp;&ensp;<a ID="moji" style="visibility:hidden;">▶</a>
<span onmouseover="document.all.item('moji').style.visibility='visible'" onmouseout="document.all.item('moji').style.visibility='hidden'">
<a href="Registration">再度アカウントを作成する</a>
</span>
</div>
    </body> 
</html>
