/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syori;

/**
 *
 * @author タカ
 */
public class APIdata {
    
    //検索条件を取りまとめるBeans
    private String query;
    private int hits;
    //商品の詳細情報にまつわるフィールド
    private String code;
    private String gaz;
    private String prices;
    private String mprices;
    private String names;
    private String caption;
    private String desc;
    private String spa;
    private String souryo;
    private String nyuka;
    private String ccode;
    
       //このフィールドはAPIからのものをまとめるフィールド
    private String sina;
    private String price;
    private String img;
    private String mprice;
    private String itemcode;
     
    //各データのset,getメソッドの作成
    public String getQuery(){
        return query;
    }
    public void setQuery(String query){
        this.query = query;
    }
    public int getHits(){
        return hits;
    }
    public void setHits(String hits){
        if(hits.equals("")){
            this.hits = 10; 
        }else{
            this.hits = Integer.parseInt(hits);
        }
        
    }
    
    
    public String getSina(){
        return sina;
    }
    public void setSina(String sina){
        this.sina = sina;
    }
     public String getPrice(){
        return price;
    }
    public void setPrice(String price){
        this.price = price;
    }
    public String getImg(){
        return img;
    }
    public void setImg(String img){
        this.img = img;
    }
    public String getMprice(){
        return mprice;
    }
    public void setMprice(String mprice){
        this.mprice = mprice;
    }
    public String getITEMcode(){
        return itemcode;
    }
    public void setITEMcode(String itemcode){
        this.itemcode = itemcode;
    }
    
    public String getCode(){
        return code;
    }
    public void setCode(String code){
        this.code = code;
    }
     public String getPrices(){
        return prices;
    }
    public void setPrices(String prices){
        this.prices = prices;
    }
    public String getGaz(){
        return gaz;
    }
    public void setGaz(String gaz){
        this.gaz = gaz;
    }
   public String getMprices(){
        return mprices;
    }
    public void setMprices(String mprices){
        this.mprices = mprices;
    }
    public String getNames(){
        return names;
    }
    public void setNames(String names){
        this.names = names;
    }
    public String getCaption(){
        return caption;
    }
    public void setCaption(String caption){
        this.caption = caption;
    }
    public String getDesc(){
        return desc;
    }
    public void setDesc(String desc){
        this.desc = desc;
    }
    public String getSpa(){
        return spa;
    }
    public void setSpa(String spa){
        this.spa = spa;
    }
    public String getSouryo(){
        return souryo;
    }
    public void setSouryo(String souryo){
        this.souryo = souryo;
    }
    public String getNyuka(){
        return nyuka;
    }
    public void setNyuka(String nyuka){
        this.nyuka = nyuka;
    }
     public String getCcode(){
        return ccode;
    }
    public void setCcode(String ccode){
        this.ccode = ccode;
    }
    
    
    
    public void Mapping(UserDataDTO ud){
        ud.setPicture(this.gaz);
        ud.setItem(this.names);
        ud.setPrice(this.prices);
        ud.setItemcode(this.ccode);
    }
}
