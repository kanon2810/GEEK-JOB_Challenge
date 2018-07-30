<%-- 
    Document   : Registration
    Created on : 2018/07/07, 22:14:56
    Author     : タカ
--%>
<%@page import="Syori.UserDate"%>
<%@page import="Syori.KYOUTSU"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%   
    String name=(String)request.getAttribute("rname"); String na="";
  String password=(String)request.getAttribute("rpassword"); String pa="";
  String mail=(String)request.getAttribute("rmail"); String ma="";
  String address=(String)request.getAttribute("raddress"); String ad="";
  
   UserDate DATA = (UserDate)session.getAttribute("ud");
  UserDate us = null;
    boolean flag = false;
    if(request.getParameter("no") != null){
        flag = true;
        us = (UserDate)session.getAttribute("ud");
    }
 
%> 

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>新規登録フォーム</title>
         <script src="yubin.js" charset="UTF-8"></script>
    </head>
    <body background="folder/sora1.jpg">
        <%=KYOUTSU.getInstance().home()%>
    <center>
        <font size="10" color="red"><%if(request.getAttribute("me")==null){out.println("");}else{out.println(request.getAttribute("me"));}%></font><br>
        <h1>新規登録を行います</h1><br>
        ユーザーネームを決めてください<br>
        
             <form action="Registrationconfirm" method="post">
                 <input type="text"  name="name" style="<%if(name!=null){out.println("background-color:#FF99FF");}%>" value="<%if(flag){out.println(us.getName());}%>"><br>
                 <font color="red"><% if(name==null){out.println(na);}else{out.println(name);}%><br><br></font>
            
            パスワードを決めてください<font size="1" color="red">*最低７文字</font><br>
            <input type="password" name="password" style="<%if(password!=null){out.println("background-color:#FF99FF");}%>" value="<%if(flag){out.println(us.getPassword());}%>"><br><br>
            
            確認のためもう一度入れてください<br>
            <input type="password" style="<%if(password!=null){out.println("background-color:#FF99FF");}%>"  name="password2"><br>
           <font color="red"><% if(password==null){out.println(pa);}else{out.println(password);}%><br><br></font>
           
            メールアドレスを入力してください<br>
             <input type="text" name="mail" size="18" style="<%if(mail!=null){out.println("background-color:#FF99FF");}%>" value="<%if(flag){out.println(us.getMail());}%>">@kagoyume.co.jp<br>
            <font color="red"><% if(mail==null){out.println(ma);}else{out.println(mail);}%><br><br></font>
              
            住所を入れてください（郵便番号からの参照も可能です）<br>
            <textarea name="addr21" rows="2" cols="30" style="<%if(address!=null){out.println("background-color:#FF99FF");}%>"><%if(flag){out.println(us.getAddress());}%></textarea><br>
             <font color="red"><% if(address==null){out.println(ad);}else{out.println(address);}%><br><br></font>
             〒<input type="text" name="zip21" size="2" maxlength="3"> － <input type="text" name="zip22" size="4" maxlength="4" onKeyUp="AjaxZip3.zip2addr('zip21','zip22','addr21','addr21');"><br><br><br>
           
            <input type="submit" name="check" value="登録">&emsp;&emsp;
             <input type="reset" name="reset" value="リセット">
            
            
        </form>
       </center>
    </body>
</html>
