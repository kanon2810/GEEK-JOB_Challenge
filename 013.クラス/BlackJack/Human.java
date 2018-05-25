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

//抽象クラス
public abstract class Human{
    protected ArrayList<Integer> myCards=new ArrayList();
    
    abstract public int open();
    abstract public  void setCard(ArrayList<Integer> set);
    abstract public boolean checkSum();
      
    
}

