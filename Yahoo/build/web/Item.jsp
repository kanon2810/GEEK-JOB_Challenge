<%-- 
    Document   : Item
    Created on : 2018/07/11, 17:12:05
    Author     : タカ
--%>
<%@page import="Syori.UserDataDTO"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="Syori.KYOUTSU"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Syori.APIdata"%>
<%@page import="com.fasterxml.jackson.databind.JsonNode"%>
<%APIdata api = (APIdata)session.getAttribute("api");
UserDataDTO DTO = (UserDataDTO)session.getAttribute("DATA");
 NumberFormat yen = NumberFormat.getCurrencyInstance();  
Integer num = Integer.parseInt(api.getPrices());
 double D = num/1.08;
 double P = num*0.01;
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品詳細</title>
        <style>
          
            span.sample {position:absolute; left:1000px;} 
           
   h2 {
padding: 0.5em;
color: #010101;
background: #eaf3ff;
border-bottom: solid 3px #516ab6;
}
h3 {
padding: 0.25em 0.5em;
color: #494949;
background: transparent;
border-left: solid 5px #7db4e6;
} 


        </style>
    </head>
    <body>
    <%=KYOUTSU.getInstance().home()%> 
     <span class="sample"><%=KYOUTSU.getInstance().login(DTO)%></span>
    <center><br><br><br>
         <div style="border: 5px ridge #00ffff; padding: 10px; height: 800em; width: 50em">
             <h2>商品詳細</h2><br><br>
             
             <div align="left">  <h3>  <%=api.getNames()%></h3></div><br><br><br>
     
       
            <img src="<%=api.getGaz()%>"><br><br>
       
        <div align="left">商品番号：&emsp;&emsp;<%=api.getCcode()%></div>
        <hr width="450" align="left">          
        <div align="left">メーカー名：&emsp;&emsp;</div>
        <hr width="450" align="left">
        <div align="left">定価：&emsp;&emsp;<font color="silver"><%="&yen;"+api.getMprices()%> </font></div>
        <hr width="450" align="left"> 
        <div align="left"> 価格：&emsp;&emsp;<font size="5" color="red"><%=yen.format(num)%></font><font size="2">&emsp;(税抜き&emsp;<%=yen.format((int)D)%>)</font></div>
        <hr width="450" align="left">
        <div align="left"> 獲得ポイント：&emsp;<%=(int)P%>point<font size="2"> &emsp; T会員なら,ポイント5倍で<%=(int)P*5%>point</font></div>
        <hr width="450" align="left">
        <div align="left">送料：&emsp;&emsp;<%=api.getSouryo()%></div>
        <hr width="450" align="left">
        <div align="left">   発送予定：&emsp;&emsp;<%=api.getNyuka()%></div>
        <hr width="450" align="left"><br><br><br>
        <form action="Add" method="post">
           
            <div align="right"><input type="image" src="folder/cart.png" style="width:200" height="45"></div><br><br><br><br>
            
            <%=api.getCaption()%><br>
            <%=api.getDesc()%><br>
            <%=api.getSpa()%><br>
   
        </form>
      
        </div>
    </center>
    </body>
</html>
