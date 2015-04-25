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
public class Squamata extends Reptile{
    boolean hasShell=false;
    boolean hasElongatedSnout=false;
    boolean isSnake=false;
    public Squamata(String n, int aA, String c){
        super(n,aA,c);
        super.hasShell = this.hasShell;
        super.hasElongatedSnout = this.hasElongatedSnout;
        super.isSnake=this.isSnake;
    }
}
