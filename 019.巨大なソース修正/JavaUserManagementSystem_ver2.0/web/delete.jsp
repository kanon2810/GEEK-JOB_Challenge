<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>

<%  
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataBeans Beans = (UserDataBeans)hs.getAttribute("Bean");
     UserDataDTO udd = (UserDataDTO)session.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
    <h1>削除確認</h1>
    以下の内容を削除します。よろしいですか？<br>
    名前:<%= Beans.getName()%><br>
    生年月日:<%= Beans.getYear()+"年"+Beans.getMonth()+"月"+Beans.getDay()+"日"%><br>
    種別:<%=jh.exTypenum(Beans.getType())%><br>
    電話番号:<%= Beans.getTell()%><br>
    自己紹介:<%= Beans.getComment()%><br>

    
    <form action="DeleteResult" method="POST">
      <input type="hidden" name="ID" value="<%=udd.getUserID()%>">
      <input type="submit" name="YES" value="はい" style="width:100px">
    </form><br>
    <form action="./resultdetail.jsp" method="POST">
      <input type="submit" name="NO" value="詳細画面に戻る" style="width:100px">
    </form><br>
    <%=jh.home()%>
    </body>
</html>
