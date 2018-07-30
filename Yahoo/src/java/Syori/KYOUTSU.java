/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syori;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpSession;

/**
 *
 * @author タカ
 */

public class KYOUTSU {

    public static KYOUTSU getInstance(){
        return new KYOUTSU();
    }
    
    
  
    //トップへのリンクを返却
    public final String home(){
        return "<a href=\""+"Top.jsp"+"\"><img src=\"folder/kagoyume.png\" width=\"420\" height=\"60\"></a>";
    }
    //ログイン画面へ移るメソッド
    public final String login(UserDataDTO DTO){
        String log = "";
        //セッションがあるかないかで分岐
        if(DTO == null){
        log = "<a href=\""+"LOGIN"+"\">ログイン</a>&emsp;&emsp;<a href=\""+"Registration"+"\">ご新規の方</a>";
        }else{
        log = "ようこそ"+"<a href=\""+"Mydata?sid="+DTO.getUserID()+"\">"+DTO.getName()+"</a>"+"さん"+"&emsp;&emsp;<a href=\"Logout\">ログアウト</a>";
        }               
        return log;
    }
   
  /*
    APIの週品検索のメソッド
    */
  public static  ArrayList<APIdata> getResult(APIdata data){
      ArrayList<APIdata> array = new ArrayList<APIdata>();
      String result = "";
      JsonNode root = null;
      int i = 0;
       try{         
    //文字化けで検索されないようＵＲＬエンコードを行う
           String EnURL = URLEncoder.encode(data.getQuery(), "UTF-8");
           //query(検索ワード）は文字連結を行いhits(検索件数)はJavaBeansで10件検索と制御してあとは入ってきた数だけ検索される
String url = "https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch?appid=dj00aiZpPVdtNDdjbG13eHoyWSZzPWNvbnN1bWVyc2VjcmV0Jng9MTA-&query=";
     
        url = url + EnURL + "&hits=" + data.getHits() ;
    
       URL encodingURL = new URL(url);
HttpURLConnection con = (HttpURLConnection) encodingURL.openConnection();
con.connect();
BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
String tmp = "";

while ((tmp = in.readLine()) != null) {
result += tmp;
 
}
ObjectMapper mapper = new ObjectMapper();
 root = mapper.readTree(result);
in.close();
con.disconnect();
//ループ処理で件数分だけまわす
while(i<=50){
     APIdata api = new APIdata();
 api.setImg(root.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Image").get("Small").textValue());
 api.setSina(root.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Name").textValue());
 api.setPrice(root.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Price").get("_value").textValue());
 api.setMprice(root.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("PriceLabel").get("FixedPrice").textValue());
  api.setITEMcode(root.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Code").textValue());
   array.add(api);
   i++;
}



}catch(Exception e){
e.printStackTrace();
}
 return array;
}
  
  /*
  商品詳細のメソッド
  */
  
  public static APIdata Itemcode(APIdata data,String Code){
      
      String result = "";
      JsonNode root = null;
     
       try{         
           //商品詳細のURL+商品検索画面から持ってきたアイテムコードを文字連結させて入っていく
String url = "https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemLookup?appid=dj00aiZpPVdtNDdjbG13eHoyWSZzPWNvbnN1bWVyc2VjcmV0Jng9MTA-&image_size=600&responsegroup=large&itemcode=";
         url += Code;
    
       URL U = new URL(url);
HttpURLConnection con = (HttpURLConnection) U.openConnection();
con.connect();
BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
String tmp = "";

while ((tmp = in.readLine()) != null) {
result += tmp;
}
ObjectMapper mapper = new ObjectMapper();
 root = mapper.readTree(result);
in.close();
con.disconnect();

//表示したい用件をJsonNodeで呼び出していく
   data.setNames(root.get("ResultSet").get("0").get("Result").get("0").get("Name").textValue());
 data.setGaz(root.get("ResultSet").get("0").get("Result").get("0").get("ExImage").get("Url").textValue());
 data.setPrices(root.get("ResultSet").get("0").get("Result").get("0").get("Price").get("_value").textValue());
  data.setMprices(root.get("ResultSet").get("0").get("Result").get("0").get("PriceLabel").get("FixedPrice").textValue());
  data.setCaption(root.get("ResultSet").get("0").get("Result").get("0").get("Caption").textValue());
   data.setDesc(root.get("ResultSet").get("0").get("Result").get("0").get("SpAdditional").textValue());
    data.setSpa(root.get("ResultSet").get("0").get("Result").get("0").get("Description").textValue());
    data.setSouryo(root.get("ResultSet").get("0").get("Result").get("0").get("Shipping").get("Name").textValue());
    data.setNyuka(root.get("ResultSet").get("0").get("Result").get("0").get("Store").get("InventoryMessage").textValue());
    data.setCcode(root.get("ResultSet").get("0").get("Result").get("0").get("Code").textValue());
     }catch(Exception e){                                                               
e.printStackTrace();
}
 return data;
}
 /*
 データベースに入れる際の表示をわかりやすくするため入ってきたものの
  数値に応じてswitch文で表示を分岐させる
  */
 public  String Paturn(int CASE){
       switch(CASE){
            case 0:
                return "1.ゆうメール";
            case 1:
                return "2.レターパック";
            case 2:
                return "3.定形外郵便";
            case 3: 
                return "4.クロネコヤマト";
            case 4:
                return "5.ゆうパック";
            case 5:
                return "6.クリックポスト";
            case 6:
                return "7.ゆうパケット";
        }
       
        return "";
     
 }

}

