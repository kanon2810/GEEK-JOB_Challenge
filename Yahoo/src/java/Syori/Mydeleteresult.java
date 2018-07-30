/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syori;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
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
public class Mydeleteresult extends HttpServlet {

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
            out.println("<title>Servlet Mydeleteresult</title>");            
            out.println("</head>");
            out.println("<body>");
            //セッションスタート
             HttpSession session = request.getSession();
             //UserDataDTOの取得
            UserDataDTO DTO = (UserDataDTO)session.getAttribute("DATA");
            //デリートフラグ（0）を受け取ってそれを数値化してJavaBeansのsetに格納
           DTO.setDeleteFlag(Integer.parseInt(request.getParameter("flagnum")));
           //削除フラグメソッドに挿入
           //1度退会するとデータベースの退会日時のタイムスタンプが書き込まれる
          UserDataDAO.getInstance().Flagupdata(DTO);
          //タイムスタンプが書き込まれることによってOut.dataの値がnullでなくなる
          //よって2度目は0でも1でも制御できない2に移されアカウントは完全凍結する
                  if(DTO.getOutdate()!=null){
                UserDataDAO.getInstance().Drop(DTO);
                session.invalidate();
                 request.getRequestDispatcher("./Mydeleteresult2.jsp").forward(request, response);
           }
                
           
           //一度退会した場合は削除フラグが1となると同時にタイマータスクが働く
           //10日に設定してあるので10日以内にアカウントを取り戻す気がない場合はこれも強制的に2にされる
	   TimerTask timelimit = new TimerTask(){
                @Override
                public void run() {
                    try {
                        UserDataDAO.getInstance().Drop(DTO);
                       
                    } catch (SQLException ex) {
                        Logger.getLogger(Mydeleteresult.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
          Timer timer = new Timer();
           timer.schedule(timelimit, TimeUnit.SECONDS.toMillis(50)); 
          // timer.schedule(timelimit,TimeUnit.DAYS.toMillis(1));
           //セッションの破棄
           session.invalidate();
           
           request.getRequestDispatcher("./Mydeleteresult.jsp").forward(request, response);
           
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(Mydeleteresult.class.getName()).log(Level.SEVERE, null, ex);
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
