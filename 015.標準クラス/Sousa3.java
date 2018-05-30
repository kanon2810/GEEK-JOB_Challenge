/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadai;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author タカ
 */
public class Sousa3 {
    public static void main(String[] args){
       
        
        try{
            //開始します
              Date a=new Date();
              
       SimpleDateFormat d=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String c=d.format(a);
        
        //文字の置換処理を行います
      
       
        String word="こらあげぇぇんんんんんんんんんんんんんんんんんんん";
        
        word=word.replace("らあ", "のは");
        word=word.replace("ん","ー");
        String l=word;
        
        
        //終了処理を行います
        Date N=new Date();       
        SimpleDateFormat w=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String p=w.format(N);
                
        
        File fp =new File("log.txt");
        FileWriter fw=new FileWriter(fp);
       fw.write(c+"　　　処理開始"+"\r\n");
       for(int i=1;i<10;i++){
       fw.write(word+"　　　文字の置換処理を繰り返し行いました"+"\r\n");
       }
       fw.write(p+"　　　処理終了"+"\r\n");
       
       fw.close();
       
       }catch(IOException e){
           e.printStackTrace();
       }
        
        
        
    }
}
