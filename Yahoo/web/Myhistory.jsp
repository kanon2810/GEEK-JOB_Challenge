<%-- 
    Document   : Myhistory
    Created on : 2018/07/20, 16:37:09
    Author     : タカ
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Syori.UserDataDTO"%>
<%@page import="Syori.KYOUTSU"%>
<%ArrayList<UserDataDTO> DTO = (ArrayList<UserDataDTO>)session.getAttribute("ADTO");%>
<%UserDataDTO UD = (UserDataDTO)session.getAttribute("DATA");
NumberFormat number = NumberFormat.getCurrencyInstance();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>注文履歴</title>
        <style>span.sample {position:absolute; top:10px; left:1000px }</style>
    </head>
    <body>
        <p class="sample"><%=KYOUTSU.getInstance().home()%><span class="sample"><%=KYOUTSU.getInstance().login(UD)%></span></p><br>
    <center>
          <table border="1">
        <h1>注文履歴を確認する</h1>
        <tr>
           <%for(int i=0;i<DTO.size();i++){
           int price = Integer.parseInt(DTO.get(i).getItemprice());%>
           <td width="100"><img src="<%=DTO.get(i).getItempicture()%>" width="110"  height="110">
           <td width="500"><%=DTO.get(i).getItemCode()%></td> 
           <td width="150"><%=KYOUTSU.getInstance().Paturn(DTO.get(i).getType())%> </td>
           <td width="150"><font size="5" color="red"><%=number.format(price)%></font></td>
           <td width="200"><%=sdf.format(DTO.get(i).getBuyDate())%></td>
        </tr>
        <%}%>
          </table>
    </center>
    </body>
</html>
