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
public class Sousa {
    public static void main(String[] args){
       try{
        File fp =new File("text.txt");
        FileWriter fw=new FileWriter(fp);
       fw.write("文字を書き込みます");
       fw.close();
       
       }catch(IOException e){
           e.printStackTrace();
       }
        
    }
}
