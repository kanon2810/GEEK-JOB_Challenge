<%-- 
    Document   : kensaku2
    Created on : 2018/06/13, 14:20:23
    Author     : タカ
--%>
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
        String eraser=request.getParameter("ID2");
        
Connection cone=null;
PreparedStatement start=null;
ResultSet result=null;
//つなぐためのＵＲＬ　
String url="jdbc:mysql://localhost:3306/challenge_db"; 
try{
Class.forName("com.mysql.jdbc.Driver").newInstance();
cone=DriverManager.getConnection(url,"タカ","4458259");


  
 
 
 


start=cone.prepareStatement("delete from profiles where profilesID=?");

start.setString(1, eraser);  
start.executeUpdate();

 
    
 start=cone.prepareStatement("select * from profiles");
    
 result=start.executeQuery();
if(!"".equals(eraser)){
 while(result.next()){
      out.println(result.getInt("profilesID")+"|"+result.getString("name")+"|"+result.getString("tel")+"|"+result.getInt("age")+"|"+result.getString("bithday")+"<br>");
      }
 out.print("<br>"+"<br>"+"無事、削除ができました！！"+"<br>"+"<br>"+"");
}else{
    out.println("ＩＤを入れてください");
}
 
        %>
        <form action="./form2.jsp" method="post">
         <input type="submit" name="retrun2" value="フォームに戻る">
    </form>
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
        </center>
    </body>
</html>
