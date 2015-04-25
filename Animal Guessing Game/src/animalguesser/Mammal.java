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
public class Mammal extends Chordata{
    boolean isWarmBlooded=true;
    boolean hasFeathers=false;
    boolean hasWetSkin=false;
    boolean developsLungs=false;
    
    
    
    
    public Mammal(String n, int aA,String c){
        super(n,aA,c);
        
        super.isWarmBlooded = this.isWarmBlooded;
        super.hasFeathers = this.hasFeathers;
        super.hasWetSkin = this.hasWetSkin;
        super.developsLungs = this.developsLungs;
                
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
        
        super.hasASmallSkull = this.hasASmallSkull;
        super.haveRoundEars = this.haveRoundEars;
        super.isABear = this.isABear;
        super.hasFlippers = this.hasFlippers;
        super.isObligateCarnivore = this.isObligateCarnivore;
        super.isAScavenger = this.isAScavenger;
        super.isImmuneToSnakeVenom = this.isImmuneToSnakeVenom;
        super.isDogLikeCarnivore = this.isDogLikeCarnivore;
        super.isAquatic = this.isAquatic;
    } 
}
