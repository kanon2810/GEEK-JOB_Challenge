<%-- 
    Document   : Buycomplete
    Created on : 2018/07/17, 10:36:53
    Author     : タカ
--%>
<%@page import="Syori.KYOUTSU"%>
<%@page import="Syori.UserDataDTO"%>
<% UserDataDTO UD = (UserDataDTO)session.getAttribute("udate");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>注文が完了しました</title>
        <style>span.sample {position:absolute; top:10px; left:1000px }</style>
        <link rel="stylesheet" href="style3.css"> 
    </head>
    <body>
      
        <p class="sample"><%=KYOUTSU.getInstance().home()%><span class="sample"><%=KYOUTSU.getInstance().login(UD)%></span></p><br>
    <center><br><br><br>
        
        <div class="wrapper">
        <div class="line line1">
            <span class="circle circle-top"></span>
            <div class="dotted">
                <span class="dot dot-top"></span>
                <span class="dot dot-middle-top"></span>
                <span class="dot dot-middle-bottom"></span>
                <span class="dot dot-bottom"></span>
            </div>
            <span class="circle circle-bottom"></span>
        </div>
        <div class="line line2">
            <span class="circle circle-top"></span>
            <div class="dotted">
                <span class="dot dot-top"></span>
                <span class="dot dot-middle-top"></span>
                <span class="dot dot-middle-bottom"></span>
                <span class="dot dot-bottom"></span>
            </div>
            <span class="circle circle-bottom"></span>
        </div>
        <div class="line line3">
            <span class="circle circle-top"></span>
            <div class="dotted">
                <span class="dot dot-top"></span>
                <span class="dot dot-middle-top"></span>
                <span class="dot dot-middle-bottom"></span>
                <span class="dot dot-bottom"></span>
            </div>
            <span class="circle circle-bottom"></span>
        </div>
        <div class="line line4">
            <span class="circle circle-top"></span>
            <div class="dotted">
                <span class="dot dot-top"></span>
                <span class="dot dot-middle-top"></span>
                <span class="dot dot-middle-bottom"></span>
                <span class="dot dot-bottom"></span>
            </div>
            <span class="circle circle-bottom"></span>
        </div>
        <div class="line line5">
            <span class="circle circle-top"></span>
            <div class="dotted">
                <span class="dot dot-top"></span>
                <span class="dot dot-middle-top"></span>
                <span class="dot dot-middle-bottom"></span>
                <span class="dot dot-bottom"></span>
            </div>
            <span class="circle circle-bottom"></span>
        </div>
           &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp; <font color="white" size="10">注文が完了しました</font>
        <div class="line line6">
            <span class="circle circle-top"></span>
            <div class="dotted">
                <span class="dot dot-top"></span>
                <span class="dot dot-middle-top"></span>
                <span class="dot dot-middle-bottom"></span>
                <span class="dot dot-bottom"></span>
            </div>
            <span class="circle circle-bottom"></span>
        </div>
        <div class="line line7">
            <span class="circle circle-top"></span>
            <div class="dotted">
                <span class="dot dot-top"></span>
                <span class="dot dot-middle-top"></span>
                <span class="dot dot-middle-bottom"></span>
                <span class="dot dot-bottom"></span>
            </div>
            <span class="circle circle-bottom"></span>
        </div>
        <div class="line line8">
            <span class="circle circle-top"></span>
            <div class="dotted">
                <span class="dot dot-top"></span>
                <span class="dot dot-middle-top"></span>
                <span class="dot dot-middle-bottom"></span>
                <span class="dot dot-bottom"></span>
            </div>
            <span class="circle circle-bottom"></span>
        </div>
        <div class="line line9">
            <span class="circle circle-top"></span>
            <div class="dotted">
                <span class="dot dot-top"></span>
                <span class="dot dot-middle-top"></span>
                <span class="dot dot-middle-bottom"></span>
                <span class="dot dot-bottom"></span>
            </div>
            <span class="circle circle-bottom"></span>
        </div>
        <div class="line line10">
            <span class="circle circle-top"></span>
            <div class="dotted">
                <span class="dot dot-top"></span>
                <span class="dot dot-middle-top"></span>
                <span class="dot dot-middle-bottom"></span>
                <span class="dot dot-bottom"></span>
            </div>
            <span class="circle circle-bottom"></span>
        </div>
        <div class="line line11">
            <span class="circle circle-top"></span>
            <div class="dotted">
                <span class="dot dot-top"></span>
                <span class="dot dot-middle-top"></span>
                <span class="dot dot-middle-bottom"></span>
                <span class="dot dot-bottom"></span>
            </div>
            <span class="circle circle-bottom"></span>
        </div>
    </div>
    
          </center> 
    </body>
</html>
