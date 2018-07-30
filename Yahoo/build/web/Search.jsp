<%-- 
    Document   : Search
    Created on : 2018/07/07, 11:38:26
    Author     : タカ
--%>
<%@page import="Syori.UserDataDTO"%>
<%@page import="java.util.Optional"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="Syori.APIdata"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Syori.KYOUTSU"%>
<% ArrayList<APIdata> Array = (ArrayList<APIdata>)session.getAttribute("API");
  APIdata query = (APIdata)session.getAttribute("query"); 
  boolean flag = false; int count = 0; 
NumberFormat nfCur = NumberFormat.getCurrencyInstance();  
 UserDataDTO DTO = (UserDataDTO)session.getAttribute("DATA");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>検索結果</title>
        <style>
span.sample {position:absolute; top:10px; left:1000px }
span.sample2 {position:absolute; top:80px; left:50px }
span.sample3 {position:absolute; top:60px; left:800px }
        </style>
    </head>
    <body>
        <p class="sample"><%=KYOUTSU.getInstance().home()%><span class="sample"><%=KYOUTSU.getInstance().login(DTO)%></span></p><br>
        <form action="Cart" method="post">
         <span class="sample3"><input type="image" src="folder/cart2.png" name="Cart" style="width:150" height="75"> </span>
        </form>
      <br>
         <form action="./Search" method="get">
     <span class="sample2"><input type="text" name="query" style="width:10em;font-size:150%;border:4px #FF0099 solid;" value="<%=query.getQuery()%>">
               <input type="image" src="folder/search.jpg" style="width:150" height="30"> 
            
         &ensp;&ensp;&ensp;  表示検索件数 <select name="hit">
                <%for(int i=10;i<=50;i+=10){%>
                <option value="<%=i%>"><%=i%></option>
                <%}%>
            </select></span>
         </form>
    <center>
          <table border=1>
   
        
              <br><br>
       <%for(int i=0;i<Array.size();i++){%> 
       <%int kazu = Integer.parseInt(Array.get(i).getPrice());
      
       %>
        <tr bgcolor="#f0f8ff">
            <td width="80"><a href="Item?item=<%=Array.get(i).getITEMcode()%>"><img src="<%=Array.get(i).getImg()%>"></a></td>
       <td width="800" bgcolor="<%if(count<2){out.println("#ffff66");}else if(kazu<500){out.println("#ffcccc");}%>">
           <%if(count<2){%><font size="1" color="red">おすすめ！<br></font><%}else if(kazu<500){%><font size="1" color="red">超お買い得！<br></font><%}%>
           <a href="Item?item=<%=Array.get(i).getITEMcode()%>"><%=Array.get(i).getSina()%></a><br>
           <font size="5" color="red">&emsp;<%=nfCur.format(kazu)%></font>&emsp;
         <font color="#696969">メーカー希望小売価格：&yen;<%=Array.get(i).getMprice()%></font></td>
       
         </tr>
         
       <%    count++;
       flag = true;}if(!flag){%><font size="10" color="red"><%out.println("<br>"+"<br>"+"該当するものはありませんでした");}%></font><br>
       　　　　　<font color="red"><%=query.getQuery()%></font><font color="blue">で,検索させた結果全部で<%=count%>件ひっかかりました</font>
    </center>

    </body>
</html>
