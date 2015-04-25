/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animalguesser;

/**
 *
 * @author duman9082
 */
public class Felidae extends Feliformia{
    boolean isObligateCarnivore = true;
    boolean isAScavenger = false;
    boolean isImmuneToSnakeVenom = false;
    public Felidae(String n, int aA, String c){
        super(n,aA,c);
        
        super.isObligateCarnivore = this.isObligateCarnivore;
        super.isAScavenger = this.isObligateCarnivore;
        super.isImmuneToSnakeVenom = this.isImmuneToSnakeVenom;
    }
    
}
