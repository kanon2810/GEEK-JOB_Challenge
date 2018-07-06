package jums;

import java.beans.Beans;
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
 * @author hayashi-s
 */
public class UpdateResult extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateResult</title>");            
            out.println("</head>");
            out.println("<body>");
            //パラメーター文字コードの取得
            request.setCharacterEncoding("UTF-8");
               //セッションのセッティング
            HttpSession session = request.getSession();
            
            
            UserDataDTO ud = (UserDataDTO)session.getAttribute("resultData");
 
           ud.setUserID(Integer.parseInt(request.getParameter("id")));
       
                                 
           

            //getで"Bean"を再度呼び出す
            UserDataBeans Bean = (UserDataBeans)session.getAttribute("Bean");
            Bean.setName(request.getParameter("name"));
            Bean.setYear(request.getParameter("year"));
            Bean.setMonth(request.getParameter("month"));
            Bean.setDay(request.getParameter("day"));
            Bean.setType(request.getParameter("type")); 
            Bean.setTell(request.getParameter("tell"));
            Bean.setComment(request.getParameter("comment"));
            //DB型にしてマッピングを行う
            Bean.UD2DTOMapping(ud);
           
            //DBへデータの挿入
            UserDataDAO.getInstance().UPdata(ud);
           
           //uddを格納する　これにてResultDatailのデータを再度jsp側で呼び出せるようになる

           session.setAttribute("UpData",Bean);
            
            //成功したのでセッションの値を削除
            session.invalidate();
            request.getRequestDispatcher("./updateresult.jsp").forward(request, response);
            
            out.println("</body>");
            out.println("</html>");
        }catch(Exception e){
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }finally {
            out.close();
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
