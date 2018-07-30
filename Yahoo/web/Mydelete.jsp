<%-- 
    Document   : Mydelete
    Created on : 2018/07/21, 6:31:23
    Author     : タカ
--%>
<%@page import="Syori.UserDataDTO"%>
<%UserDataDTO us = (UserDataDTO)session.getAttribute("DATA");%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <script src="dousa1.js" charset="UTF-8"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除確認</title>
          <style> span.sample {position:absolut}</style>
          <link rel="stylesheet" href="anime2.css">
               <style>
            .buruburu {
    display: inline-block;
    animation: hurueru .1s  infinite;
}

@keyframes hurueru {
    0% {transform: translate(0px, 0px) rotateZ(0deg)}
    25% {transform: translate(2px, 2px) rotateZ(1deg)}
    50% {transform: translate(0px, 2px) rotateZ(0deg)}
    75% {transform: translate(2px, 0px) rotateZ(-1deg)}
    100% {transform: translate(0px, 0px) rotateZ(0deg)}
}
            span.sample {position:absolute; top:337px; left:885px; }
            span.sample2 {position:absolute; left:1000px;} 
            
            form_conf {
    text-align: center;
}
.form_conf form {
    display: inline-block;
    margin: 0 10px;
}
            </style>
    </head>
    <body background="<%if(us.getOutdate()!=null){out.println("folder/thi.jpg");}else{out.println("folder/pink.png");}%>">
    <center>
        <%if(us.getOutdate()!=null){%>
        <font size="7" color="red"><b><span class="buruburu">本当に退会しちゃうの？</span></b></font>
        <%}else{%>
        <font size="7"><b>本当に退会しちゃうの？</b></font>
        <%}%>
          <table border="1">
         <tr>
<th bgcolor="#996699">ユーザーネーム</th>
<td bgcolor="<%if(us.getOutdate()!=null){out.println("red");}else{out.println("#ffffff");}%>"><%=us.getName()%></td>
</tr>
 <tr>
<th bgcolor="#996699">パスワード</th>
<td bgcolor="<%if(us.getOutdate()!=null){out.println("red");}else{out.println("#ffffff");}%>">非公開</td>
</tr>
 <tr>
<th bgcolor="#996699">メールアドレス</th>
<td bgcolor="<%if(us.getOutdate()!=null){out.println("red");}else{out.println("#ffffff");}%>"><%=us.getMail()%></td>
</tr>
<th bgcolor="#996699">住所</th>
<td bgcolor="<%if(us.getOutdate()!=null){out.println("red");}else{out.println("#ffffff");}%>"><%=us.getAddress()%></td>
</tr>
<th bgcolor="#996699">登録日時</th>
<td bgcolor="<%if(us.getOutdate()!=null){out.println("red");}else{out.println("#ffffff");}%>"><%=us.Format(us.getNewDate())%></td>
</tr>
          </table><br>
<div class="form_conf">
<%if(us.getOutdate()==null){%>
<form action="Mydeleteresult" method="post">
    <input type="submit" name="delete" value="はい">
    <input type="hidden" name="flagnum" value="1">
</form>
<form action="./Top.jsp" method="post">
    <input type="submit" name="top" value="いいえ">
</form>
<%}else{%>
        <form action="Mydeleteresult" method="post">
    <input type="image" src="folder/button2.png" style="width:450" height="100" name="delete">&ensp;&ensp;&ensp;&ensp;&ensp;
    <input type="hidden" name="flagnum" value="1">
</form>
<form action="./Top.jsp" method="post">
   <input type="image" src="folder/button.png" style="width:450" height="100" name="top">
</form>
        <%}%>
</div>

<br><br><br>
    </center>
<div class="textboard">

    <div class="test1"><span class="typeWriter"><font color='red'><%
        if(us.getOutdate()==null){%>
        <font color="#FFCCFF" size="7">今までありがとうございました💗</font>
       <% }else{
             for(int i=0;i<14;i++){
        out.println("サヨナラサヨナラサヨナラサヨナラサヨナラサヨナラサヨナラ"+"<a href=\""+"./hoka.jsp"+"\">サ</a>"+"ヨナラサヨナラサヨナラサヨナラサヨナラサヨナラサヨナラサヨナラサヨナラサヨナラサヨナラ");
            }
        }
    %></font></span></div>
    
</div>
    </body>
</html>
