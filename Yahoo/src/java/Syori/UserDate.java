/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syori;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;


/**入力させた情報などをそのまま表示するBeans
 *
 * @author タカ
 */
public class UserDate implements Serializable{
   //フィールドの作成
     private int userid;
    private String name;
    private String password;

    private String mail;
    private String address;
   
    
    private int buyid;
    private String itemcode;
    private int type;
 
    
    private String has;
    private String pay;

    
    
    public int getUserID(){
        return userid;
    }
    public void setUserID(String userid){
        //空文字の場合の有無
        if(userid.equals("")){
           this.userid = 0;
        }else{
        //数値が入ったときは数値変換
            this.userid = Integer.parseInt(userid);
        }
    }
   
    public String getName(){
         return name;    
    }
    public void setName(String name){
        if(name.trim().length()==0){
            this.name = "";
        }else{
            this.name = name;
        }
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        if(password.trim().length()==0){
            this.password = "";
         }else{
            this.password = password;
        }        
    }

    public String getMail(){
        return mail;
    }
    public void setMail(String mail){
        if(mail.trim().length()==0){
            this.mail = "";
        }else{
            this.mail = mail;
        }
    }
    
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        if(address.trim().length()==0){
            this.address = "";
        }else{
            this.address = address;
        }
    }
    public String getHas(){
        return has;
    }
    public void setHas(String has){
        this.has = has;
    }
    public String getPay(){
        return pay;
    }
    public void setPay(String pay){
        this.pay = pay;
    }
    
   
    
    public void UD2DTOMapping(UserDataDTO ud){
        ud.setName(this.name);
        ud.setPassword(this.password);
        ud.setMail(this.mail);
        ud.setAddress(this.address);
    }
    
    public void UD3DTOMapping(UserDataDTO DTO){
        DTO.setName(this.name);
        DTO.setPassword(this.password);
    }
    
    public ArrayList<String> chkproperties(){
        ArrayList<String> chkList = new ArrayList<String>();
        if(this.name.equals("")){
            chkList.add("name");
        }
        if(this.password.equals("")){
            chkList.add("password");
        }
        return chkList;
    }    
   
    
    
  
}
