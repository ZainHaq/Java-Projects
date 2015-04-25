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
public class Exotic extends Fish{
    boolean hasCartiliginousSkeleton=false;
    boolean isExotic=true;
    public Exotic(String n, int aA, String c){
        super(n,aA,c);
        super.hasCartiliginousSkeleton = this.hasCartiliginousSkeleton;
        super.isExotic = this.isExotic;
    }
}
