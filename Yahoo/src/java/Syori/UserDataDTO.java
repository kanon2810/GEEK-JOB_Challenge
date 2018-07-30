/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syori;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
/**主にデータベースに値を格納していくBeans
 *
 * @author タカ
 */
public class UserDataDTO implements Serializable{
    private String messege;
    
   //フィールドをカプセル化していく
    private int userid;
    private String name;
    private String password;
    private String mail;
    private String address;
    private int total;
    private Timestamp newdate;
    private Timestamp outdate;
    private int deleteflag;
    private int deletecansel;

    
    private int buyid;
    private String itemcode;
    private int type;
    private Timestamp buydate;
   private String itemprice;
   private String itempicture;
    
    private String picture;
    private String item;
    private String price;
    private String itmcode;
    private int id;
    //それぞれのメソッドを入れていく
    
    
    public String getMessege(){
        return messege; 
    }
    public void setMessege(String messege){
        this.messege = messege;
    }
    public int getUserID(){
        return userid;
    }
    public void setUserID(int userid){
        this.userid = userid;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getMail(){
        return mail;
    }
    public void setMail(String mail){
        this.mail = mail;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public int getTotal(){
        return total;
    }
    public void setTotal(int total){
        this.total = total;
    }
    public Timestamp getNewDate(){
        return newdate;
    }
    public void setNewDate(Timestamp newdate){
        this.newdate= newdate;
    }
    public Timestamp getOutdate(){
        return outdate;
    }
    public void setOutdate(Timestamp outdate){
        this.outdate = outdate;
    }
    public int getDeleteFlag(){
        return deleteflag;
    }
    public void setDeleteFlag(int deleteflag){
        this.deleteflag = deleteflag;
    }
    public int getDeletecansel(){
        return deletecansel;
    }
    public void setDeletecansel(int deletecansel){
        this.deletecansel = deletecansel;
    }
    
    
    
    public int getBuyID(){
        return buyid;
    }
    public void setBuyID(int buyid){
        this.buyid = buyid;
    }
    public String getItemCode(){
        return itemcode;
    }
    public void setItemCode(String itemcode){
        this.itemcode = itemcode;
    }
    public int getType(){
        return type;
    }
    public void setType(int type){
        this.type = type;
    }
    public Timestamp getBuyDate(){
        return buydate;
    }
    public void setBuyDate(Timestamp buydate){
        this.buydate = buydate;
    }
     public String getItemprice(){
        return itemprice;
    }
    public void setItemprice(String itemprice){
        this.itemprice = itemprice;
    }
     public String getItempicture(){
        return itempicture;
    }
    public void setItempicture(String itempicture){
        this.itempicture = itempicture;
    }
    
    
    public String getPicture(){
        return picture;
    }
    public void setPicture(String picture){
        this.picture = picture;
    }
    public String getItem(){
        return item;
    }
    public void setItem(String item){
        this.item = item;
    }
    public String getPrice(){
        return price;
    }
    public void setPrice(String price){
        this.price = price;
    }
    public String getItemcode(){
        return itemcode;  
    }
    public void setItemcode(String itemcode){
        this.itemcode = itemcode;
    }
    public int getID(){
        return id; 
    }
    public void setID(int id){
        this.id = id;
    }
    
     /*　設定時刻のミリ秒単位部分をSimpleDateFormatで切り落とすメソッド
    
    */
   public String Format(Timestamp timestamp){
       timestamp = null;
      SimpleDateFormat  format = new SimpleDateFormat("yyyy年MM月dd日(E) HH時mm分");
       
        timestamp = newdate;
        
        return format.format(timestamp );
       
   }
   
        
}
