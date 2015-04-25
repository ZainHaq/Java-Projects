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
public class Oligochaete extends Annelid{
    boolean isItADriftingAnimal=false;
    public Oligochaete(String n, int aA, String c){
        super(n,aA,c);
        super.isItADriftingAnimal = this.isItADriftingAnimal;
    } 
}
