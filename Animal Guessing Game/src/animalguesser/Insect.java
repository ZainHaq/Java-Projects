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
public class Insect extends Arthopoda {
    boolean isItAnInsect=true;
    boolean hasEightOrMoreLegs=false;
    public Insect(String n, int aA, String c){
        super(n,aA,c);
        
        super.isItAnInsect = this.isItAnInsect;
        super.hasEightOrMoreLegs = this.hasEightOrMoreLegs;
    } 
}
