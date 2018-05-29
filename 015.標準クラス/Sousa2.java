/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadai;

import java.io.*;

/**
 *
 * @author タカ
 */
public class Sousa2 {
    public static void main(String[] args){
       try{
        File fp =new File("text.txt");
        FileReader fw=new FileReader(fp);
     BufferedReader br=new BufferedReader(fw);
     System.out.print(br.readLine());
       fw.close();
       
       }catch(IOException e){
           e.printStackTrace();
       }
        
    }
}
