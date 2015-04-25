package animalguesser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author zain
 */
public class Amphibian extends Chordata{
    boolean hasWetSkin=true;
    boolean developsLungs=true;
    boolean isWarmBlooded=false;
    boolean hasFeathers=false; 
    public Amphibian(String n, int aA, String c){
        super(n,aA,c);
        super.isWarmBlooded = this.isWarmBlooded;
        super.hasFeathers = this.hasFeathers;
        super.hasWetSkin = this.hasWetSkin;
        super.developsLungs = this.developsLungs;
    }
}
