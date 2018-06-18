<%-- 
    Document   : rogin
    Created on : 2018/06/15, 17:17:02
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
                background: -moz-linear-gradient(top, #FFF, #FFC778 30%, #F89174 60%, #748af8);
                background: -webkit-linear-gradient(top, #FFF, #FFC778 30%, #F89174 60%, #748af8);
                background: linear-gradient(to bottom, #FFF, #FFC778 30%, #F89174 60%, #748af8);
            }
            </body>
        </style>
    </head>
    <body>
        <center><br><br><br><br><br><br><br>
        <%
       request.setCharacterEncoding("UTF-8");
       String ID=request.getParameter("id");
       String PASS=request.getParameter("pass");
        
       
         Connection db_com=null;
        PreparedStatement db_st=null;
        ResultSet db_data=null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();//Mysql用のJDBCドライバのインスタンス生成
            
            db_com=DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","タカ","4458259");//DriverManagerのgetConnentionメソッドでＤＢの接続をする
            db_st=db_com.prepareStatement("insert into LOGIN(ID,PASSWORD) values(?,?)");//接続したら、SQL文を実行するためPreparedStatementを取得
            db_st.setString(1,ID);
             db_st.setString(2,PASS);
             
             
             int NA=ID.length();
             int MA=PASS.length();
             
            if("".equals(ID) || "".equals(PASS)){
                out.println("空欄があります");
                return;
            }else if(ID.length()<8 || PASS.length()<7){
               out.println("ＩＤかパスワードの文字数が足りておりません"+"<br>"+"<br>");
               out.println("※ＩＤは最低８文字、パスワードは最低７文字となります");
               return;
            }else{
                out.println("ご登録受付しました");
            }
        
        
        %>
 <form action="./ROGUIN.jsp" method="post">
         <input type="submit" name="rog" value="ログイン画面へ">
    </form><%
            
            
      db_st.executeUpdate();
      db_st=db_com.prepareStatement("select * from LOGIN");
    
    db_data=db_st.executeQuery();

   db_data.close();
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
    </body>
</html>
