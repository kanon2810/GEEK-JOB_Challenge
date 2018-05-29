/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kadai;
import java.text.ParseException;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author タカ
 */
public class Time4 {
    public static void main(String[] args){
     
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date=null;
        Date date2=null;
     
        try {
            date = sdf.parse("2015/01/01 00:00:00");
            
            
            date2=sdf.parse("2015/12/31 12:59:59");
            
            
            
        } catch (ParseException ex) {
            Logger.getLogger(Time4.class.getName()).log(Level.SEVERE, null, ex);
        }
        long Start=date.getTime();
        long end=date2.getTime();
        
        long sa=(end-Start);
        
        System.out.print(sa);

        
    }
}
