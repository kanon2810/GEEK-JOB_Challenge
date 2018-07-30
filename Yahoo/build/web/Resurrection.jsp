<%-- 
    Document   : Resurrection
    Created on : 2018/07/21, 11:23:59
    Author     : タカ
--%>
<%@page import="Syori.KYOUTSU"%>
<%@page import="Syori.UserDataDTO"%>
<%String trim  = (String)request.getAttribute("trim");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      
      
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>アカウント復活</title>
        <style> body{background-color:#ffcccc}</style>
         <script src="dousa1.js" charset="UTF-8"></script>
    </head>
    <body>
         <p class="sample"><%=KYOUTSU.getInstance().home()%></p><br>
    <center>
       <span class="typeWriter"> <font size='6'>あぁ～、退会してしまったというそこのあなた！！<br>
            10日以内なら、何とかなるかも・・・<br>
            （ただし10日以内でも機械の誤差によっては不可な場合もあります)<br>
            ちなみにアカウントの復活は一度きりとなります。2度目は強制削除とします</font><br><br><br><br><br>
            契約していた頃のユーザーネームを教えてください</span>
            <br>
              <form action="Resurrectionresult" method="post">
               <input type="text" name="name"><br><br>
                  <input type="submit" value="探す"><br><br>
              </form><br><br>
              <%if(trim==null){out.println("");}else{out.println(trim);}%>
        
        
              
    </center>
   
    </body>
</html>
