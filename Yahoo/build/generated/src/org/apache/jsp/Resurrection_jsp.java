package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Syori.KYOUTSU;
import Syori.UserDataDTO;

public final class Resurrection_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <script>\n");
      out.write("        var TargetClassName = \"typeWriter\";\n");
      out.write("// 表示の速さ\n");
      out.write("var DisplaySpeedMiliSec = 60;\n");
      out.write("// カーソルアイコン\n");
      out.write("var CursorIcon = \"|\";\n");
      out.write("\n");
      out.write("window.onload = displayLikeTypeWriter;\n");
      out.write("\n");
      out.write("function displayLikeTypeWriter() {\n");
      out.write("  var counter = 0;\n");
      out.write("  var elements = document.getElementsByClassName(TargetClassName);\n");
      out.write("  for(var i = 0; i < elements.length; i++) {\n");
      out.write("    var element = elements[i];\n");
      out.write("    element.style.visibility = \"visible\";\n");
      out.write("    display(element, element.innerHTML, counter);\n");
      out.write("  }\n");
      out.write("}\n");
      out.write("function display(element, message, counter) {\n");
      out.write("  element.innerHTML = message.substring(0, counter) + CursorIcon;\n");
      out.write("  counter++;\n");
      out.write("  setTimeout(function() {\n");
      out.write("    display(element, message, counter);\n");
      out.write("  }, DisplaySpeedMiliSec);\n");
      out.write("  if (counter > message.length) {\n");
      out.write("    // 最後はカーソルアイコン表示を上書きする\n");
      out.write("    element.innerHTML = message;\n");
      out.write("  }\n");
      out.write("  }\n");
      out.write("    </script>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>アカウント復活</title>\n");
      out.write("        <style> body{background-color:#ffcccc}</style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <p class=\"sample\">");
      out.print(KYOUTSU.getInstance().home());
      out.write("</p><br>\n");
      out.write("    <center>\n");
      out.write("       <span class=\"typeWriter\"> <font size='6'>あぁ～、退会してしまったというそこのあなた！！<br>\n");
      out.write("            10日以内なら、何とかなるかも・・・<br>\n");
      out.write("            （ただし10日以内でも機械の誤差によっては不可な場合もあります<br>\n");
      out.write("            ちなみにアカウントの復活は一度きりとなります。2度目は強制削除とします</font><br><br><br><br><br>\n");
      out.write("            契約していた頃のユーザーネームを教えてください</span>\n");
      out.write("            <br>\n");
      out.write("              <form action=\"Resurrectionresult\" method=\"post\">\n");
      out.write("               <input type=\"text\" name=\"name\"><br><br>\n");
      out.write("                  <input type=\"submit\" value=\"探す\"><br><br>\n");
      out.write("            </form>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("              \n");
      out.write("    </center>\n");
      out.write("   \n");
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
