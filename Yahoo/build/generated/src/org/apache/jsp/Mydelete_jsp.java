package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Syori.UserDataDTO;

public final class Mydelete_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
UserDataDTO us = (UserDataDTO)session.getAttribute("DATA");
      out.write("   \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("         <script src=\"dousa1.js\" charset=\"UTF-8\"></script>\n");
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>削除確認</title>\n");
      out.write("          <style> span.sample {position:absolut}</style>\n");
      out.write("          <link rel=\"stylesheet\" href=\"anime2.css\">\n");
      out.write("               <style>\n");
      out.write("            .buruburu {\n");
      out.write("    display: inline-block;\n");
      out.write("    animation: hurueru .1s  infinite;\n");
      out.write("}\n");
      out.write("\n");
      out.write("@keyframes hurueru {\n");
      out.write("    0% {transform: translate(0px, 0px) rotateZ(0deg)}\n");
      out.write("    25% {transform: translate(2px, 2px) rotateZ(1deg)}\n");
      out.write("    50% {transform: translate(0px, 2px) rotateZ(0deg)}\n");
      out.write("    75% {transform: translate(2px, 0px) rotateZ(-1deg)}\n");
      out.write("    100% {transform: translate(0px, 0px) rotateZ(0deg)}\n");
      out.write("}\n");
      out.write("            span.sample {position:absolute; top:337px; left:885px; }\n");
      out.write("            span.sample2 {position:absolute; left:1000px;} \n");
      out.write("            \n");
      out.write("            form_conf {\n");
      out.write("    text-align: center;\n");
      out.write("}\n");
      out.write(".form_conf form {\n");
      out.write("    display: inline-block;\n");
      out.write("    margin: 0 10px;\n");
      out.write("}\n");
      out.write("            </style>\n");
      out.write("    </head>\n");
      out.write("    <body background=\"");
if(us.getOutdate()!=null){out.println("folder/thi.jpg");}else{out.println("folder/pink.png");}
      out.write("\">\n");
      out.write("    <center>\n");
      out.write("        ");
if(us.getOutdate()!=null){
      out.write("\n");
      out.write("        <font size=\"7\" color=\"red\"><b><span class=\"buruburu\">本当に退会しちゃうの？</span></b></font>\n");
      out.write("        ");
}else{
      out.write("\n");
      out.write("        <font size=\"7\"><b>本当に退会しちゃうの？</b></font>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("          <table border=\"1\">\n");
      out.write("         <tr>\n");
      out.write("<th bgcolor=\"#996699\">ユーザーネーム</th>\n");
      out.write("<td bgcolor=\"");
if(us.getOutdate()!=null){out.println("red");}else{out.println("#ffffff");}
      out.write('"');
      out.write('>');
      out.print(us.getName());
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write(" <tr>\n");
      out.write("<th bgcolor=\"#996699\">パスワード</th>\n");
      out.write("<td bgcolor=\"");
if(us.getOutdate()!=null){out.println("red");}else{out.println("#ffffff");}
      out.write("\">非公開</td>\n");
      out.write("</tr>\n");
      out.write(" <tr>\n");
      out.write("<th bgcolor=\"#996699\">メールアドレス</th>\n");
      out.write("<td bgcolor=\"");
if(us.getOutdate()!=null){out.println("red");}else{out.println("#ffffff");}
      out.write('"');
      out.write('>');
      out.print(us.getMail());
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("<th bgcolor=\"#996699\">住所</th>\n");
      out.write("<td bgcolor=\"");
if(us.getOutdate()!=null){out.println("red");}else{out.println("#ffffff");}
      out.write('"');
      out.write('>');
      out.print(us.getAddress());
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("<th bgcolor=\"#996699\">登録日時</th>\n");
      out.write("<td bgcolor=\"");
if(us.getOutdate()!=null){out.println("red");}else{out.println("#ffffff");}
      out.write('"');
      out.write('>');
      out.print(us.Format(us.getNewDate()));
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("          </table><br>\n");
      out.write("<div class=\"form_conf\">\n");
if(us.getOutdate()==null){
      out.write("\n");
      out.write("<form action=\"Mydeleteresult\" method=\"post\">\n");
      out.write("    <input type=\"submit\" name=\"delete\" value=\"はい\">\n");
      out.write("    <input type=\"hidden\" name=\"flagnum\" value=\"1\">\n");
      out.write("</form>\n");
      out.write("<form action=\"./Top.jsp\" method=\"post\">\n");
      out.write("    <input type=\"submit\" name=\"top\" value=\"いいえ\">\n");
      out.write("</form>\n");
}else{
      out.write("\n");
      out.write("        <form action=\"Mydeleteresult\" method=\"post\">\n");
      out.write("    <input type=\"image\" src=\"folder/button2.png\" style=\"width:450\" height=\"100\" name=\"delete\">&ensp;&ensp;&ensp;&ensp;&ensp;\n");
      out.write("    <input type=\"hidden\" name=\"flagnum\" value=\"1\">\n");
      out.write("</form>\n");
      out.write("<form action=\"./Top.jsp\" method=\"post\">\n");
      out.write("   <input type=\"image\" src=\"folder/button.png\" style=\"width:450\" height=\"100\" name=\"top\">\n");
      out.write("</form>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<br><br><br>\n");
      out.write("    </center>\n");
      out.write("<div class=\"textboard\">\n");
      out.write("\n");
      out.write("    <div class=\"test1\"><span class=\"typeWriter\"><font color='red'>");

        if(us.getOutdate()==null){
      out.write("\n");
      out.write("        <font color=\"#FFCCFF\" size=\"7\">今までありがとうございました💗</font>\n");
      out.write("       ");
 }else{
             for(int i=0;i<14;i++){
        out.println("サヨナラサヨナラサヨナラサヨナラサヨナラサヨナラサヨナラ"+"<a href=\""+"./hoka.jsp"+"\">サ</a>"+"ヨナラサヨナラサヨナラサヨナラサヨナラサヨナラサヨナラサヨナラサヨナラサヨナラサヨナラ");
            }
        }
    
      out.write("</font></span></div>\n");
      out.write("    \n");
      out.write("</div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
