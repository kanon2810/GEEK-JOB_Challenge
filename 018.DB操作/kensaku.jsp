<%-- 
    Document   : kensaku
    Created on : 2018/06/12, 16:39:58
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

      

</body>
             </style>
    </head>
    <body>
    <center><br><br><br><br><br><br><br>
    <% 
           request.setCharacterEncoding("UTF-8");
           
           
           
           String id=request.getParameter("ID");
           String name=request.getParameter("name");
           String tel=request.getParameter("tel");
           String AGE=request.getParameter("age");
           String birthday=request.getParameter("birthday");
       
           
           //数値系のカラムは文字列型から数値型に変換してあげる
           Integer ID=Integer.parseInt(id);
           Integer age=Integer.parseInt(AGE); 
         
           
String url="jdbc:mysql://localhost:3306/challenge_db"; 
String user="タカ";
String pass="4458259";

Connection cone=null;
PreparedStatement start=null;
ResultSet result=null;
String column="insert into profiles(profilesID,name,tel,age,bithday) values(?,?,?,?,?)";
try{
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    cone=DriverManager.getConnection(url,user,pass);
    start=cone.prepareStatement(column);
    start.setInt(1,ID);
    start.setString(2,name);
    start.setString(3,tel);
    start.setInt(4,age);
    start.setString(5, birthday);
    
    
        
    start.executeUpdate();
    
    start=cone.prepareStatement("select * from profiles");
    
    result=start.executeQuery();
    
   

    
   
    if(age>=120){
        out.print("年齢の値が異常です！！");%>
        <form action="./form2.jsp" method="post">
         <input type="submit" name="retrun" value="戻る">
    </form>
    <%        
    }else if( "".equals(name) || "".equals(tel)){

      out.print("未記入の箇所があります");
%>
         <form action="./form2.jsp" method="post">
         <input type="submit" name="retrun" value="戻る">
    </form>
<%}
else{
    while(result.next()){
         out.println(result.getInt("profilesID")+"|"+result.getString("name")+"|"+result.getString("tel")+"|"+result.getInt("age")+"|"+result.getString("bithday")+"<br>");
  }
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
            
    </center>
    </body>
</html>
