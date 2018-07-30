package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Syori.UserDataDTO;
import Syori.KYOUTSU;

public final class Top_jsp extends org.apache.jasper.runtime.HttpJspBase
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

String OUT  = (String)request.getAttribute("OUT"); 
UserDataDTO DTO = (UserDataDTO)session.getAttribute("DATA");

      out.write(" \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>KAGOYUMEショッピング</title>\n");
      out.write("        <style>\n");
      out.write("            span.sample {position:absolute; top:337px; left:885px; }\n");
      out.write("            span.sample2 {position:absolute; left:1000px;} \n");
      out.write("            </style>\n");
      out.write("            \n");
      out.write("    </head>\n");
      out.write("    <body> \n");
      out.write("        <span class=\"sample2\">");
      out.print(KYOUTSU.getInstance().login(DTO));
      out.write("</span>\n");
      out.write("    <center><br><br><br><br><br><br><br><br><br><br>\n");
      out.write("        <img src=\"folder/kagoyume.png\"><br>\n");
      out.write("        <form action=\"./Search\" method=\"get\">\n");
      out.write("            <input type=\"text\" name=\"query\" style=\"width:20em;font-size:150%;border:4px #FF0099 solid;\" placeholder=\"何かお探しですか？\">\n");
      out.write("            <span class=\"sample\">  <input type=\"image\" src=\"folder/search.jpg\" style=\"width:250\" height=\"40\" name=\"search\"></span><br><br><br>\n");
      out.write("            <input type=\"hidden\" name=\"hit\">\n");
      out.write("            \n");
      out.write("   <h1>        ");
if (OUT == null) {
                     out.println("");
                } else {
                     out.println(OUT);
                }
               
      out.write("</h1> \n");
      out.write("               <br><br><br><br>\n");
      out.write("               ");
if(DTO==null){
      out.write("\n");
      out.write("               <a href=\"Resurrection\">もしかして…あなたのアカウントまだ取り返せるかも…</a>\n");
      out.write("               ");
}
      out.write("\n");
      out.write("    </center>\n");
      out.write("</body>\n");
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
