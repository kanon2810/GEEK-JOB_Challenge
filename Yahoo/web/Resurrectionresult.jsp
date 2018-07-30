<%-- 
    Document   : Resurrectionresult
    Created on : 2018/07/21, 12:17:04
    Author     : タカ
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Syori.KYOUTSU"%>
<%@page import="Syori.UserDataDTO"%>
<%UserDataDTO DTO = (UserDataDTO)session.getAttribute("look");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日(E) HH時mm分");
Date date = new Date();%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>確認がとれました</title>
        <style>span.sample {position:absolute; top:10px; left:1000px }
        body {
	margin: 0 auto;

}

.background {
	background-image: url(folder/base.png);
	position: relative;
	height: 100%;
        background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	
}

.gradient {
	background: linear-gradient(45deg, rgba(4,191,207,0.6), rgba(191,25,203,0.6));
	background-size: 400% 400%;
	height: 100vh;

	-webkit-animation: test 4s ease infinite;
	-moz-animation: test 4s ease infinite;
	animation: test 4s ease infinite;
}
	@-webkit-keyframes test {
	    0%{background-position:0% 51%}
	    50%{background-position:100% 50%}
	    100%{background-position:0% 51%}
	}
	@-moz-keyframes test {
	    0%{background-position:0% 51%}
	    50%{background-position:100% 50%}
	    100%{background-position:0% 51%}
	}
	@keyframes test { 
	    0%{background-position:0% 51%}
	    50%{background-position:100% 50%}
	    100%{background-position:0% 51%}
	}

        </style>
    </head>
    <body>
         

        <div class="background">
            <div class="gradient">
   <p class="sample"><%=KYOUTSU.getInstance().home()%></p><br>
            <center>
   <font size="7">確認が取れました</font><font size="4"><%=sdf.format(date)%>現在。</font><br><br><br>　
        こちらの情報で間違いないでしょうか？<br>
    
        <table border="1">

 　<tr>
      <th bgcolor="#00FF7F" width="150">  　ユーザーネーム　 </th>
      <td bgcolor="#EDFFBE" width="350" ><%=DTO.getName()%></td>
     </tr>
     <tr>
         <th bgcolor="#00FF7F" width="150">   　パスワード</th>
         <td bgcolor="#EDFFBE" width="350">非公開</td> 
     </tr>   
     <tr>
         <th bgcolor="#00FF7F" width="150">   メールアドレス</th>
         <td bgcolor="#EDFFBE" width="350"> <%=DTO.getMail()%></td>
      </tr>  
      <tr>
          <th bgcolor="#00FF7F" width="150">  住所</th>
          <td bgcolor="#EDFFBE" width="350"><%=DTO.getAddress()%></td>
　　　</tr>
      <tr>
          <th bgcolor="#00FF7F" width="150">  登録日時</th>
          <td bgcolor="#EDFFBE" width="350"><%=DTO.Format(DTO.getNewDate())%></td>
　　　</tr>
      <tr>
          <th bgcolor="#00FF7F" width="150">  退会日時</th>
          <td bgcolor="#EDFFBE" width="350"><%=sdf.format(DTO.getOutdate())%></td>
　　　</tr>
        </table><br><br><br>

          <form action="Resurrectioncomplete" method="post">
                  <input type="submit" value="はい">
                  <input type="hidden" name="num" value="0">
            </form>
         <form action="Resurrection" method="post">
             <input type="submit" value="いいえ">
            </form>
        </div>
        </div>
    </center>
    </body>
</html>
