/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animalguesser;

/**
 *
 * @author duman9082
 */
public class Viverridae extends Feliformia{
    boolean isObligateCarnivore = false;
    boolean isAScavenger = false;
    boolean isImmuneToSnakeVenom = false;
    public Viverridae(String n, int aA, String c){
        super(n, aA, c);
        
        super.isObligateCarnivore = this.isObligateCarnivore;
        super.isAScavenger = this.isObligateCarnivore;
        super.isImmuneToSnakeVenom = this.isImmuneToSnakeVenom;
    }
    
}
