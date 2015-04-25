/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animalguesser;

/**
 *
 * @author duman9082
 */
public class Caniformia extends Carnivora{
    boolean isDogLikeCarnivore = true;
    
   
    
    public Caniformia(String n, int aA, String c){
        super(n, aA,c);
                
        super.isDogLikeCarnivore = this.isDogLikeCarnivore;
        
        super.hasASmallSkull = this.hasASmallSkull;
        super.haveRoundEars = this.haveRoundEars;
        super.isABear = this.isABear;
        super.hasFlippers = this.hasFlippers;
    }
    
}
