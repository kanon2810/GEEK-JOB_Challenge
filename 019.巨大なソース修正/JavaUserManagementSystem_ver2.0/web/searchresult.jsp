
<%@page import="java.util.ArrayList"%>
<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<% 
    JumsHelper jh = JumsHelper.getInstance();
    //ArrayList<UserDataDTO>をリクエストスコープで受け取る
    ArrayList<UserDataDTO> udd = (ArrayList<UserDataDTO>)session.getAttribute("resultData");
   UserDataDTO DTO = new UserDataDTO();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
       
        <table border=1>
            
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
            <tr>
             
<% for ( int i = 0; i < udd.size(); i++ ){%>
  
             <td><a href="ResultDetail?id=<%= udd.get(i).getUserID()%>"><%= udd.get(i).getName()%></a></td>
               <td><%= udd.get(i).getBirthday()%></td>
                <td><%= udd.get(i).getType()%></td>
                <td><%= udd.get(i).Format(DTO.getNewDate())%></td>
                 </tr>
                  <%}%>  
        </table>
    </body>
    <%=jh.home()%>
</html>
