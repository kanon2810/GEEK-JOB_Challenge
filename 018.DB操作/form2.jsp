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

 
 body {
     background:url(gaz.gif);
background-size:10% auto;
 }
</body>
             </style>
    </head>
   
    <body>

     <center>
       <br><br><br><br> <font size="10">データベース操作フォーム</font><br><br><br><br><br>
        <form action="./kensaku.jsp" method="post">
            追加したいレコードを入力してください<br>
            プロフィールＩＤ<input type="text" name="ID" size="2">&emsp;
            名前<input type="text" name="name" >&emsp;
            電話番号<input type="text" name="tel" size="25">&emsp;
            年齢<input type="text" name="age" size="2">&emsp;
            生年月日<input type="text" name="birthday">&emsp;
           
            <br><br>
            <input type="submit" name="t" value="追加">
            
            <br><br> <br><br>
        </form>  
            <%
                 request.setCharacterEncoding("UTF-8");
                 
                 
                 String R=request.getParameter("retrun");
                if(null==R){
                    out.print("");
                }else{
                    out.print("大変お手数ですがもう一度最初からやり直してください");
                }

                %>
                
                
                <form action="./kensaku3.jsp" method="post"><br><br>
                    更新するレコードのＩＤを入れてください<br>
                    <input type="text" name="ID3" size="2"><br>
                    更新したい項目を入れてください<br>
            名前<input type="text" name="name3">&emsp;
            電話番号<input type="text" name="tel3" size="25">&emsp;
            年齢<input type="text" name="age3" size="2">&emsp;
            生年月日<input type="text" name="birthday3">&emsp;
           
            <br><br>
            <input type="submit" name="te2" value="更新">
            
            <br>
                </form>
             <%
                 request.setCharacterEncoding("UTF-8");
                 
                 String R2=request.getParameter("retrun4");
                 if(null==R2){
                     out.print("");
                 }else{
                     out.print("大変お手数ですがもう一度最初からやり直してください");
                 }

              %>
        
               <form action="./kensaku2.jsp" method="post"><br><br><br><br><br><br>
                    削除するＩＤ番号を入力してください<br>
              
                    <input type="text" name="ID2" size="2">
            　　　　<input type="submit" name="ta" value="削除"><br>
               </form>
                 <%
                 request.setCharacterEncoding("UTF-8");
                 
                 request.getParameter("retrun2");
                 

                 %>
              
                      <form action="./kensaku10.jsp" method="post"><br><br><br><br><br><br><br><br>
                    テーブルの状況を確認します
              
                   
            　　　　<input type="submit" name="tab" value="確認">
                    
            
        </form>
     </center>
    
    
</body>
</html>
