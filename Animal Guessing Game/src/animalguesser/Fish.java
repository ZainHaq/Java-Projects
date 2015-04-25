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
public class Fish extends Chordata{
    boolean hasWetSkin=true;
    boolean developsLungs=false;
    boolean isWarmBlooded=false;
    boolean hasFeathers=false; 
    
    
    
    public Fish(String n, int aA, String c){
        super(n,aA,c);
        
        super.isWarmBlooded = this.isWarmBlooded;
        super.hasFeathers = this.hasFeathers;
        super.hasWetSkin = this.hasWetSkin;
        super.developsLungs = this.developsLungs;
        
        super.hasCartiliginousSkeleton = this.hasCartiliginousSkeleton;
        super.isExotic = this.isExotic;
    }
}
