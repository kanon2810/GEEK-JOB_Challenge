<%@page import="jums.UserDateBean"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%
    HttpSession hs = request.getSession();
    UserDateBean Beans=(UserDateBean)hs.getAttribute("bean");
    Beans.getName(); 
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        <% if(!Beans.getName().equals("") && !Beans.getTell().equals("")&&!Beans.getComment().equals("")){ %> 
        
        <h1>登録確認</h1>
        名前:<%= Beans.getName()%><br>
        生年月日:<%=Beans.getYear()+"年"+Beans.getMonth()+"月"+Beans.getDay()+"日"%><br>
        種別:<%= Beans.getType()%><br>
        電話番号:<%= Beans.getTell()%><br>
        自己紹介:<%= Beans.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
             <input type="hidden" name="z"  value="<%= hs.getAttribute("z")%>">
            <input type="submit" name="yes" value="はい">
        </form>
    <% }else{ %>
    <h1>入力が不完全です</h1><br><br>
    <%
        if(Beans.getName().equals("")){
            out.println("名前が入力されてません"+"<br>");
        }
        if(Beans.getYear()==0){
            out.println("年が入ってません"+"<br>");
        }
        if(Beans.getMonth()==0){
            out.println("月が入ってません"+"<br>");
        }
        if(Beans.getDay()==0){
            out.println("日が入ってません"+"<br>");
        }
        if(Beans.getTell().equals("")){
            out.println("電話番号が入ってません"+"<br>");
        } 
        if(Beans.getComment().equals("")){
            out.println("自己紹介が入ってません"+"<br>");
        }
    %>
        
    <% } %>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る"><br>
              <%=JumsHelper.getInstance().home()%><br>
        </form>
    </body>
</html>
