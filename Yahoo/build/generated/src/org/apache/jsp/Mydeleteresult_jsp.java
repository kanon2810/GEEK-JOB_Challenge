package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Syori.KYOUTSU;
import Syori.UserDataDTO;

public final class Mydeleteresult_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" ");
UserDataDTO UD = (UserDataDTO)session.getAttribute("DATA");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>削除完了</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"style2.css\"> \n");
      out.write("          <style>   span.sample {position:absolute; left:1000px;} </style>\n");
      out.write("    </head>\n");
      out.write("    <body background=\"");
if(UD.getOutdate()!=null)out.println("folder/holla.jpg");
      out.write("\">\n");
      out.write("         <p class=\"sample\">");
      out.print(KYOUTSU.getInstance().home());
      out.write("<span class=\"sample\">");
      out.print(KYOUTSU.getInstance().login(UD));
      out.write("</span></p><br>\n");
      out.write("         ");
if(UD.getOutdate()==null){
      out.write("\n");
      out.write("<div id='stars'></div>\n");
      out.write("<div id='stars2'></div>\n");
      out.write("<div id='stars3'></div>\n");
      out.write("<div id='title'>\n");
      out.write("  <span>\n");
      out.write("  </span>\n");
      out.write("  <br>\n");
      out.write("  <span>\n");
      out.write("   削除が完了しました\n");
      out.write("  </span>\n");
      out.write("</div>\n");
}else{
      out.write("\n");
      out.write("<br><br><img src=\"folder/moji.png\">\n");
}
      out.write(" \n");
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
