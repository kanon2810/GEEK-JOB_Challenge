<%-- 
    Document   : form2
    Created on : 2018/06/12, 16:27:38
    Author     : タカ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
      <style>

 body{
  background: radial-gradient(rgba(255, 255, 255, 0) 0px, rgba(255, 255, 255, 0.15) 30%, 
      rgba(255, 255, 255, 0.3) 32%, rgba(255, 255, 255, 0) 33%) 0px 0px / 470px 470px, 
      radial-gradient(rgba(255, 255, 255, 0) 0px, rgba(255, 255, 255, 0.1) 11%, rgba(255, 255, 255, 0.3) 13%, 
      rgba(255, 255, 255, 0) 14%) 0px 0px / 970px 970px, radial-gradient(rgba(255, 255, 255, 0) 0px, rgba(255, 255, 255, 0.2) 17%, 
      rgba(255, 255, 255, 0.43) 19%, rgba(255, 255, 255, 0) 20%) 0px 110px / 410px 410px, radial-gradient(rgba(255, 255, 255, 0) 0px, 
      rgba(255, 255, 255, 0.2) 11%, rgba(255, 255, 255, 0.4) 13%, rgba(255, 255, 255, 0) 14%) -130px -170px / 610px 610px, radial-gradient(rgba(255, 255, 255, 0) 0px, 
      rgba(255, 255, 255, 0.2) 11%, rgba(255, 255, 255, 0.4) 13%, rgba(255, 255, 255, 0) 14%) 130px 370px / 530px 530px, radial-gradient(rgba(255, 255, 255, 0) 0px, 
      rgba(255, 255, 255, 0.1) 11%, rgba(255, 255, 255, 0.2) 13%, rgba(255, 255, 255, 0) 14%) 0px 0px / 730px 730px, linear-gradient(45deg, rgb(52, 55, 2) 0%, rgb(24, 69, 0) 20%,
      rgb(24, 117, 70) 30%, rgb(0, 103, 130) 40%, rgb(11, 18, 132) 50%, rgb(118, 14, 161) 60%, rgb(131, 9, 110) 70%, rgb(132, 11, 42) 80%, rgb(177, 62, 18) 90%, 
      rgb(226, 116, 18) 100%) 0% 0% / 100% 100% rgb(132, 11, 42);
}

      

</body>
             </style>
    </head>
   
    <body>

     <center>
       <br><br><br><br> <font size="10">データベース操作フォーム</font><br><br><br><br><br><br><br>
        <form action="./kensaku.jsp" method="post">
            プロフィールＩＤ<input type="text" name="ID" size="2">&emsp;
            名前<input type="text" name="name" >&emsp;
            電話番号<input type="text" name="tel" size="25">&emsp;
            年齢<input type="text" name="age" size="2">&emsp;
            生年月日<input type="text" name="birthday">&emsp;
           
            <br><br>
            <input type="submit" name="table" value="追加">
            
            <br><br> <br><br>
        </form>  
            <%
                 request.setCharacterEncoding("UTF-8");
                 
                 
                 String R=request.getParameter("retrun");
                if(null==R){
                    out.print("");
                }else{
                    out.print("もう一度最初から入力してください");
                }

                %>
                <form action="./kensaku2.jsp" method="post">
                    削除するＩＤ番号を入力してください<br>
              
                    <input type="text" name="ID2" size="2">
            　　　　<input type="submit" name="table" value="削除"><br>
                 <%
                 request.setCharacterEncoding("UTF-8");
                 
                 request.getParameter("retrun2");
              

                %>
            
        </form>
     </center>
    <p style="text-align: right"><img src="gaz.gif" width="150" height="230"></right</p>
    
</body>
</html>
