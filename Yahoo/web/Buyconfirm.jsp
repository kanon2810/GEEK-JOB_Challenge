<%-- 
    Document   : Buy
    Created on : 2018/07/16, 4:31:15
    Author     : タカ
--%>
<%@page import="java.text.NumberFormat"%>
<%@page import="Syori.KYOUTSU"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Syori.UserDataDTO"%>
<%ArrayList<UserDataDTO> DTO = (ArrayList<UserDataDTO>)session.getAttribute("buydata");%>
<%UserDataDTO UD = (UserDataDTO)session.getAttribute("DATA");%>
<%NumberFormat number = NumberFormat.getCurrencyInstance();%>
<%String[] shipping = {"ゆうメール(250円)","レターパック(390円)","定形外郵便(150円)","クロネコヤマト(780円)","ゆうパック(690円)","クリックポスト(164円)","ゆうパケット(280円)"};%>
<%String[] pay = {"コンビニ決済","代金引換","銀行振り込み(振り込み手数料はお客様負担となります)"};%>
<%int total = 0;%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>レジに進みます</title>
        <style>span.sample{position:absolute; top:10px; left:1000px }</style>
<script>
function hyoji() {
    document.getElementById("box").style.display="block";
}

function hihyoji() {
    document.getElementById("box").style.display="none";
}
</script>

    </head>
    
    <body>
        <img src="folder/kagoyume.png" width="420" height="60">
        <span class="sample"><%=KYOUTSU.getInstance().login(UD)%></span>
    <center>
        <H1>ご注文を行います</H1>
    <table border=1>
       <%for(int i=0;i<DTO.size();i++){%>
       <%int yen = Integer.parseInt(DTO.get(i).getPrice());%>
    <tr>
        <td> <img src="<%=DTO.get(i).getPicture()%>" width="110"  height="110"></td>
        <td> <h4> <%=DTO.get(i).getItem()%></h4></td>
        <td> <font color="red" size="6"><%=number.format(yen)%></font></td>
    </tr>
    <%total = total + yen;%>
    <%}%><br><br>
    <font size="8" color="red">注文合計<%=number.format(total)%></font><br><br><br>
    </table>
        
    </center>
    <h4> 発送方法をお選びください</h4><br><br>
    <form action="Buycomplete" method="post">
        <%for(int i=0;i<shipping.length;i++){%>
        <input type="radio" name="shi" value="<%=i%>" checked><%=shipping[i]%><br>
      
     <%}%>
     <h4> 支払い方法をお選びください</4><br>
     <%for (int i=0;i<pay.length;i++){%>
     <input type="radio" name="pay" value="<%=i%>" onclick="hihyoji()" checked><%=pay[i]%><br>
     <%}%>
     <input type="radio" name="pay" value="3" onclick="hyoji()">クレジットカード<br><br>
     <div id="box">
         カード番号を入力してください<br>
         <%for(int i=0;i<=3;i++){%>
         <input type="number" name="number" size="2" maxlength="4">&emsp;
         <% }%><br><br>
         <select name="year">
             <%for(int i=2020;i<=2045;i++){%>
             <option><%=i%>
                 <%}%>
         </select>
         <select name="month">
             <%for(int i=1;i<=12;i++){%>
             <option><%=i%>
                 <%}%>
         </select>
         
             
     </div>
     <input type="submit">
       <input type="hidden" name="total" value="<%=total%>">
       
    </form>

    </body>
</html>
