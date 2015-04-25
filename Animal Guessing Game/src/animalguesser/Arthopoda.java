/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animalguesser;


/**
 *
 * @author ahmem9877
 */
public class Arthopoda extends Animal{
    boolean hasSkeleton=true;
    boolean hasLegs=true;
    boolean isAWorm=false;
    boolean hasSegments=false;
    boolean isVertebrate=false;
    boolean hasStingers=false;
    boolean isASponge=false;
    
    
    
    public Arthopoda(String n, int aA, String c){
        super(n,aA,c);
        
        super.hasSkeleton=this.hasSkeleton;
        super.hasLegs=this.hasLegs;
        super.isAWorm=this.isAWorm;
        super.hasSegments=this.hasSegments;
        super.isVertebrate=this.isVertebrate;
        super.hasStingers=this.hasStingers;
        super.isASponge=this.isASponge;
        
        super.isItAnInsect = this.isItAnInsect;
        super.hasEightOrMoreLegs = this.hasEightOrMoreLegs;
    }
}
