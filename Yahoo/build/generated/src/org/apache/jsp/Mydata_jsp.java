package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Syori.KYOUTSU;
import Syori.UserDate;
import Syori.UserDataDTO;

public final class Mydata_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
UserDataDTO us = (UserDataDTO)session.getAttribute("DATA");
      out.write("                                            \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>ユーザーデータ</title>\n");
      out.write("        <style>\n");
      out.write(" span.sample {position:absolute; top:10px; left:1000px }\n");
      out.write("</style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <p class=\"sample\">");
      out.print(KYOUTSU.getInstance().home());
      out.write("<span class=\"sample\">ようこそ");
      out.print(us.getName());
      out.write("さん</span></p>\n");
      out.write("    <center>\n");
      out.write("        <table border=\"1\">\n");
      out.write("   \n");
      out.write("   <h1>ユーザー情報</h1>  <br><br>\n");
      out.write("       \n");
      out.write("  <tr>\n");
      out.write("      <th bgcolor=\"#ff6600\" width=\"250\"><h2>ユーザーネーム</h2></th>\n");
      out.write("      <td width=\"400\"><h2>");
      out.print(us.getName());
      out.write("</H2></td>\n");
      out.write("</tr>\n");
      out.write(" <tr>\n");
      out.write("     <th bgcolor=\"#ff6600\" width=\"250\"><h2>パスワード</h2></th>\n");
      out.write("     <td width=\"400\"><font size=\"5\">非公開</font>&emsp;パスワードを忘れた場合は<a href=\"Myupdata\">こちら</a></td>\n");
      out.write("</tr>\n");
      out.write(" <tr>\n");
      out.write("     <th bgcolor=\"#ff6600\" width=\"250\"><h2>メールアドレス</h2></th>\n");
      out.write("<td width=\"400\"><h2>");
      out.print(us.getMail());
      out.write("</h2></td>\n");
      out.write("</tr>\n");
      out.write("<th bgcolor=\"#ff6600\" width=\"250\"><h2>住所</h2></th>\n");
      out.write("<td width=\"400\"><h2>");
      out.print(us.getAddress());
      out.write("</h2></td>\n");
      out.write("</tr>\n");
      out.write("<th bgcolor=\"#ff6600\" width=\"250\"><h2>登録日時</h2></th>\n");
      out.write("<td width=\"400\"><h2>");
      out.print(us.Format(us.getNewDate()));
      out.write("</h2></td>\n");
      out.write("</tr>\n");
      out.write("         \n");
      out.write("        \n");
      out.write("       <br><br>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("<form action=\"Myhistory\" method=\"post\">\n");
      out.write("    <input type=\"image\" src=\"folder/tyumon.png\" style=\"width:340\" height=\"65\" name=\"search\">\n");
      out.write("</form>\n");
      out.write("<form action=\"Myupdata\" metod=\"post\">\n");
      out.write("     <input type=\"image\" src=\"folder/kousin.png\" style=\"width:340\" height=\"65\" name=\"search\">\n");
      out.write("</form>\n");
      out.write("         <form action=\"Mydelete\" metod=\"post\">\n");
      out.write("     <input type=\"image\" src=\"folder/off.png\" style=\"width:340\" height=\"65\" name=\"search\">\n");
      out.write("</form>\n");
      out.write("    </center>\n");
      out.write("    </body> \n");
      out.write("</html>");
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
