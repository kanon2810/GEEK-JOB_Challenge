/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadai;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author タカ
 */
public class Time3 {
    public static void main(String[] agrs){
        
         Date a=new Date();
        Calendar t=Calendar.getInstance();
      
        t.set(2016,10,4,10,0,0);
        
   a=t.getTime();
        
        System.out.print(a);
        
        SimpleDateFormat z=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String data=z.format(a);
                System.out.print(data);
                
    }
}
