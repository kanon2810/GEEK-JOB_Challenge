<%-- 
    Document   : challenge5
    Created on : 2018/05/08, 21:22:33
    Author     : タカ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            int num=2000;
            
            if(num==1){
                out.print("1です！");
           }else if(num==2){
               out.print("プログラミングキャンプ！");
           }else{
               out.print("その他です！！");
                      
           }
            
            %>
            
                   
    </body>
</html>
