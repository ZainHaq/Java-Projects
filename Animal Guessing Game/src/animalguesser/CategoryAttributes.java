/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animalguesser;

/**
 *
 * @author line0116
 */
public class CategoryAttributes {
    String category; //Arachnid
    int amt; //4
    String[] descriptions; //hasElongatedBody has100Legs hasVenomousStinger livesByFeedingOnBlood
    
    public CategoryAttributes(String c, int a)
    {
        category = c;
        amt = a;
        descriptions = new String[amt];
    }
}
