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
public class Buyconfirm extends HttpServlet {

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
            out.println("<title>Servlet Buyconfirm</title>");            
            out.println("</head>");
            out.println("<body>");
            //セッションスタート
             HttpSession session = request.getSession();
             //UserDataDTOの取得
            UserDataDTO UD = (UserDataDTO)session.getAttribute("DATA");
            ArrayList<Integer> Array = new ArrayList<Integer>();
           //エンコード方式の指定
            response.setContentType("text/html; charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
      
             //チェックがひとつもなければnullということになるのでnullならば元の画面に返す
        if(request.getParameter("box") == null){
            request.setAttribute("rbox","レジに進む場合はBOXチェックを行ってください");
            request.getRequestDispatcher("Cart").forward(request, response);
            return;
        }
            
        
        //name1パラメータの取得
         request.getParameter("name1");
        //vehicleパラメータの取得
        String box[ ] = request.getParameterValues("box");
         //チェックボックスに入っているものを配列で読み出して取り出す
        for (int i = 0; i < box.length; i++ ) {
      String param =box[i];
           Array.add(Integer.parseInt(param));  
       }
       
          
      //データベースの挿入
      ArrayList<UserDataDTO> DTO =  UserDataDAO .getInstance().Tyumon(UD,Array);
      session.setAttribute("buydata",DTO);
                
      request.getRequestDispatcher("./Buyconfirm.jsp").forward(request,response);
        
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(Buyconfirm.class.getName()).log(Level.SEVERE, null, ex);
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
