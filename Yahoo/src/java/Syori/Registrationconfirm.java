/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syori;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class Registrationconfirm extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registrationconfirm</title>");            
            out.println("</head>");
            out.println("<body>");
            HttpSession session = request.getSession();
               request.setCharacterEncoding("UTF-8");
               
              
        
            UserDate ud = new UserDate();
              ud.setName(request.getParameter("name"));
            ud.setPassword(request.getParameter("password"));
          
            ud.setMail(request.getParameter("mail"));
            ud.setAddress(request.getParameter("addr21"));
           
           session.setAttribute("ud",ud);
            String DU =  UserDataDAO.getInstance().Hikaku(ud); 
            
            if(!"".equals(DU)){
                 request.setAttribute("me",DU);
                 request.getRequestDispatcher("./Registration.jsp").forward(request, response);
            }
          
           UserDate us = (UserDate)session.getAttribute("ud");
            if(!"".equals(us.getName()) && !us.getMail().matches(".*[^ -~｡-ﾟ].*") && !us.getMail().matches(".*[.@].*") && !"".equals(us.getPassword()) && !"".equals(us.getMail()) && !"".equals(us.getAddress()) && request.getParameter("password2").equals(us.getPassword()) && us.getPassword().length()>=7){
                request.getRequestDispatcher("./Registrationconfirm.jsp").forward(request, response);
            }else{
           if("".equals(us.getName())){
               request.setAttribute("rname","名前が未入力です");
             }
           if("".equals(us.getPassword())||request.getParameter("password2").equals("")){
               request.setAttribute("rpassword","パスワードが未入力です");
             }else if(!request.getParameter("password2").equals(us.getPassword())){
                 request.setAttribute("rpassword","パスワードが合ってません");
             }else if(us.getPassword().length()<7){
                 request.setAttribute("rpassword","パスワードは最低７字となります");
             }
           if("".equals(us.getMail())){
                  request.setAttribute("rmail","メールアドレスが未入力です");
           }else if(us.getMail().matches(".*[^ -~｡-ﾟ].*")){
                 request.setAttribute("rmail","全角が含まれています");
             }else if(us.getMail().matches(".*[.@].*")){
                 request.setAttribute("rmail","メールアドレスとしてのフォーマットが成立しておりません！！");
             }
           
           if("".equals(us.getAddress())){
                  request.setAttribute("raddress","住所が未入力です");
           }
         
            request.getRequestDispatcher("./Registration.jsp").forward(request, response);
         
            }
            
           
            
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
           
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
