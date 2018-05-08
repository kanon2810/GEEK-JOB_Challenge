<%-- 
    Document   : challenge3
    Created on : 2018/05/08, 17:12:05
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
            
            final int BASE=200;
            int num=100;
            
            out.print(BASE+num);
            
            out.print(BASE-num);
            
            out.print(BASE*num);
            
            out.print(BASE/num);
            
          
            
            %>
    </body>
</html>
