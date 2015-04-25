/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animalguesser;

/**
 *
 * @author duman9082
 */
public class Feliformia extends Carnivora{
    boolean isDogLikeCarnivore = false;
    
    
    
    public Feliformia(String n, int aA, String c){
        super(n,aA, c);
        
        super.isDogLikeCarnivore = this.isDogLikeCarnivore;
        
        super.isObligateCarnivore = this.isObligateCarnivore;
        super.isAScavenger = this.isObligateCarnivore;
        super.isImmuneToSnakeVenom = this.isImmuneToSnakeVenom;
    }
    
}
