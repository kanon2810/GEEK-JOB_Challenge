<%-- 
    Document   : Cart
    Created on : 2018/07/12, 21:19:57
    Author     : タカ
--%>
<%@page import="Syori.KYOUTSU"%>
<%@page import="Syori.APIdata"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Syori.UserDataDTO"%>
<%ArrayList<UserDataDTO> DTO = (ArrayList<UserDataDTO>) session.getAttribute("UD");%>
<%NumberFormat number = NumberFormat.getCurrencyInstance();%>
<% int total = 0; int count = 0;%> 
<%UserDataDTO UD = (UserDataDTO)session.getAttribute("DATA");%>
<%String delete = (String)request.getAttribute("itemerase"); String dele=""; if(delete==null){dele="";}else{dele=delete;}%>
 <%String messege = (String)request.getAttribute("rbox");%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ショッピングカート</title>
        <style>   span.sample {position:absolute; left:1000px;} </style>
   
    </head>
    <body> 
        <%=KYOUTSU.getInstance().home()%>
             <span class="sample"><%=KYOUTSU.getInstance().login(UD)%></span>
    <center>
        <h1>カートの中身を確認します</h1><br><br>
        <font color="red" size="8"> <%if(messege==null){out.println("");}else{out.println(messege);}%> </font>
        <%=dele%>
        <table border=1>
             <form action="Buyconfirm" method="GET">
        <%for(int i=0;i<DTO.size();i++ ){%> 
        <%int num = Integer.parseInt(DTO.get(i).getPrice());%>
          <tr bgcolor="#CCFF99">
      
              <td>  <input type="checkbox" name="box" value="<%=DTO.get(i).getID()%>" <%if(messege==null)out.println("checked");%>></td>
                     
        <td width="90"> <img src="<%=DTO.get(i).getPicture()%>"  width="110"  height="110"></td>
        <td width="550"><a href="Item?item=<%=DTO.get(i).getItemcode()%>"><h4><%=DTO.get(i).getItem()%></h4></a></td>
        <td width="150"><font size="6" color="red"><%=number.format(num)%></font></td>
    　　
             <td width="80"><a href="Delete?itemdelete=<%=DTO.get(i).getID()%>"><img src="folder/delete.png" style="width:80" height="70"></a></td>
          
           </tr>           
           <%total = total+num;
              count++;%>
             <%}%>
        </table>
        <%if(count == 0){out.println("現在、かごに入れている商品はありません");}else{%>
         <%="現在、カゴには"+count+"点の商品が入ってます"%><br>
         <font size="12" color="red"><%="合計金額　"+number.format(total)%></font><br><br>
         <input type="image" src="folder/LEGI.png" style="width:200" height="70">
      <%}%>
     
       
</form>
           
    
    </center>
    </body>
</html>
