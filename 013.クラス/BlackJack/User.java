package gyanbulpackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;

/**
 *
 * @author タカ
 */
public class User extends Human{
   
    @Override
    public  void setCard(ArrayList<Integer> set){
        for(int i=0;i < set.size();i++){
        myCards.add(set.get(i));
        }
    }
    @Override
    public int open(){
        int total=0;
        for(int i=0;i < myCards.size();i++){
            total=total+myCards.get(i);
        }
        return total;
    }
    @Override
    public boolean checkSum(){
        if(open()<17){
            return true;
        }else{
            return false;
        }
    }
        
    } 



