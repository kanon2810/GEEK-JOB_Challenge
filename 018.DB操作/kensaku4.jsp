<%-- 
    Document   : kensaku4
    Created on : 2018/06/15, 10:32:30
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
    <center><br><br><br><br><br><br><br><br><br>
        <%
        request.setCharacterEncoding("UTF-8");
        String name4=request.getParameter("name4");
        String age4=request.getParameter("age4");
        String birthday4=request.getParameter("birthday4");
        String AO=request.getParameter("AO");
  

        
      int count=0;
Connection cone=null;
PreparedStatement start=null;
ResultSet result=null;

String url="jdbc:mysql://localhost:3306/challenge_db";

 try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();//Mysql用のJDBCドライバのインスタンス生成
            
            cone=DriverManager.getConnection(url,"タカ","4458259");//DriverManagerのgetConnentionメソッドでＤＢの接続をする
            
             
            if("｜".equals(AO)){
            start=cone.prepareStatement("select * from profiles where name like (?) or age like (?) or bithday like (?)");
            
            }else if("＆".equals(AO)){
                start=cone.prepareStatement("select * from profiles where name like (?) and age like (?) and bithday like (?)");
            }else{
                out.print("ＡＮＤかＯＲを選択してください");
                %>
                 <form action="./form2.jsp" method="post">
          <input type="submit" name="retrun5" value="戻る">
         <%
          return;}
            start.setString(1,"%"+name4+"%");
            start.setString(2,"%"+age4+"%");
            start.setString(3,"%"+birthday4+"%");
            
            result=start.executeQuery(); //PreparedStatementのexesuteQuarryメソッドの実行]
          
   
         
       if( "".equals(name4) || "".equals(age4) || "".equals(birthday4)){
    out.print("空欄があります");   %>
        <form action="./form2.jsp" method="post">
         <input type="submit" name="retrun4" value="戻る">
    </form>
        <% return;
}
          
           while(result.next()){
         %>
          <table border="1">
                     <tr>
                         <th>ID</th><th>名前</th><th>電話番号</th><th>年齢</th><th>誕生日</th>
                                    </tr> 
                     <tr>
                         <td><%out.print(result.getString("profilesID"));%></td>
                          <td><%out.print(result.getString("name"));%></td>
                           <td><%out.print(result.getString("tel"));%></td>
                            <td><%out.print(result.getString("age"));%></td>
                             <td><%out.print(result.getString("bithday"));%></td>
                     </tr>
                    </table>

            <%                       count++;
                                     }

       
if(count==0){
out.print( "該当するプロフィールはありませんでした");
}else{
out.print("<br>"+count+"名の情報が見つかりました");
}      %>
    
        
         <form action="./form2.jsp" method="post">
         <input type="submit" name="retrun2" value="フォームに戻る">
    </form>
            <%            
            result.close();
            start.close();
            cone.close();

        }catch(SQLException e_sql){
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
