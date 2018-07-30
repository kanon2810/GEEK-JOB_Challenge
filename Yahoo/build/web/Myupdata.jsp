<%-- 
    Document   : Myupdata
    Created on : 2018/07/20, 16:40:33
    Author     : タカ
--%>
<%@page import="Syori.UserDate"%>
<%@page import="Syori.KYOUTSU"%>
<%@page import="Syori.UserDataDTO"%>
<%UserDataDTO DTO = (UserDataDTO)session.getAttribute("DATA");%>
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
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>あなたの情報の更新をいたします</title>
         <script src="yubin.js" charset="UTF-8"></script>
          <style>span.sample {position:absolute; top:10px; left:1000px }</style>
    </head>
    <body background="folder/sora2.jpg">
           <p class="sample"><%=KYOUTSU.getInstance().home()%><span class="sample"><%=KYOUTSU.getInstance().login(DTO)%></span></p><br>
    <center>
         <h1>あなたの情報を更新いたします</h1><br><br><br>
        <font size="10" color="red"><%if(request.getAttribute("me")==null){out.println("");}else{out.println(request.getAttribute("me"));}%></font><br>
        ユーザーネーム<br>
        
             <form action="Myupdataresult" method="post">
                 <input type="text"  name="name" style="<%if(name!=null){out.println("background-color:#FF99FF");}%>" value="<%=DTO.getName()%>"><br>
                 <font color="red"><% if(name==null){out.println(na);}else{out.println(name);}%><br><br></font>
            
            パスワード<font size="1" color="red">*最低７文字</font><br>
            <input type="password" name="password" style="<%if(password!=null){out.println("background-color:#FF99FF");}%>" ><br><br>
            <font color="red"><% if(password==null){out.println(pa);}else{out.println(password);}%><br><br></font>

            
            メールアドレス<br>
             <input type="text" name="mail" size="18" style="<%if(mail!=null){out.println("background-color:#FF99FF");}%>" value="<%=DTO.getMail()%>">@kagoyume.co.jp<br>
            <font color="red"><% if(mail==null){out.println(ma);}else{out.println(mail);}%><br><br></font>
              
            住所（郵便番号からの参照も可能です）<br>
            <textarea name="addr21" rows="2" cols="30" style="<%if(address!=null){out.println("background-color:#FF99FF");}%>"><%=DTO.getAddress()%></textarea><br>
             <font color="red"><% if(address==null){out.println(ad);}else{out.println(address);}%><br><br></font>
             〒<input type="text" name="zip21" size="2" maxlength="3"> － <input type="text" name="zip22" size="4" maxlength="4" onKeyUp="AjaxZip3.zip2addr('zip21','zip22','addr21','addr21');"><br><br><br>
           
            <input type="submit" name="check" value="登録">&emsp;&emsp;
             <input type="reset" name="reset" value="リセット">
             
             </form>
    </center>
    </body>
</html>
