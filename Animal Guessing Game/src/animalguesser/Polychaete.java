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
public class Polychaete extends Annelid{
    boolean isItADriftingAnimal = true;
    public Polychaete(String n, int aA, String c){
        super(n,aA,c);
        super.isItADriftingAnimal = this.isItADriftingAnimal;
    } 
}
