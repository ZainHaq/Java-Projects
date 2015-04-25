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
public class Echinozoa extends Echinodermata {
    boolean isShapedLikeAStar=false;
    boolean hasLeatherySkin=true;
    
    public Echinozoa(String n, int aA, String c){
        super(n,aA,c);
        
        super.isShapedLikeAStar = this.isShapedLikeAStar;
        super.hasLeatherySkin = this.hasLeatherySkin;
    }

}