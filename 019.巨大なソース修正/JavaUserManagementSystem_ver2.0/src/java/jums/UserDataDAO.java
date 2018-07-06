package jums;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する
 * DB接続系はDBManagerクラスに一任
 * 基本的にはやりたい1種類の動作に対して1メソッド
 * @author hayashi-s
 */
public class UserDataDAO {
    
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void insert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO user_t(name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * データの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public ArrayList<UserDataDTO> search(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
             
         
            String sql = "SELECT * FROM user_t";
            st =  con.prepareStatement(sql);
            boolean flag = false;
            //名前、誕生日、種別それぞれフラグを立ててbooleanで制御する
            boolean nameflg = false;
            boolean birthdayflg = false;
            boolean typeflg = false;
             
             if (!ud.getName().equals("")) {
                sql += " WHERE name like ?";
                flag=true;
                nameflg = true;
            }
            if (ud.getBirthday()!=null) {
                if(!flag){
                    sql += " WHERE birthday like ?";
                    flag=true;
                }else{
                    sql += " AND birthday like ?";
                 }
                birthdayflg = true;
           }
            
            if (ud.getType()!=0) {
             if(!flag){
                  sql += " WHERE type like ?";
              }else{
          
                    sql += " AND type like ?";
               }
             typeflg = true;
           }
            
            
            //名前に何かが入っている場合はgetName()にWHEREから始まりtrueにされsetParameterの
            //分岐を行う
            //これを通ったか通ってないかでカウントアップする
            //よって入力してない項目があればほかの入力してある項目のみでサーチ
            //まったくの未入力であればすべてfalseとなりselectsqlを直接読み込み全件検索が可能
            st =  con.prepareStatement(sql);
            int count = 1;
    
            if (nameflg) {
                st.setString(count, "%"+ud.getName()+"%");
                count++;
            }
            if (birthdayflg) {
                st.setString(count, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
                count++;
            }
            if (typeflg) {
             st.setInt(count, ud.getType());
            }
               
           
            ResultSet rs = st.executeQuery();
                     
           
            
         
            ArrayList<UserDataDTO> collection = new ArrayList<UserDataDTO>();
            while (rs.next ()){
          //resultUdはループに入るたびにNewを繰り返してadd,add…される
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setBirthday(rs.getDate(3));
            resultUd.setTell(rs.getString(4));
            resultUd.setType(rs.getInt(5));
            resultUd.setComment(rs.getString(6));
            resultUd.setNewDate(rs.getTimestamp(7));
            //addされたものはSearchResultへ
            collection.add(resultUd);
                
            }
            System.out.println("search completed");
             //returnにaddしたcollectionを返す
             return collection;  
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * ユーザーIDによる1件のデータの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public UserDataDTO searchByID(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM user_t WHERE userID = ?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            
            ResultSet rs = st.executeQuery();
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2)); 
            resultUd.setBirthday(rs.getDate(3)); 
            resultUd.setTell(rs.getString(4));
            resultUd.setType(rs.getInt(5));
            resultUd.setComment(rs.getString(6));
            resultUd.setNewDate(rs.getTimestamp(7));
            
            System.out.println("searchByID completed");

            return resultUd;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * ユーザーデータの更新を行う
     
     */
 public void UPdata(UserDataDTO ud) throws SQLException{
Connection cone=null;
PreparedStatement start = null;

    try{
             cone = DBManager.getConnection();
            start =  cone.prepareStatement("update user_t set name=?,birthday=?,tell=?,type=?,comment=?,newDate=? where userID=?");
            start.setString(1, ud.getName());
            start.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            start.setString(3, ud.getTell());
            start.setInt(4, ud.getType());
            start.setString(5, ud.getComment());
            start.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            start.setInt(7,ud.getUserID());
           
            start.executeUpdate();
            System.out.println("update completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(cone != null){
                cone.close();
            }
        }

 }
 
 public void Delete(UserDataDTO ud) throws SQLException{
     Connection cone = null;
     PreparedStatement start = null;
     try{
         cone = DBManager.getConnection();
        start =  cone.prepareStatement("delete from user_t where userID=?");
        start.setInt(1,ud.getUserID());
           
            start.executeUpdate();
            System.out.println("update completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(cone != null){
                cone.close();
            }
        }

 }

}