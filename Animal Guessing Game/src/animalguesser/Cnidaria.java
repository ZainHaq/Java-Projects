package animalguesser;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author ahmem9877
 */
public class Cnidaria extends Animal {
    boolean hasStingers=true;
    boolean hasSkeleton=false;
    boolean hasLegs=false;
    boolean isAWorm=false;
    boolean hasSegments=false;
    boolean isVertebrate=false;
    boolean isASponge=false;
    
      
    
    public Cnidaria(String n, int aA, String c){
        super(n,aA,c);
        
        super.hasSkeleton=this.hasSkeleton;
        super.hasLegs=this.hasLegs;
        super.isAWorm=this.isAWorm;
        super.hasSegments=this.hasSegments;
        super.isVertebrate=this.isVertebrate;
        super.hasStingers=this.hasStingers;
        super.isASponge=this.isASponge;
        
        super.scarceMovement = this.scarceMovement;
    }
}
