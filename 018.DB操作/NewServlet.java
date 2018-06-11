/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

import java.util.Calendar;
/**
 *
 * @author タカ
 */
import java.sql.*;
@WebServlet(urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

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
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
       Connection a=null;
       PreparedStatement b=null;
       ResultSet c=null;
       
       //わかりづらくなるのでＵＲＬ/ユーザー名/パスワードを変数として管理
       String url="jdbc:mysql://localhost:3306/challenge_db";
       String user="タカ";
       String pass="4458259";
      //追加していくレコードの項目
      String lecode="insert into profiles(profilesID,name,tel,age,bithday) values(?,?,?,?,?)";
       
       try{
       Class.forName("com.mysql.jdbc.Driver").newInstance();
       a=DriverManager.getConnection(url,user,pass);
       //データベース元からレコードを追加1して結果を出す
       b=a.prepareStatement(lecode);
       //?の情報を入れていく
       b.setInt(1,99); 
       b.setString(2, "かのん");
      b.setString(3,"0255-644-5820");
      b.setInt(4,25);
      b.setString(5,"1992-06-03");
       //executeUpdetaメソッドを生成しとりあえず変数をおいておく(insert,delete,updateはexeQueryでなくUpdateで！！
      
       b.executeUpdate();//ここで更新完了
       
        //更新されたデータを表示
          b=a.prepareStatement("select * from profiles");
          c=b.executeQuery();
        while(c.next()){
        //取り出したいカラムを纏める
        String B=c.getInt("profilesID")+"|"+c.getString("name")+"|"+c.getString("tel")+"|"+c.getInt("age")+"|"+c.getString("bithday")+"<br>";
        //カラムを取り出す 
          out.println(B);
         
       }
       a.close();
       b.close();
       c.close();
       }catch(SQLException e_sql){
           out.println("エラーを起こしました"+e_sql.toString());
       }catch(Exception e){
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
