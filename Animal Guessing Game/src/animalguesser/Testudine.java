package animalguesser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import animalguesser.Reptile;

/**
 *
 * @author zain
 */
public class Testudine extends Reptile{
    boolean hasShell=true;
    boolean hasElongatedSnout=false;   
    boolean isSnake=false;
    public Testudine (String n, int aA, String c){
        super(n,aA,c);
        super.hasShell = this.hasShell;
        super.hasElongatedSnout = this.hasElongatedSnout;
        super.isSnake=this.isSnake;
             
    }    
    
}
