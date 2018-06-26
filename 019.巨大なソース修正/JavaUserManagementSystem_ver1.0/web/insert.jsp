<%@page import="jums.UserDateBean"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%
    HttpSession hs = request.getSession();
  
UserDateBean Beans=(UserDateBean)hs.getAttribute("bean");



%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="insertconfirm" method="POST">
        名前:
        <input type="text" name="name" value="<%if(Beans!=null){out.print(Beans.getName());}%>">
        <br><br>

        生年月日:
        <select name="year">
            <option value="">----</option> 
            <%
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>" <%if(Beans!=null){if(Beans.getYear()==i){out.println("selected");}}%>><%=i%> </option>
            <% } %>
        </select>年 
        <select name="month">
            <option value="">--</option>
            <%
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>" <%if(Beans!=null){if(Beans.getMonth()==i){out.println("selected");}}%>><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="">--</option>
            <%
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"  <%if(Beans!=null){if(Beans.getDay()==i){out.println("selected");}}%>><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>                                                                                           
        <input type="radio" name="type" value="1"<%if(Beans!=null){if(Beans.getType()==1){out.println("checked");}}%>>エンジニア<br>
        <input type="radio" name="type" value="2"<%if(Beans!=null){if(Beans.getType()==2){out.println("checked");}}%>>営業<br>
        <input type="radio" name="type" value="3"<%if(Beans!=null){if(Beans.getType()==3){out.println("checked");}}%>>その他<br>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%if(Beans!=null){out.println(Beans.getTell());}%>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%if(Beans!=null){out.println(Beans.getComment());}%></textarea><br><br>

        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
