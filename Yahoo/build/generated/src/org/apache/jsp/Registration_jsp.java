package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Syori.UserDate;
import Syori.KYOUTSU;

public final class Registration_jsp extends org.apache.jasper.runtime.HttpJspBase
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
   
    String name=(String)request.getAttribute("rname"); String na="";
  String password=(String)request.getAttribute("rpassword"); String pa="";
  String mail=(String)request.getAttribute("rmail"); String ma="";
  String address=(String)request.getAttribute("raddress"); String ad="";
  
   UserDate DATA = (UserDate)session.getAttribute("ud");
  UserDate us = null;
    boolean flag = false;
    if(request.getParameter("no") != null){
        flag = true;
        us = (UserDate)session.getAttribute("ud");
    }
 

      out.write(" \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>新規登録フォーム</title>\n");
      out.write("         <script src=\"https://ajaxzip3.github.io/ajaxzip3.js\" charset=\"UTF-8\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body background=\"folder/sora1.jpg\">\n");
      out.write("        ");
      out.print(KYOUTSU.getInstance().home());
      out.write("\n");
      out.write("    <center>\n");
      out.write("        <font size=\"10\" color=\"red\">");
if(request.getAttribute("me")==null){out.println("");}else{out.println(request.getAttribute("me"));}
      out.write("</font><br>\n");
      out.write("        <h1>新規登録を行います</h1><br>\n");
      out.write("        ユーザーネームを決めてください<br>\n");
      out.write("        \n");
      out.write("             <form action=\"Registrationconfirm\" method=\"post\">\n");
      out.write("                 <input type=\"text\"  name=\"name\" style=\"");
if(name!=null){out.println("background-color:#FF99FF");}
      out.write("\" value=\"");
if(flag){out.println(us.getName());}
      out.write("\"><br>\n");
      out.write("                 <font color=\"red\">");
 if(name==null){out.println(na);}else{out.println(name);}
      out.write("<br><br></font>\n");
      out.write("            \n");
      out.write("            パスワードを決めてください<font size=\"1\" color=\"red\">*最低７文字</font><br>\n");
      out.write("            <input type=\"password\" name=\"password\" style=\"");
if(password!=null){out.println("background-color:#FF99FF");}
      out.write("\" value=\"");
if(flag){out.println(us.getPassword());}
      out.write("\"><br><br>\n");
      out.write("            \n");
      out.write("            確認のためもう一度入れてください<br>\n");
      out.write("            <input type=\"password\" style=\"");
if(password!=null){out.println("background-color:#FF99FF");}
      out.write("\"  name=\"password2\"><br>\n");
      out.write("           <font color=\"red\">");
 if(password==null){out.println(pa);}else{out.println(password);}
      out.write("<br><br></font>\n");
      out.write("           \n");
      out.write("            メールアドレスを入力してください<br>\n");
      out.write("             <input type=\"text\" name=\"mail\" size=\"18\" style=\"");
if(mail!=null){out.println("background-color:#FF99FF");}
      out.write("\" value=\"");
if(flag){out.println(us.getMail());}
      out.write("\">@kagoyume.co.jp<br>\n");
      out.write("            <font color=\"red\">");
 if(mail==null){out.println(ma);}else{out.println(mail);}
      out.write("<br><br></font>\n");
      out.write("              \n");
      out.write("            住所を入れてください（郵便番号からの参照も可能です）<br>\n");
      out.write("            <textarea name=\"addr21\" rows=\"2\" cols=\"30\" style=\"");
if(address!=null){out.println("background-color:#FF99FF");}
      out.write('"');
      out.write('>');
if(flag){out.println(us.getAddress());}
      out.write("</textarea><br>\n");
      out.write("             <font color=\"red\">");
 if(address==null){out.println(ad);}else{out.println(address);}
      out.write("<br><br></font>\n");
      out.write("             〒<input type=\"text\" name=\"zip21\" size=\"2\" maxlength=\"3\"> － <input type=\"text\" name=\"zip22\" size=\"4\" maxlength=\"4\" onKeyUp=\"AjaxZip3.zip2addr('zip21','zip22','addr21','addr21');\"><br><br><br>\n");
      out.write("           \n");
      out.write("            <input type=\"submit\" name=\"check\" value=\"登録\">&emsp;&emsp;\n");
      out.write("             <input type=\"reset\" name=\"reset\" value=\"リセット\">\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("       </center>\n");
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
