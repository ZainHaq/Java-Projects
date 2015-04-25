/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animalguesser;



/**
 *
 * @author ahmem9877
 */
public class Mollusca extends Animal {
    boolean isAWorm=false;
    boolean hasStingers=false;
    boolean hasSkeleton=false;
    boolean hasLegs=false;   
    boolean hasSegments=false;
    boolean isVertebrate=false;
    boolean isASponge=false;
    
    
    
    public Mollusca(String n, int aA, String c){
        super(n,aA,c);
        
        super.hasSkeleton=this.hasSkeleton;
        super.hasLegs=this.hasLegs;
        super.isAWorm=this.isAWorm;
        super.hasSegments=this.hasSegments;
        super.isVertebrate=this.isVertebrate;
        super.hasStingers=this.hasStingers;
        super.isASponge=this.isASponge;
        
        super.bilateralSymmetry = this.bilateralSymmetry;
    }
}
