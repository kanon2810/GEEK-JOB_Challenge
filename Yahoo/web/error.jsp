<%-- 
    Document   : error
    Created on : 2018/07/07, 15:17:43
    Author     : タカ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>エラー</title>
    </head>
    
    <body>
    <center><br><br><br>
            <font size="8" color="red">⚠エラーが発生しました</font><br><br>
       <%=request.getAttribute("error")%>
         </center> 
    </body>
  
</html>
