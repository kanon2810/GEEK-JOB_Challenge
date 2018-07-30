/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syori;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author タカ
 */
public class Myupdataresult extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Myupdataresult</title>");            
            out.println("</head>");
            out.println("<body>");
            HttpSession session = request.getSession();
               request.setCharacterEncoding("UTF-8");
            UserDataDTO UD = (UserDataDTO)session.getAttribute("DATA");
        
             UD.setName(request.getParameter("name"));
            UD.setPassword(request.getParameter("password"));
          
            UD.setMail(request.getParameter("mail"));
            UD.setAddress(request.getParameter("addr21"));
          
 
          
            
           
            if(!"".equals(UD.getName()) && !UD.getMail().matches(".*[^ -~｡-ﾟ].*") && !UD.getMail().matches(".*[.@].*") && !"".equals(UD.getPassword()) && !"".equals(UD.getMail()) && !"".equals(UD.getAddress()) && UD.getPassword().length()>=7){
                   UserDataDAO.getInstance(). DATAUPdata(UD);
                   session.setAttribute("RDATA",UD);
                   request.getRequestDispatcher("./Myupdataresult.jsp").forward(request, response);
            }else{
           if("".equals(UD.getName())){
               request.setAttribute("rname","名前が未入力です");
             }
           if("".equals(UD.getPassword())){
               request.setAttribute("rpassword","パスワードが未入力です");
             }else if(UD.getPassword().length()<7){
                 request.setAttribute("rpassword","パスワードは最低７字となります");
             }
           if("".equals(UD.getMail())){
                  request.setAttribute("rmail","メールアドレスが未入力です");
           }else if(UD.getMail().matches(".*[^ -~｡-ﾟ].*")){
                 request.setAttribute("rmail","全角が含まれています");
             }else if(UD.getMail().matches(".*[.@].*")){
                 request.setAttribute("rmail","メールアドレスとしてのフォーマットが成立しておりません！！");
             }
           
           if("".equals(UD.getAddress())){
                  request.setAttribute("raddress","住所が未入力です");
           }
                     request.getRequestDispatcher("./Myupdata.jsp").forward(request, response);  
            }
            
       
            
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(Myupdataresult.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Myupdataresult.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Myupdataresult.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
