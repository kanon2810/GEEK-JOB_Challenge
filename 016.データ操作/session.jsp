<%-- 
    Document   : session
    Created on : 2018/06/05, 10:49:55
    Author     : タカ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
         //セッションの取得
            HttpSession Z=request.getSession();
            

            //セッションからの読み出し
            String n=(String)Z.getAttribute("NAME");
            String j=(String)Z.getAttribute("JYENDA");
            String s=(String)Z.getAttribute("SYUMI");
//nullの場合は…
            String Name="";
            String jen="";
            String Syu="";
if(n==null){
    Name="名前は？";
}else{
    Name=n;
}
if(j==null){
    jen=j;
}

if(s==null){
    Syu="氏名は？";
}else{
    Syu=s;
}
%>
           <form action="./session" method="post"><br>
            
            名前<input type="text" name="nam" value="<%out.print(Name);%>"><br>
            
            性別<select name="jyenda"><br>
                <option value="男性" <%if(jen.equals("男性")){out.print("selected");}%>>男性</option>
                <option value="女性"　<%if(jen.equals("女性")){out.print("selected");}%>>女性</option>
                <option value="ニューハーフ" <%if(jen.equals("ニューハーフ")){out.print("selected");}%>>ニューハーフ</option>
                
                <br>
                趣味<input type="text" name="syu" value="<%out.print(Syu);%>"><br>
         
            </select><br>
            <br>
            
           <input type="submit" name="but">
            
        </form>
        
        
        
    </body>
</html>
