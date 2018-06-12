
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author タカ
 */
public class BASE6 {
     public static void main(String[] args){
    
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
  
       //SQL文でprofilesIDの1でレコードを表示させる
       b=a.prepareStatement("select * from profiles where name like ?");
       //1番目の？の1番を抜き出す
       //今回は文字列なのでＳｔｒｉｎｇ
       b.setString(1,"%茂%");
         
          c=b.executeQuery();
        while(c.next()){
        //取り出したいカラムを纏める
        String B=c.getInt("profilesID")+"|"+c.getString("name")+"|"+c.getString("tel")+"|"+c.getInt("age")+"|"+c.getString("bithday")+"<br>";
        //カラムを取り出す 
          System.out.println(B);
         
       }
       a.close();
       b.close();
       c.close();
       }//例外が発生した場合の処理
       catch(SQLException e_sql){
           System.out.println("エラーを起こしました"+e_sql.toString());
       }catch(Exception e){
       }
     }
}
