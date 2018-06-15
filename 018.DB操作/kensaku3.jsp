<%-- 
    Document   : kensaku3
    Created on : 2018/06/13, 16:28:36
    Author     : タカ
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        body{
     background-color: #f90;
    background-image: -webkit-gradient(linear, 0 0, 100% 0, color-stop(.5, rgba(255, 255, 255, .2)), color-stop(.5, transparent), to(transparent));
    background-image: -moz-linear-gradient(0deg, rgba(255, 255, 255, .2) 50%, transparent 50%, transparent);
    background-image: -o-linear-gradient(0deg, rgba(255, 255, 255, .2) 50%, transparent 50%, transparent);
    background-image: linear-gradient(0deg, rgba(255, 255, 255, .2) 50%, transparent 50%, transparent);

}
    </style>
    </head>
    <body>
        <center><br><br><br><br><br><br><br>
        <%
        request.setCharacterEncoding("UTF-8");
         String id=request.getParameter("ID3");
           String name=request.getParameter("name3");
           String tel=request.getParameter("tel3");
           String AGE=request.getParameter("age3");
           String birthday=request.getParameter("birthday3");
         Date D=new Date();
           SimpleDateFormat time=new SimpleDateFormat("yyyy年MM月dd日　HH:mm:ss");
      
        
Connection cone=null;
PreparedStatement start=null;
ResultSet result=null;

//つなぐためのＵＲＬ　
String url="jdbc:mysql://localhost:3306/challenge_db"; 
try{
Class.forName("com.mysql.jdbc.Driver").newInstance();
cone=DriverManager.getConnection(url,"タカ","4458259");


start=cone.prepareStatement("update profiles set name=?,tel=?,age=?, bithday=?  where profilesID=?");
start.setString(1,name);  
start.setString(2,tel);
start.setString(3,AGE);
start.setString(4,birthday);
start.setString(5,id);


start.executeUpdate();

 start=cone.prepareStatement("select * from profiles");
   
 result=start.executeQuery();
 
   
if( "".equals(name) || "".equals(tel) ||"".equals(AGE) || "".equals(birthday)){
    out.print("空欄があります");   %>
        <form action="./form2.jsp" method="post">
         <input type="submit" name="retrun4" value="戻る">
    </form>
        <%
}else if("".equals(id)){
    out.print("プロフィールＩＤを入れてください"); %>
    
    <form action="./form2.jsp" method="post">
         <input type="submit" name="retrun4" value="戻る">
    </form>
    <%
}else{
    
    out.print("<br>"+"<br>"+"無事、更新ができました！！"+"<br>"+"<br>"+time.format(D)+"現在");
         
    %>
     <form action="./kensaku10.jsp" method="post">
         <input type="submit" name="select" value="確認">
    </form>
 <form action="./form2.jsp" method="post">
         <input type="submit" name="retrun2" value="フォームに戻る">
    </form>
<%        }

%>
    
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