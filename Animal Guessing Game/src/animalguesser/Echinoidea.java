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
public class Echinoidea extends Echinodermata {
    boolean isShapedLikeAStar=false;
    boolean hasLeatherySkin=false;
    
    public Echinoidea(String n, int aA, String c){
        super(n,aA,c);
        
        super.isShapedLikeAStar = this.isShapedLikeAStar;
        super.hasLeatherySkin = this.hasLeatherySkin;
    }
}
