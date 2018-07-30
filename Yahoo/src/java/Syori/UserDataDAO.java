/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syori;
import base.DBmaneger;
import java.sql.*;
import java.util.ArrayList; 
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author タカ
 */
public class UserDataDAO {
    //インスタンスオブジェクトでコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    public UserDataDTO search(UserDataDTO ud) throws SQLException{
       ResultSet result = null;
        Connection con = null;
        PreparedStatement st = null;
       
        try{
            con = DBmaneger.getConnection();
            
            String sql = "SELECT * FROM kagoyume WHERE name=? AND password=? AND deleteFlg=?";
            
            st =  con.prepareStatement(sql);
            st.setString(1, ud.getName());
            st.setString(2, ud.getPassword());
            st.setInt(3, 0); 
            
            result = st.executeQuery();
           
           
            result.next();
              UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(result.getInt("userID"));
            resultUd.setName(result.getString("name")); 
            resultUd.setMail(result.getString("mail")); 
            resultUd.setAddress(result.getString("address"));
            resultUd.setNewDate(result.getTimestamp("newDate"));
            resultUd.setOutdate(result.getTimestamp("outdate"));
     
            System.out.println("search completed");
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
    
    
     public UserDataDTO Returnsearch(UserDataDTO ud) throws SQLException{
       ResultSet result = null;
        Connection con = null;
        PreparedStatement st = null;
       
        try{
            con = DBmaneger.getConnection();
            
            String sql = "SELECT * FROM kagoyume WHERE name=? AND deleteFlg=?";
            
            st =  con.prepareStatement(sql);
            st.setString(1, ud.getName());
            st.setInt(2,1); 
            
            result = st.executeQuery();
           
           
            result.next();
              UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(result.getInt("userID"));
            resultUd.setName(result.getString("name")); 
            resultUd.setMail(result.getString("mail")); 
            resultUd.setAddress(result.getString("address"));
            resultUd.setNewDate(result.getTimestamp("newDate"));
             resultUd.setOutdate(result.getTimestamp("outdate"));
          
            System.out.println("search completed");
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
     
     
     
     
     public String Checksearch(UserDataDTO ud) throws SQLException{
       ResultSet result = null;
        Connection con = null;
        PreparedStatement st = null;
       String messege = "";
        try{
            con = DBmaneger.getConnection();
            
            String sql = "SELECT * FROM kagoyume";
            
            st =  con.prepareStatement(sql);
            
            result = st.executeQuery();
           
           
            while(result.next()){
       
            int flag = result.getInt("deleteFlg");
            if(result.getString("name").equals(ud.getName())&&flag==1){
                messege = "成功";
            }
            
            
            }
            
            System.out.println("search completed");
            return messege;
        }catch(SQLException e){
           System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    
    }
    /*
     * ユーザーIDによる1件のデータの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public UserDataDTO searchByID(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBmaneger.getConnection();
            
            String sql = "SELECT * FROM kagoyume WHERE userID = ?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            
            ResultSet result = st.executeQuery();
            result.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(result.getInt("userID"));
            resultUd.setPassword(result.getString("password"));
            resultUd.setName(result.getString("name")); 
            resultUd.setMail(result.getString("mail")); 
            resultUd.setAddress(result.getString("address"));
            resultUd.setNewDate(result.getTimestamp("newDate"));
            resultUd.setOutdate(result.getTimestamp("outdate"));
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

 

    
      public  String Hikaku(UserDate UD) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        String messege = "";
        ArrayList<UserDataDTO> List = new ArrayList<UserDataDTO>();
        try{
            con = DBmaneger.getConnection();
            
            String sql = "SELECT * FROM kagoyume";
            
            st =  con.prepareStatement(sql);
          
            
            ResultSet result = st.executeQuery();
            while(result.next()){
        
                if(result.getString("name").equals(UD.getName())){
                messege = "そのユーザーネームはすでに使用されております";
               }
            }
            System.out.println("searchByID completed");

            return messege;
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
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void insert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        
        try{
            con = DBmaneger.getConnection();
            st =  con.prepareStatement("INSERT INTO kagoyume(name,password,mail,address,newDate) VALUES(?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setString(2,ud.getPassword());
            st.setString(3, ud.getMail());
            st.setString(4, ud.getAddress());
            st.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
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
    
    
    /*
    カートの追加処理を行う
    */
     public void iteminsert(APIdata API,UserDataDTO ud) throws SQLException{
         Connection con = null;
         PreparedStatement st = null;
  
         UserDataDTO resultUd = new UserDataDTO();
         try{
              con = DBmaneger.getConnection();
           
              String sqlinsert = "insert into cart_t(picture,item,price,itemcode,userid) values(?,?,?,?,?)";
             
              
              st =  con.prepareStatement(sqlinsert);
              st.setString(1, API.getGaz());
              st.setString(2, API.getNames());
              st.setString(3, API.getPrices());
              st.setString(4, API.getCcode());
              st.setInt(5, ud.getUserID());
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
     
     /*
     カートの中身を見ることができます
     */
     public ArrayList<UserDataDTO> Cart(UserDataDTO ud) throws SQLException{
           ResultSet result = null;
        Connection con = null;
        PreparedStatement st = null;
        ArrayList<UserDataDTO> DTO = new ArrayList<UserDataDTO>();
        try{
            con = DBmaneger.getConnection();
            String sql = "SELECT * FROM cart_t where userid=?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            result = st.executeQuery();
           while(result.next()){
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setID(result.getInt("id")); 
            resultUd.setPicture(result.getString("picture")); 
            resultUd.setItem(result.getString("item")); 
            resultUd.setPrice(result.getString("price"));
            resultUd.setItemcode(result.getString("itemcode"));
           DTO.add(resultUd);
           
           }
            System.out.println("search completed");
            return DTO;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
         
     }
     
     /*
     商品かごの削除
     */
     public void Delete(UserDataDTO ud) throws SQLException{
     Connection cone = null;
     PreparedStatement start = null;
   
     
     try{
         cone = DBmaneger.getConnection();
         

         
        start =  cone.prepareStatement("delete from cart_t where userid=? and id=?");
        start.setInt(1,ud.getUserID());
        start.setInt(2,ud.getID());
           
            start.executeUpdate();
            System.out.println("delete completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(cone != null){
                cone.close();
            }
        }

 }
     
     
      public ArrayList<UserDataDTO> Tyumon(UserDataDTO ud, ArrayList<Integer> List) throws SQLException{
         Connection con = null;
         PreparedStatement st = null;
         ResultSet result = null;
         int count = 2;
           ArrayList<UserDataDTO> DTO = new ArrayList<UserDataDTO>();
         try{
              con = DBmaneger.getConnection();
         
               String sql = "SELECT * FROM cart_t where userid=? and id=?";
                
       for (int i = 0; i< List.size()-1; i++) {
              sql += " or id=?";
             }
          
             st =  con.prepareStatement(sql);
             //UserIDは個々のユーザーのものなので常に固定
            //  idは商品ごとなので変動しているのでfor文でまわしてカウントアップを行う
             for (int i = 0; i< List.size(); i++) {
                st.setInt(1,ud.getUserID());
                st.setInt(count++, List.get(i));
             }
               
     
        result = st.executeQuery();
        while(result.next()){
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setID(result.getInt("id"));
            resultUd.setPicture(result.getString("picture")); 
            resultUd.setItem(result.getString("item")); 
            resultUd.setPrice(result.getString("price"));
            DTO.add(resultUd);
        }
          
            System.out.println("select completed");
              return DTO;
         }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
                 
        }
      }
      
      
       public void buyInsert(ArrayList<UserDataDTO> DTO,UserDataDTO ud) throws SQLException{
         Connection con = null;
         PreparedStatement st = null;
       
         UserDataDTO resultUd = new UserDataDTO();
         try{
              con = DBmaneger.getConnection();
           
              String sqlinsert = "insert into buy_t(userID,itemCode,type,buyDate,itempicture,itemprice) values(?,?,?,?,?,?)";
              String sqlput = "";
              
              con.setAutoCommit(false);
              
              st =  con.prepareStatement(sqlinsert);
             for(int i=0;i<DTO.size();i++){
              st.setInt(1, ud.getUserID());
              st.setString(2, DTO.get(i).getItem());
              st.setInt(3, ud.getType()); 
              st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
              st.setString(5, DTO.get(i).getPicture());
              st.setString(6, DTO.get(i).getPrice());
              st.addBatch();
             }
           
             st.executeBatch();
             
             con.commit();

      
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
       
       public void cartDelete(ArrayList<UserDataDTO> DTO,UserDataDTO ud) throws SQLException{
     Connection con = null;
     PreparedStatement st = null;
   
     
     try{
         con = DBmaneger.getConnection();
         
             
          
              con.setAutoCommit(false);
              
              st =  con.prepareStatement("delete from cart_t where userid=? and id=?");
             for(int i=0;i<DTO.size();i++){
                  st.setInt(1,ud.getUserID());
                 st.setInt(2,DTO.get(i).getID());
              st.addBatch();
             }
             st.executeBatch();
             
             con.commit();
    
            st.executeUpdate();
            System.out.println("delete completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con!= null){
                con.close();
            }
        }

 }
       
        public void UPdata(UserDataDTO DTO) throws SQLException{
Connection cone=null;
PreparedStatement start = null;

    try{
             cone = DBmaneger.getConnection();
            start =  cone.prepareStatement("update kagoyume set total=total+? where userID=? ");
            
            start.setInt(1, DTO.getTotal());
            start.setInt(2,DTO.getUserID());
           
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

/*
        これまで購入したデータを閲覧することができる
        */
       
        public ArrayList<UserDataDTO> Buyselect(UserDataDTO DTO)  throws SQLException{
            Connection cone = null;
            PreparedStatement  start = null;
            ResultSet result = null;
            ArrayList<UserDataDTO> List = new ArrayList<UserDataDTO>();
            try{
                cone =DBmaneger.getConnection();
                start = cone.prepareStatement("select * from buy_t where userID=?");
                
                start.setInt(1,DTO.getUserID());
                
                 result = start.executeQuery();
           while(result.next()){
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setItempicture(result.getString("itempicture"));
            resultUd.setItemCode(result.getString("itemCode")); 
            resultUd.setType(result.getInt("type")); 
            resultUd.setBuyDate(result.getTimestamp("buyDate"));
             resultUd.setItemprice(result.getString("itemprice"));
            List.add(resultUd);
            }
           
           
            } catch (SQLException e) {
          System.out.println(e.getMessage());
            throw new SQLException(e);
        }
            return List;
        }     
        
        
    public void DATAUPdata(UserDataDTO DTO) throws SQLException{
Connection cone=null;
PreparedStatement start = null;

    try{
             cone = DBmaneger.getConnection();
            start =  cone.prepareStatement("update kagoyume set name=?,password=?,mail=?,address=? where userID=?");
           
            start.setString(1,DTO.getName());
            start.setString(2,DTO.getPassword());
            start.setString(3,DTO.getMail());
            start.setString(4,DTO.getAddress());
            start.setInt(5,DTO.getUserID());
           
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

    
    
      public void Flagupdata(UserDataDTO DTO) throws SQLException{
Connection cone=null;
PreparedStatement start = null;

    try{
             cone = DBmaneger.getConnection();
            start =  cone.prepareStatement("update kagoyume set deleteFlg=?,outdate=? where userID=?");
           
            start.setInt(1,DTO.getDeleteFlag());
            start.setTimestamp(2,new Timestamp(System.currentTimeMillis()));
            start.setInt(3,DTO.getUserID());
         
          
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
      
      
      
        public void Cansera(UserDataDTO DTO) throws SQLException{
Connection cone=null;
PreparedStatement start = null;

    try{
             cone = DBmaneger.getConnection();
            start =  cone.prepareStatement("update kagoyume set deleteFlg=? where name=? and deleteFlg=?");
           
            start.setInt(1,DTO.getDeletecansel());
           start.setString(2,DTO.getName());
           start.setInt(3, 1);
          
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
      
      
      
      /*
      /一定時間を過ぎればTimerTaskにより破棄される（つまりユーザーデータがフラグがたつのではなく本当に消える）
      */
  public void Drop(UserDataDTO ud) throws SQLException{
     Connection cone = null;
     PreparedStatement start = null;
   
     
     try{
         cone = DBmaneger.getConnection();
         

         
        start =  cone.prepareStatement("update kagoyume set deleteFlg=? where name=? and deleteFlg=?");
           start.setInt(1,2);
           start.setString(2,ud.getName());
           start.setInt(3,1);
      
          start.executeUpdate();
            System.out.println("drop completed");
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
    

     
