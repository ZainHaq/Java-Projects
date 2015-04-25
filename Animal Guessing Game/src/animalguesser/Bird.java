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
public class Bird extends Chordata{
    boolean isWarmBlooded=true;
    boolean hasFeathers=true;
    boolean hasWetSkin=false;
    boolean developsLungs=false;
    public Bird(String n, int aA, String c){
        super(n,aA,c);
        super.isWarmBlooded = this.isWarmBlooded;
        super.hasFeathers = this.hasFeathers;
        super.hasWetSkin = this.hasWetSkin;
        super.developsLungs = this.developsLungs;
    }
}