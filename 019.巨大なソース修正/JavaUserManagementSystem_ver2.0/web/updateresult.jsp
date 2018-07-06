<%@page import="jums.UserDataDTO"%>
<%@page import="java.util.ArrayList"%> 
<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper" %>
<%  
    JumsHelper jh = JumsHelper.getInstance();
   UserDataBeans Beans = (UserDataBeans)session.getAttribute("UpData");
    ArrayList<String> chkList = Beans.chkproperties();
  
%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新結果画面</title>
    </head>
    <body>

        <%if(chkList.size()==0){%>
        <h1>変更結果</h1><br>
        名前:<%=Beans.getName()%><br>
        生年月日:<%=Beans.getYear()+"年"+Beans.getMonth()+"月"+Beans.getDay()+"日"%><br>
        種別:<%=jh.exTypenum(Beans.getType())%><br>
        電話番号:<%=Beans.getTell()%><br>
        自己紹介:<%=Beans.getComment()%><br> 
        以上の内容で更新しました。<br>
        <form action="./resultdetail.jsp" method="post">
            <input type="submit" name="return" value="詳細画面に戻る">   
        </form>
        <%}else{%>
        <h1>未記入箇所があります</h1>
        <%=jh.chkinput(chkList)%>
        <%}%>
    </body>
    <%=jh.home()%>

</html>
