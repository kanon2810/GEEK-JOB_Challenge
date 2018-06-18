<%-- 
    Document   : out
    Created on : 2018/06/17, 13:53:26
    Author     : タカ
--%>

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
    <center>
        <br><br><br><br><br><br><br><br>
 
  <%
//セッションの破棄
 request.setCharacterEncoding("UTF-8");
       String ROGUOUT=request.getParameter("LOGUOUT");
HttpSession rogu1 =request.getSession();
          if("ログアウト".equals(ROGUOUT)){
          rogu1.invalidate();
            out.print("ログアウトしました");
            }
           %><br><br>
           
           <form action="./ROGIN0.jsp" method="post">
            
           
            <input type="submit" name="trun" value="元の画面へ">
            </form>
    </center>
    </body>
</html>
