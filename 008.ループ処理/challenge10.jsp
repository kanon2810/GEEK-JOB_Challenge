<%-- 
    Document   : challenge10
    Created on : 2018/05/10, 12:41:22
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
           
       
      
           long kekka=1; 
          
      for (int i=1; i<=20; i++ ) {
           kekka=kekka*8;
      
           }
      
           out.print(kekka);
    
            
     %>
    </body>
</html>
