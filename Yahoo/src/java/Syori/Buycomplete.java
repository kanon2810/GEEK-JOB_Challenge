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
public class Buycomplete extends HttpServlet {

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
            out.println("<title>Servlet Buycomplete</title>");            
            out.println("</head>");
            out.println("<body>");
            request.setCharacterEncoding("UTF-8");
            //セッションスタート
            HttpSession session = request.getSession();
            //合計金額を取得して数値型に変換を行う
           int total = Integer.parseInt( request.getParameter("total"));
            UserDate Data = new UserDate();
            int i = Integer.parseInt(request.getParameter("shi"));
            //type（発想方法）の得た数に応じて分岐して送料の足し算
            switch(i){
            case 0:
               total = total + 250;
               break;
            case 1:
               total = total + 390;
               break;
            case 2:
               total = total + 150;
               break;
            case 3:
               total = total + 780;
               break;
            case 4:
             total = total + 690;
               break;
             case 5:
               total = total + 164;
               break;
             case 6:
               total = total + 280;
        }
        
            
           //商品注文確認画面を配列で得たUserDataDTOの取得
            ArrayList<UserDataDTO> DTO = (ArrayList<UserDataDTO>)session.getAttribute("buydata");
            UserDataDTO UD = (UserDataDTO)session.getAttribute("DATA");
            //type,totalをJavaBeansに格納
            UD.setType(Integer.parseInt(request.getParameter("shi")));
            UD.setTotal(total);
           
            //データベースの購入テーブルに追加して、カートテーブルで削除して、ユーザー情報テーブルで合計金額の更新を行う
            UserDataDAO .getInstance().buyInsert(DTO,UD);
            UserDataDAO.getInstance().cartDelete(DTO, UD);
            UserDataDAO.getInstance().UPdata(UD);

            session.setAttribute("udate",UD);
       
            request.getRequestDispatcher("./Buycomplete.jsp").forward(request,response);
            
             
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(Buycomplete.class.getName()).log(Level.SEVERE, null, ex);
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
