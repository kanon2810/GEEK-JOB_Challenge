/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import gyanbulpackage.*;




/**
 *
 * @author タカ
 */
public class BlackJackServret extends HttpServlet {

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
            out.println("<title>Servlet BlackJackServret</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.print("★★★★★★結果発表だよ～ん★★★★★★");
            out.print("<br>");
            
            Dealer dealer=new Dealer();
            User user=new User();
            
            dealer.setCard(dealer.deal());
            user.setCard(dealer.deal());
            
            while(user.checkSum()){
              
                ArrayList<Integer> A=dealer.hit();
                user.setCard(A);
                
            }
             out.print("あなたの結果は"+user.open()+"<br>");
            
             while(dealer.checkSum()){
              
                ArrayList<Integer> B=dealer.hit();
                dealer.setCard(B);
               
            }
              out.print("ディーラーの結果は"+dealer.open()+"<br>");
            
              //21を超えたらアウト
            if(21<user.open()){
                out.print(" G A M E  O V E R"+"<br>");
               }else{
                //21を超えなかったから21に近い人の勝利！！
                if(21<dealer.open()){
                    //ディラーが21を超えた
                    out.print("参りました"+"<br>");
                }else{
                    if(user.open()>dealer.open()){
                    out.print("YOU WIN　ｷﾀ━━━(ﾟ∀ﾟ).━━━!!!"+"<br>");
                    }else if(user.open()==dealer.open()){
                     out.print("DRAW　ちっ！！"+"<br>");
                    }else{
                    out.print("YOU　LOSE（財布がぁ～）　うあﾞぁあ ･ﾟ･(´Д⊂ヽ･ﾟ･ あﾞぁあぁﾞああぁぁうあﾞぁあﾞぁぁ"+"<br>");
                    }
                }
            }
            out.print("■□■□■□また、遊んでね！！■□■□■□"+"<br>");
            
            
            out.println("</body>");
            out.println("</html>");
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
