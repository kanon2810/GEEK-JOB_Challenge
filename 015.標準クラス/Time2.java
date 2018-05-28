package kadai;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Date;
import java.text.SimpleDateFormat;



/**
 *
 * @author タカ
 */
public class Time2 {
    public static void main(String[] args){
        Date a=new Date();
        
        SimpleDateFormat d=new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");
        
        String c=d.format(a);
        System.out.print(c);
    }
}
