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
public class Chondricthye extends Fish{
    boolean hasCartiliginousSkeleton=true;
    boolean isExotic=false;
    public Chondricthye(String n, int aA, String c){
        super(n,aA,c);
        super.hasCartiliginousSkeleton = this.hasCartiliginousSkeleton;
        super.isExotic = this.isExotic;
        
    }
}