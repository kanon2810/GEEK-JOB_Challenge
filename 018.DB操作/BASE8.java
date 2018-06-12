
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
public class BASE8 {
     public static void main(String[] args){
    
    Connection a=null;
       PreparedStatement b=null;
       ResultSet c=null;
       
       //わかりづらくなるのでＵＲＬ/ユーザー名/パスワードを変数として管理
       String url="jdbc:mysql://localhost:3306/challenge_db";
       String user="タカ";
       String pass="4458259";
      //追加していくレコードの項目
 String lecode="update profiles set name=?,tel=?,age=?,bithday=? where profilesID=?";
       
       try{
       Class.forName("com.mysql.jdbc.Driver").newInstance();
       a=DriverManager.getConnection(url,user,pass);
       //データベース元からレコードを追加1して結果を出す
       b=a.prepareStatement(lecode);
       //?の情報を入れていく
       b.setString(1,"堀田華愛"); 
       b.setString(2,"025-569-1569");
       b.setInt(3,20);
       b.setString(4,"1990-12-31");
      b.setInt(5,4);
     
       //executeUpdetaメソッドを生成しとりあえず変数をおいておく(insert,delete,updateはexeQueryでなくUpdateで！！
      
       b.executeUpdate();//ここで更新完了
       
        //更新されたデータを表示
          b=a.prepareStatement("select * from profiles");
       
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
