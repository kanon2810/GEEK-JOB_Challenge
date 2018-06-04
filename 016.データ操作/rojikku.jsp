<%-- 
    Document   : rojikku
    Created on : 2018/06/01, 16:17:57
    Author     : タカ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%@ page import="java.util.ArrayList" %>
    <body>
     
        <%
      request.setCharacterEncoding("UTF-8");
          String a=request.getParameter("num");
          int kazu=Integer.parseInt(a);
        
       
out.print(a+"=");
//素因数分解に使う部品(数字）　2,3,5,7,11
while(kazu%2==0){
    kazu=kazu/2;
    out.print("2");
    out.print("*");
   
}
while(kazu%3==0){
         kazu=kazu/3;
     out.print("3");
     out.print("*");
    
}
while(kazu%5==0){
    kazu=kazu/5;
   out.print("5");
   out.print("*");
  
}
while(kazu%7==0){
    kazu=kazu/7;
    out.print("7");
    out.print("*");

}
out.print(kazu);


out.print("の構成で成り立っております");
%>
    </body>
</html>