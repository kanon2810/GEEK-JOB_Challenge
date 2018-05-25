package gyanbulpackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import gyanbulpackage.Human;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author タカ
 */
public class Dealer extends Human{
   
  protected  ArrayList<Integer> cards=new ArrayList();
    public ArrayList<Integer> hit;
    
  
    public Dealer(){
        int card=10;
        
        for(int x=1;x<=4;x++){
            for(int i=1;i<=13;i++){
                if(i>10){
                    cards.add(10);
                }else{
                    cards.add(i);
                }
            }
        }
    
    }  
    
    public ArrayList<Integer> hit(){
        ArrayList<Integer> get=new ArrayList<Integer>();
           Random rand =new Random();
           Integer index=rand.nextInt(cards.size());
           get.add(cards.get(index));
           cards.remove(index);
           return get;
    }
   
    public ArrayList<Integer> deal(){
        ArrayList<Integer> wget=new ArrayList<Integer>();
        
           Random rand2=new Random();
           Integer index=0;
           
           for(int i=0;i<2;i++){
           index = rand2.nextInt(cards.size());
                  
           wget.add(cards.get(index));
           cards.remove(index);
           }
            return wget;
           }
    @Override
    public void setCard(ArrayList<Integer> set){
        for(int i=0;i<set.size();i++){
        myCards.add(set.get(i));
          }
    }
    @Override
    public int open(){
        int total=0;
        for(int i=0;i<myCards.size();i++){
        total=total+myCards.get(i);    
       }
        return total;
    }
   @Override 
   public boolean checkSum(){
        if(open()<=17){
            return true;
        }else{
            return false;
        }
    }
    
}  
      
    
    
    

        
    

