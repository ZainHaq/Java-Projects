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
public class Cephalopod extends Mollusca{
    boolean bilateralSymmetry=true;
    public Cephalopod(String n, int aA, String c){
        super(n,aA,c);
        super.bilateralSymmetry = this.bilateralSymmetry;
    } 
}
