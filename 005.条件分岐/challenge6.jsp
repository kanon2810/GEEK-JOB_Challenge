<%-- 
    Document   : challenge6
    Created on : 2018/05/09, 13:00:15
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
            int type=100;
                    
                    switch(type){
                        case 1:
                            out.print("one");
                            break;
                        case 2:
                            out.print("two");
                            break;
                        default:
                            out.print("想定外");
                            break;
                            
                                
                            }
                    
        %>                  
                           
    </body>
</html>
