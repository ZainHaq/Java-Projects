package animalguesser;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author ahmem9877
 */
public class Chordata extends Animal {
    boolean isVertebrate=true;
    boolean hasSkeleton=false;
    boolean isASponge=false;
    boolean isAWorm=false;
    boolean hasStingers=false;
    boolean hasLegs=false;   
    boolean hasSegments=false;   
    
    public Chordata(String n, int aA, String c){
        super(n,aA,c);
        
        super.hasSkeleton=this.hasSkeleton;
        super.hasLegs=this.hasLegs;
        super.isAWorm=this.isAWorm;
        super.hasSegments=this.hasSegments;
        super.isVertebrate=this.isVertebrate;
        super.hasStingers=this.hasStingers;
        super.isASponge=this.isASponge;
        
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
        
        super.hasShell = this.hasShell;
        super.hasElongatedSnout = this.hasElongatedSnout;
        
        super.hasCartiliginousSkeleton = this.hasCartiliginousSkeleton;
        super.isExotic = this.isExotic;
        
    }  
}
