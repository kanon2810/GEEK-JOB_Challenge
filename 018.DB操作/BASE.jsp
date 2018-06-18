<%-- 
    Document   : BASE
    Created on : 2018/06/18, 0:08:09
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
    </head>
    <body>
       <%
       
       
       Date D=new Date();
     
           SimpleDateFormat time=new SimpleDateFormat("yyyy年MM月dd日　HH:mm:ss");
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
String column="insert into zaiko1(code,name,nisu,tanka,kazu) values(?,?,?,?,?)";
try{
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    cone=DriverManager.getConnection(url,user,pass);
   
      start=cone.prepareStatement("select * from zaiko");
    
    result=start.executeQuery();

    while(result.next()){
        out.print(result.getString("code"));
     
    }

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
    </body>
</html>
