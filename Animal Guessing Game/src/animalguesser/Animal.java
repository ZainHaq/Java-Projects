/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animalguesser;

/**
 *
 * @author ahmem9877
 */
public class Animal {
    String name;
    String categoryName;
    Attribute[] attr;
    boolean isCandidate = true;
    
    //--------------------- 
    boolean hasSkeleton;
    boolean hasLegs;
    boolean isAWorm;
    boolean hasSegments;
    boolean isVertebrate;
    boolean hasStingers;
    boolean isASponge;
    
    boolean isItAnInsect; //Arthropod
    boolean hasEightOrMoreLegs; 
    
    boolean isShapedLikeAStar; //Echinoderm
    boolean hasLeatherySkin;  
    
    boolean scarceMovement; //Cnidaria
    
    boolean isItFlat; //Platyhelminthes
    
    boolean isItADriftingAnimal;//Annelid
    
    boolean bilateralSymmetry;//Mollusca    
    
    boolean isWarmBlooded; //Chordata
    boolean hasFeathers;
    boolean hasWetSkin;
    boolean developsLungs;    
    
    boolean isPlacental;
    boolean isAnUngulate;
    boolean isInsectivorousMammal;
    boolean hasWings;
    boolean AfricanOrigin;
    boolean isARodent;
    boolean isSmallerThanAMouse;
    boolean IsOddToed;
    boolean laysEggs;
    boolean isAPrimate;
    
    boolean hasASmallSkull;
    boolean haveRoundEars;
    boolean isABear;
    boolean hasFlippers;
    boolean isObligateCarnivore;
    boolean isAScavenger ;
    boolean isImmuneToSnakeVenom;
    boolean isDogLikeCarnivore;
    
    boolean isAquatic;  
    
    boolean hasShell;
    boolean hasElongatedSnout;
    boolean isSnake;
    
    boolean hasCartiliginousSkeleton;
    boolean isExotic;
    
    
    
    public Animal (String n, int aA, String c)
    {
        name = n;
        attr = new Attribute[aA];      
        categoryName=c;
    }
}
