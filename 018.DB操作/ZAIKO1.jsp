<%-- 
    Document   : ZAIKO1
    Created on : 2018/06/15, 14:57:01
    Author     : タカ
--%>
<%@page import="java.sql.*"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style>
            body{background-color:#FFFF99} 
            example table {
width: 80%;
height: 10%;
border: 1px #000000 solid;
border-collapse: collapse;
}

.example td {
border: px #000000 solid;
}

.example th {
border: 2px #000000 groove;
background-color: #00ffff;
}
.example table {
width: 80%;
height: 10%;
border: 1px #000000 solid;
border-collapse: collapse;
}

.example td {
border: 1px #000000 solid;
}
<%
 Date D=new Date();
       SimpleDateFormat time=new SimpleDateFormat("yyyy年MM月dd日　HH時mm分");
       String toki=time.format(D);

%>
       </style>
    </head>
        <body>
<div align="right"><%out.print("最終更新時間　　"+toki);%></div>
&emsp;&emsp;&emsp;<font size="6">在庫管理システム</font>  <div align="right"><img src="φ6.gif"  width="250" height="150"> </div>
 <form action="./ZAIKO2.jsp" method="post">
        &emsp;&emsp;&emsp;商品コード<input type="number" name="sina" size="6">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;荷姿<input type="text" name="nisu"><br>
        &emsp;&emsp;&emsp;商品名 &emsp;&nbsp;     <input type="text" name="name">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;数量<input type="number" name="kazu" size="3"><br>
        &emsp;&emsp;&emsp;商品単価&emsp;￥<input type="number" name="worat" size="4">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
        <input type="submit" name="mit" value="登録"> <br>   </form>
      
        
    <br><br>
    
    <%
       
        int count=0;
      
           request.setCharacterEncoding("UTF-8");
         
           String sina=request.getParameter("sina");
           String name=request.getParameter("name");
           String woret=request.getParameter("worat");
           String nisu=request.getParameter("nisu");
           String kazu=request.getParameter("kazu");
           
         

        
 String next=request.getParameter("next");
 if(null==next){
     out.print("");
 }
     
     String url="jdbc:mysql://localhost:3306/challenge_db"; 
String user="タカ";

String pass="4458259";

Connection cone=null;
PreparedStatement start=null;
ResultSet result=null;

try{
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    cone=DriverManager.getConnection(url,user,pass);
 
    start=cone.prepareStatement("select * from zaiko");
 
    
    result=start.executeQuery();
   

%>

    <center>
<div class="example">

<table>
<tr>
   
<th  width="100">商品コード</th>
<th  width="200">商品名</th>
<th width="90">単価</th>
<th width="60">数量</th>
<th  width="100">荷姿 </th>
</tr>
</table>

</div>
<%
   while(result.next()){
       
       
       boolean A="0".equals(result.getString("kazu"));
boolean B="1".equals((result.getString("kazu")));
boolean C="2".equals((result.getString("kazu")));
boolean DD="3".equals((result.getString("kazu")));
boolean E="4".equals((result.getString("kazu")));
boolean F="5".equals((result.getString("kazu")));
boolean G="6".equals((result.getString("kazu")));
boolean H="7".equals((result.getString("kazu")));
boolean I="8".equals((result.getString("kazu")));
boolean J="9".equals((result.getString("kazu")));
boolean K="10".equals((result.getString("kazu")));
if(A||B||C||DD||E||F||G||H||I||J||K){
     
      %>
       <div class="example">

<table>
<tr>

<td width="100" bgcolor="#ff69b4"><%out.print(result.getString("code"));%></td>
<td width="200" bgcolor="#ff69b4"><%out.print(result.getString("name"));%></td>
<td width="90" bgcolor="#ff69b4"><%out.print(result.getString("tanka"));%></td>
<td  width="60" bgcolor="#ff69b4"><%out.print(result.getString("kazu"));%></td>
<td  width="100" bgcolor="#ff69b4"><%out.print(result.getString("nisu"));%></td>
</tr>
</table>

</div>


       
     <%
     
 }else{
       %>
       <div class="example">

<table>
<tr>
<td width="100" bgcolor="#ffffff"><%out.print(result.getString("code"));%></td>
<td width="200" bgcolor="#ffffff"><%out.print(result.getString("name"));%></td>
<td width="90" bgcolor="#ffffff"><%out.print(result.getString("tanka"));%></td>
<td  width="60" bgcolor="#ffffff"><%out.print(result.getString("kazu"));%></td>
<td  width="100" bgcolor="#ffffff"><%out.print(result.getString("nisu"));%></td>
</tr>
</table>

</div>
    


       
     <% }  
        if(null==result.getString("code")||null==result.getString("name")||null==result.getString("tanka")||null==result.getString("kazu")||null==result.getString("nisu")){
            out.print("");
            
        }
     count++;
    }


out.print("<br>"+"<br>"+"現在、"+count+"点の在庫を登録しています"+"<br>");
out.print("赤のレコードは早めに補充お願いします");
     %><br><br>
<form action="./ZAIKO3.jsp" method="post">      

            <input type="number" name="del" size="4">
             <input type="submit" name="delete" value="削除">
        </form>

     </center>
       <div align="right"> <form action="./out.jsp" mothod="post">
            <input type="submit" name="LOGUOUT" value="ログアウト">
           </form></div>
    
<%
    
    cone.close();
    start.close();
    result.close();
  
}catch(SQLException e_sql){
    //例外処理　実行できなかったときは…
   out.print("⚠ＥＲＲＯＲ"+"<br>"+"<br>");
    out.print("以下の原因が考えられます"+"<br>"+ e_sql.toString()+"<br>");
   
}catch(Exception e){
    out.print("⚠ＥＲＲＯＲ"+"<br>"+"<br>");
    out.print("以下の原因が考えられます"+"<br>"+ e.toString()+"<br>");
}
 
    

    %>
        
  


    
      
            
        </form>
    </body>
</html>
