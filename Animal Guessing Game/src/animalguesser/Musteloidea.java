/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animalguesser;

/**
 *
 * @author duman9082
 */
public class Musteloidea extends Caniformia{
    boolean hasASmallSkull = true;
    boolean haveRoundEars = true;
    boolean isABear = false;
    boolean hasFlippers = false;
    public Musteloidea(String n, int aA, String c){
        super(n,aA,c);
        
        super.hasASmallSkull = this.hasASmallSkull;
        super.haveRoundEars = this.haveRoundEars;
        super.isABear = this.isABear;
        super.hasFlippers = this.hasFlippers;
    }
}
