<%-- 
    Document   : kensaku10
    Created on : 2018/06/13, 19:57:52
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
       request.getParameter("tab");
       request.getParameter("select");
      
       Connection db_com=null;
        PreparedStatement db_st=null;
        ResultSet db_data=null;
        int count=0;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();//Mysql用のJDBCドライバのインスタンス生成
            
            db_com=DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","タカ","4458259");//DriverManagerのgetConnentionメソッドでＤＢの接続をする
            db_st=db_com.prepareStatement("select * from profiles");//接続したら、SQL文を実行するためPreparedStatementを取得
            
            
            
            db_data=db_st.executeQuery(); //PreparedStatementのexesuteQuarryメソッドの実行
 %>         
 <%           while(db_data.next()){
         %>
          <table border="1">
                     <tr>
                         <th>ID</th><th>名前</th><th>電話番号</th><th>年齢</th><th>誕生日</th>
                                    </tr> 
                     <tr>
                         <td><%out.print(db_data.getString("profilesID"));%></td>
                          <td><%out.print(db_data.getString("name"));%></td>
                           <td><%out.print(db_data.getString("tel"));%></td>
                            <td><%out.print(db_data.getString("age"));%></td>
                             <td><%out.print(db_data.getString("bithday"));%></td>
                     </tr>
                    </table>
            
            <%                       count++;
                                     }
if(count==0){
out.print( "情報が登録されておりません");
}else{
out.print("<br>"+"現在、"+count+"名の情報が登録されています");
}      %>
            <form action="./form2.jsp" method="post">
         <input type="submit" name="retrun2" value="フォームに戻る">
    </form>
            <%            db_data.close();
            db_st.close();
            db_com.close();
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
