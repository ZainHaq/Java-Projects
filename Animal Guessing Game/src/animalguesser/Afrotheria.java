/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animalguesser;

/**
 *
 * @author duman9082
 */
public class Afrotheria extends Mammal{
    boolean isPlacental = true;
    boolean isAnUngulate = false;
    boolean isInsectivorousMammal = false;
    boolean hasWings = false;
    boolean AfricanOrigin = true;
    boolean isARodent = false;
    boolean isSmallerThanAMouse = false;
    boolean IsOddToed = false;
    boolean laysEggs = false;
    boolean isAPrimate = false;
    public Afrotheria(String n, int aA, String c){
        super(n,aA,c);
        
        super.isPlacental = this.isPlacental;
        super.isAnUngulate = this.isAnUngulate;
        super.isInsectivorousMammal = this.isInsectivorousMammal;
        super.hasWings = this.hasWings;
        super.AfricanOrigin = this.AfricanOrigin;
        super.isARodent = this.isARodent;
        super.isSmallerThanAMouse = this.isSmallerThanAMouse;
        super.IsOddToed = this.IsOddToed;
        super.laysEggs = this.laysEggs;
        super.isAPrimate = this.isAPrimate; 
    }
}
