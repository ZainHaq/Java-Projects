package animalguesser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 *
 * @author zain
 */
public class Crustacean extends Arthopoda {
    boolean isItAnInsect=false;
    boolean hasEightOrMoreLegs=false;  
    public Crustacean(String n, int aA, String c){
        super(n,aA,c);
        
        super.isItAnInsect = this.isItAnInsect;
        super.hasEightOrMoreLegs = this.hasEightOrMoreLegs;
    } 
}
