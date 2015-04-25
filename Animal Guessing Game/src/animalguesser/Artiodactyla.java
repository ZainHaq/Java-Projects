/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animalguesser;

/**
 *
 * @author Edric
 */
public class Artiodactyla extends Cetartiodactyla {
    boolean isAquatic = false;
    
    public Artiodactyla(String n, int aA, String c){
        super(n,aA,c);
        super.isAquatic = this.isAquatic;
        

    }
}

