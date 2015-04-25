/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package animalguesser;

/**
 *
 * @author zain
 */
public class Arachnid extends Arthopoda{
    boolean hasEightOrMoreLegs=true;
    boolean isItAnInsect=false;
    public Arachnid(String n, int aA, String c){
        super(n,aA,c);
        
        super.isItAnInsect = this.isItAnInsect;
        super.hasEightOrMoreLegs = this.hasEightOrMoreLegs;
    } 
}
