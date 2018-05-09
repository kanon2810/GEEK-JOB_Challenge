<%-- 
    Document   : challenge9
    Created on : 2018/05/09, 20:32:36
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
        <%@ page import="java.util.HashMap"%>
        <%
        HashMap<String,String> word=new HashMap<String,String>();
            
             
                word.put("AAA","1");
          word.put("world","hello");
          word.put("33","soeda");
          word.put("20","20");
          
          out.print(word.get("AAA"));
          out.print(word.get("world"));
          out.print(word.get("33"));
          out.print(word.get("20"));
%>
    </body>
</html>
