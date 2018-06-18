<%-- 
    Document   : ZAIKO2
    Created on : 2018/06/18, 3:05:40
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
            body{background-color:#FFFF99} 
            
            </body>
            </style>
    </head>
    <body>
     <center>
        <br><br><br><br><br><br><br><br>
        
       <%
        request.setCharacterEncoding("UTF-8");
           String sina=request.getParameter("sina");
           String name=request.getParameter("name");
           String woret=request.getParameter("worat");
           String nisu=request.getParameter("nisu");
           String kazu=request.getParameter("kazu");
       
       

String url="jdbc:mysql://localhost:3306/challenge_db"; 
String user="タカ";
String pass="4458259";

Connection cone=null;
PreparedStatement start=null;
ResultSet result=null;
String column="insert into zaiko(code,name,nisu,tanka,kazu) values(?,?,?,?,?)";
try{
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    cone=DriverManager.getConnection(url,user,pass);
    if("".equals(sina)||"".equals(name)||"".equals(nisu)||"".equals(woret)||"".equals(kazu)){
        out.print("空欄があります");
        return;
    }else{
    start=cone.prepareStatement(column);
    start.setString(1,sina);
    start.setString(2,name);
    start.setString(3,nisu);
    start.setString(4,woret);
    start.setString(5,kazu);
      start.executeUpdate();
      start=cone.prepareStatement("select * from zaiko");
    
      
    result=start.executeQuery();
    
    cone.close();
    start.close();
    result.close();
    out.print("登録しました");
    }
    
}catch(SQLException e_sql){
    //例外処理　実行できなかったときは…
   
   
}catch(Exception e){
    
}
       %></form>
        <form action="./ZAIKO1.jsp" method="post">
             <input type="submit" name="next" value="管理ページへ">
        </form>
     </center>
    </body>
</html>
