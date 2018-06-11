/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
/**
 *
 * @author タカ
 */
public class BASE {
 
    
    
    public static void main(String[] args){
  
        Connection db_com=null;
        PreparedStatement db_st=null;
        ResultSet db_data=null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();//Mysql用のJDBCドライバのインスタンス生成
            
            db_com=DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","タカ","4458259");//DriverManagerのgetConnentionメソッドでＤＢの接続をする
            db_st=db_com.prepareStatement("select * from user where age=?");//接続したら、SQL文を実行するためPreparedStatementを取得
            
            db_st.setInt(1,30); //PreparedStatimentに対し「？」部分に適用する数字を入れる
            
            db_data=db_st.executeQuery(); //PreparedStatementのexesuteQuarryメソッドの実行
            
            while(db_data.next()){
                System.out.println("DBから引っ張ってきた名前は"+db_data.getString("name")); //nextメソッドでデータの有無を確認してwhile文でデータがある限り取得する
            }
            db_data.close();
            db_st.close();
            db_com.close();
        }catch(SQLException e_sql){
            System.out.print("エラーが発生しました;"+e_sql.toString());
        }catch(Exception e){
        }
    }
}