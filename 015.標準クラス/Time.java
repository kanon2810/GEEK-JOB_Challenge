/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author タカ
 */
public class Time {
    
    public static void main(String[] args){
      
      Date a=new Date();
        Calendar t=Calendar.getInstance();
      
        t.set(2016,0,1,0,0,0);
        
   a=t.getTime();
        
        System.out.print(a);
        
        
    }
    
    
    
}
