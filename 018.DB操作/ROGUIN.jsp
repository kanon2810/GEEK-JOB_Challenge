<%-- 
    Document   : ROGUIN
    Created on : 2018/06/15, 14:56:01
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
                background: -moz-linear-gradient(top, #FFF, #FFC778 30%, #F89174 60%, #748af8);
                background: -webkit-linear-gradient(top, #FFF, #FFC778 30%, #F89174 60%, #748af8);
                background: linear-gradient(to bottom, #FFF, #FFC778 30%, #F89174 60%, #748af8);
            }
            </body>
        </style>
    </head>
    
    <body>
    <center>
     <%
      //セッションのインスタンス
       HttpSession setu=request.getSession();
            //セッションを読み出し
            String se=(String)setu.getAttribute("ID");
         String sl=(String)setu.getAttribute("PASS");
         //nullチェック
         String s="";
         String l="";
          
          
         if(null==se){
             s="";
         }else{
             s=se;
         }
         if(null==sl){
             l="";
         }else{
             l=sl;
            
}

  
             
         


            
           
         
        

       
     %>
     
        <br><br><br><br><br><br><br> <font size="10">在庫管理システム</font><br><br><br><br><br>
     
        <form action="./LOGIN" method="post">
            ユーザーID<input type="text" name="id1" value="<%out.print(s);%>"><br>
            パスワード<input type="password" name="pass1" value="<%out.print(l);%>"><br>
            <input type="submit" name="sub" value="ログイン" ><br><br>
         <%
         if(null!=sl){
               if("".equals(se)||"".equals(sl)){  %><font size="4" color="red">ＩＤとパスワードあるいはどちらかが入力されておりません</font><% }
               else{%><font size="4" color="red">認証できませんでした</font><% } 
         }
String a=request.getParameter("sub");

request.setCharacterEncoding("UTF-8");
request.getParameter("end");

         %> 
         
             
         </form>
             
        
          
          
    </center>
    </body>
</html>
