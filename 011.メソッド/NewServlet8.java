/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messodo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author タカ
 */
public class NewServlet7 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    String[] profile(String name){
        String[] data1={"99999999","9999年9月9日","ABCD"};
        
       
        String[] data2={"1255859","0589年3月4日",null};
        
        String[] data3={"125hh59","2222年7月2日","ndghdg"};
        
        
        
         if(data1[0]==name){
            return data1;
        }else if(data2[0]==name){
            return data2;
        }else if(data3[0]==name){
            return data3;
        }
        
         
        return null;
       
    }
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet7</title>");            
            out.println("</head>");
            out.println("<body>");
           
            
                            
                  
          
          for(int i=0;i<profile("99999999").length;i++){
            out.print(profile("99999999")[i]+("<br>"));
            
        
            
          }for(int i=0;i<profile("1255859").length;i++){
              out.print(profile("1255859")[i]+("<br>"));
         if(null==null){
          continue;
          }
          
          
          }
          for(int i=0;i<profile("125hh59").length;i++){
          out.print(profile("125hh59")[i]+("<br>"));
          }
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
