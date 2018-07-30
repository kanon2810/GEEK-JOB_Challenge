<%-- 
    Document   : Add
    Created on : 2018/07/13, 16:21:59
    Author     : タカ
--%>
<%@page import="Syori.UserDataDTO"%>
<%@page import="Syori.KYOUTSU"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="Syori.APIdata"%>
<%UserDataDTO DTO = (UserDataDTO)session.getAttribute("DATA");%>
<%APIdata api = (APIdata)session.getAttribute("api");%>
<%NumberFormat yen = NumberFormat.getCurrencyInstance();%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品の追加</title>
        <style>span.sample {position:absolute; left:1000px;} </style>
    </head>
    <body>
        <%=KYOUTSU.getInstance().home()%>
        <span class="sample"><%=KYOUTSU.getInstance().login(DTO)%></span>
         <center>
        <font size="10" color="red">カートに追加しました！！</font><br><br><br>
        <h2><%=api.getNames()%></h2><br>
        <img src="<%=api.getGaz()%>"><br><br>
        <font size="5" color="red"><%=yen.format(Integer.parseInt(api.getPrices()))%></font>
        <form action="Cart" method="get">
            <input type="submit" style="width:350px" name="cart" value="カートを見る"> 
            
        </form>
          </center>
    </body>
</html>
