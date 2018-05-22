/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author タカ
 */
public class Human {
    
    
        
    String name="";
    int height=0;
 
    void setHuman(String x,int y){
       this.name=x;
       this.height=y;  
   }
    
    void print(){
        //nameとheightを表示する
        System.out.print(name+height);
    }
        
}


    
