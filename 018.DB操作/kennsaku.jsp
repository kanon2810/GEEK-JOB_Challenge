<%-- 
    Document   : kennsaku
    Created on : 2018/06/12, 12:20:12
    Author     : タカ
--%>
<%@page import="java.sql.*"%>
<%@page import="javax.swing.*"%>
<%@page import="java.awt.Font"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%
    

  request.setCharacterEncoding("UTF-8");
  
  String N=request.getParameter("name");


//SQLとつなぐフィールド
Connection cone=null;
//SQL文を作成するフィールド
PreparedStatement start=null;
PreparedStatement D=null;
//結果を作成するフィールド
ResultSet result=null;

//URLのフィールド
String url="jdbc:mysql://localhost:3306/challenge_db";
          
try{
    //SQLとつなぎます
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    cone=DriverManager.getConnection(url,"タカ","4458259");
    //SQL文を作成します
    start=cone.prepareStatement("select * from user where name like ?");
    start.setString(1,"%"+N+"%" );
    

   result=start.executeQuery();
  
   D=cone.prepareStatement("select name from user");
  //名前が引っかかるか引っかからないか分岐フラグを立てる
   if(N.equals(D)){
  //nextメソッドでデータを有無を確認してwhileである限り取得します
   while(result.next()){
       out.print(result.getInt("userID")+"|"+result.getString("name")+"|"+result.getString("tell")+"|"+result.getInt("age")+"|"+result.getString("bithday")+"|");
       out.print(result.getInt("departmentID")+"|"+result.getInt("stationID")+"<br>");
   }
  }else{
      out.print("該当するものはありませんでした");
  }
       cone.close();
       start.close();
       result.close();
}catch(SQLException e_sql){
    //例外処理　実行できなかったときは…
   out.print("⚠ＥＲＲＯＲ"+"<br>"+"<br>");
    out.print("以下の原因が考えられます"+"<br>"+ e_sql.toString()+"<br>");
   
}catch(Exception e){
    out.print(e);
    
}
       %>
    </body>
</html>

