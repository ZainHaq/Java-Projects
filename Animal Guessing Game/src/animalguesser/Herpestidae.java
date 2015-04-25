/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animalguesser;

/**
 *
 * @author Edric
 */
public class Herpestidae extends Feliformia{
    boolean isObligateCarnivore = false;
    boolean isAScavenger = true;
    boolean isImmuneToSnakeVenom = true;
    public Herpestidae(String n, int aA, String c){
        super(n, aA,c);
        
        super.isObligateCarnivore = this.isObligateCarnivore;
        super.isAScavenger = this.isObligateCarnivore;
        super.isImmuneToSnakeVenom = this.isImmuneToSnakeVenom;
    }
    
}
