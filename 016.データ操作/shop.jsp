<%-- 
    Document   : shop
    Created on : 2018/06/01, 11:29:42
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
       <%@ page import="java.util.ArrayList"%>
        <%
        request.setCharacterEncoding("UTF8");
        
//        ArrayList<String> ("type")=new ArrayList<String>();
        String stype = request.getParameter("type");
        
        if(stype.equals("1")){
            out.print("雑貨品"+"<br>");
        }else if(stype.equals("2")){
            out.print("生鮮食品"+"<br>");
        }else{
            out.print("その他"+"<br>");
        }
        String stotal=request.getParameter("total");
        String snum=request.getParameter("num");
       
//文字型から数値型に変換
        int total=Integer.parseInt(stotal);
        int num=Integer.parseInt(snum);
        
        out.print(total/num);
        out.print("<br>");
        if(total>=5000){
            out.print(total*0.05+"pt");
        }else if(total>=3000&&total<5000){
        out.print(total*0.04+"pt");
        } else{
            out.print(0+"pt");
        }

        




        %>
    </body>
</html>
