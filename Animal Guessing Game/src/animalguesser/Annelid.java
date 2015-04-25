package animalguesser;



public class Annelid extends Animal{
    boolean isAWorm=true;
    boolean hasSegments=true;
    boolean hasSkeleton=false;
    boolean hasLegs=false;
    boolean isVertebrate=false;
    boolean hasStingers=false;
    boolean isASponge=false;
    
   
    
    public Annelid(String n, int aA, String c){
        super(n,aA,c);
        
        super.hasSkeleton=this.hasSkeleton;
        super.hasLegs=this.hasLegs;
        super.isAWorm=this.isAWorm;
        super.hasSegments=this.hasSegments;
        super.isVertebrate=this.isVertebrate;
        super.hasStingers=this.hasStingers;
        super.isASponge=this.isASponge;
        
        super.isItADriftingAnimal = this.isItADriftingAnimal;
    } 
}
