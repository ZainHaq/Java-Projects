/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animalguesser;

import java.io.*;
import java.util.Scanner;
import java.io.FileReader;

public class AnimalGuesser {
static Animal[] animalArray;
static CategoryAttributes[] categories;
static boolean[] asked;
    
public static void importFromFile() throws IOException
{
    /*MAKES:
     * animalArray (animal array) - Array of every animal from the file - Fields: name (eg lobster), attr[] (array of attributes for the animal, each with a value and a description)
     * categories (categoryAttributes array) - Array of each category of animal - Fields: category, amt (of attributes), desc[] (array of string description of the attribute) 
     */
    Scanner fileIn = new Scanner (new FileReader ("animals.txt"));
    Scanner animalNumIn = new Scanner (new FileReader ("animalNum.txt"));
    
    
    
    animalArray = new Animal[animalNumIn.nextInt()]; //Make an array with the amount of animals
    
    categories = new CategoryAttributes[animalNumIn.nextInt()]; //Make an array of each of the categories
    
    
    /////////////////////////////////////////////////
    for (int i = 0; i < animalArray.length; i++) {            
         animalArray[i] = new Testudine("franklin the turtle", 5, "testudine");        
    }
    ////////////////////////////////////////////////
        
    String catName;
    int catNumAttr;
    
    //Categories array population
    for (int i = 0; i < categories.length; i++) {
        
        catName = animalNumIn.next(); //Input name of the category
        catNumAttr = animalNumIn.nextInt(); //Input amount of attributes per category 
        categories[i] = new CategoryAttributes(catName, catNumAttr);
        
        for (int j = 0; j < catNumAttr; j++) {            
            categories[i].descriptions[j] = animalNumIn.next(); //Populate the array of descriptions            
        }
    }   
    
    //Animals array population
    for (int i = 0; i < animalArray.length; i++) { //For every animal (row in the file)
        String animalCategory = fileIn.next(); //Input the classification
        String animalName = fileIn.next();  //Input the specific animal

        int categoryIndex = 0;
        int amtAttr;
        
        //Check classification and make appropriate object
        for (int j = 0; j < categories.length; j++) {
            if (animalCategory.equals(categories[j].category))
                categoryIndex = j;                
        }
        
        amtAttr = categories[categoryIndex].amt;
        animalArray[i] = makeAppropriateObject(animalCategory, animalName, amtAttr);
        
        //Once the object is made, populate the attribute array for the animal
        for (int j = 0; j < amtAttr; j++) {
            animalArray[i].attr[j] = new Attribute(fileIn.nextBoolean(), categories[categoryIndex].descriptions[j]);
        } 
    }
}
/*every animal has an array of attributes (contains value and description)
 * that is as large as the amount of attributes per their category
 * we need an array of classes and their respective amounts of attributes
 */
 
public static Animal makeAppropriateObject (String animalCategory, String animalName, int amtAttr)
{
    Animal toReturn;
    
    if (animalCategory.equals("Arachnid"))
        toReturn = new Arachnid(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Insect"))
        toReturn = new Insect(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Crustacean"))
        toReturn = new Crustacean(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Echinozoa"))
        toReturn = new Echinozoa(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Echinoidea"))
        toReturn = new Echinoidea(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Asterozoa"))
        toReturn = new Asterozoa(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Sessile"))
        toReturn = new Sessile(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Scyphozoa"))
        toReturn = new Scyphozoa(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Cestoda"))
        toReturn = new Cestoda(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Oligochaete"))
        toReturn = new Oligochaete(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Polychaete"))
        toReturn = new Polychaete(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Cephalopod"))
        toReturn = new Cephalopod(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Gastropod"))
        toReturn = new Gastropod(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Amphibian"))
        toReturn = new Amphibian(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Bird"))
        toReturn = new Bird(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Crocodillia"))
        toReturn = new Crocodillia(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Testudines"))
        toReturn = new Testudine(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Squamata"))
        toReturn = new Squamata(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Common"))
        toReturn = new Common(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Exotic"))
        toReturn = new Exotic(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Chondricthyes"))
        toReturn = new Chondricthye(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Rodentia"))
        toReturn = new Rodentia(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Chiroptera"))
        toReturn = new Chiroptera(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Soricomorpha"))
        toReturn = new Soricomorpha(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Primates"))
        toReturn = new Primates(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Cetacea"))
        toReturn = new Cetacea(animalName, amtAttr,animalCategory);
        
    else if (animalCategory.equals("Artiodactyla"))
        toReturn = new Artiodactyla(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Perissodactyla"))
        toReturn = new Perissodactyla(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Marsupial"))
        toReturn = new Marsupial(animalName, amtAttr,animalCategory);
        
    else if (animalCategory.equals("Xenarthra"))
        toReturn = new Xenarthra(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Afrotheria"))
        toReturn = new Afrotheria(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Monotremata"))
        toReturn = new Monotremata(animalName, amtAttr,animalCategory);
        
    else if (animalCategory.equals("Canidae"))
        toReturn = new Canidae(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Ursoidea"))
        toReturn = new Ursoidea(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Musteloidea"))
        toReturn = new Musteloidea(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Pinnipedia"))
        toReturn = new Pinnipedia(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Procyonidae"))
        toReturn = new Procyonidae(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Felidae"))
        toReturn = new Felidae(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Viverridae"))
        toReturn = new Viverridae(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Hyaenidae"))
        toReturn = new Hyaenidae(animalName, amtAttr,animalCategory);
    
    else if (animalCategory.equals("Herpestidae"))
        toReturn = new Herpestidae(animalName, amtAttr,animalCategory);
    
    else
        toReturn = new Testudine("franklin the turtle", 5,"Testudine");  
    
    return(toReturn);
}    

public static void outputToFile ()
{
    
}

public static void askQuestion(String descrip)
{    
    String question;       
         
        int counter=0;
        for (int i = 0; i < descrip.length(); i++)   {     
            if ( Character.isUpperCase( descrip.charAt(i) ) ){
                counter++;
            }                     
        }  
        int []indexWordSplit = new int[counter]; 
        int index=0;
        for (int i = 0; i < descrip.length(); i++)   {             
            if ( Character.isUpperCase( descrip.charAt(i) ) ){
                indexWordSplit[index] = i; 
                index++;
            }                      
        }
        String addOn ="";
        if (descrip.substring(0, 3).equalsIgnoreCase("can")||descrip.substring(0, 3).equalsIgnoreCase("has")||descrip.substring(0, 2).equalsIgnoreCase("is")) {
            for (int i = 0; i < counter; i++)   { 
               if(i!=0)
               addOn+= descrip.substring(indexWordSplit[i-1],indexWordSplit[i]) + " ";                 
               if(i==counter-1)
                  addOn+= descrip.substring(indexWordSplit[i],descrip.length());
        } 
            if (descrip.substring(0, 3).equalsIgnoreCase("can"))
            question = "Can it " + addOn + "?";
            else if (descrip.substring(0, 3).equalsIgnoreCase("has"))
            question = "Does it have " + addOn + "?";
            else
            question = "Is it " + addOn + "?";    
       }
            
        else{
            for (int i = 0; i < counter; i++)   { 
               if(i==0)
               addOn+= descrip.substring(0,indexWordSplit[i]-1) + " ";    
               else
               addOn+= descrip.substring(indexWordSplit[i-1],indexWordSplit[i]) + " ";                 
               if(i==counter-1)
                  addOn+= descrip.substring(indexWordSplit[i],descrip.length());
        }
            question= "Does it " + addOn + "?";   
        }       
        System.out.println(question);
}

public static boolean convertStringAnswerToBoolean(String s){
    if(s.equalsIgnoreCase("yes"))
        return true;    
    else
        return false;    
}

public static String initialGuesses (Scanner in)
{
    //boolean[] answers = new boolean[4];
    String category;
    
    //PHYLUM LEVEL
    System.out.println("Is it a vertebrate?");

    if(convertStringAnswerToBoolean(in.nextLine()))
        category = "chor";
    
    else
    {
        System.out.println("Does it have a skeleton?");        
        
        if (convertStringAnswerToBoolean(in.nextLine()))
        {
            System.out.println("Does it have legs?");
            
            if (convertStringAnswerToBoolean(in.nextLine()))
                category = "arth";
            
            else
            {
                System.out.println("Is it a sponge?");
                if(convertStringAnswerToBoolean(in.nextLine()))
                    category = "pori";
                else
                    category = "echi";
            }
        }
        
        else
        {
            System.out.println("Is it a worm?");            
            if (convertStringAnswerToBoolean(in.nextLine()))
            {
                System.out.println("Does it have segments?");
                if(convertStringAnswerToBoolean(in.nextLine()))
                    category = "anne";
                else
                    category = "plat";
            }
            else
            {
                System.out.println("Does it have stingers?");
                if(convertStringAnswerToBoolean(in.nextLine()))
                    category = "cnid";
                else
                    category = "moll";
            }
        }
    }
    // 1 - - - chor
    // 2 1 1 - arth
    // 2 1 2 1 pori
    // 2 1 2 2 echi
    // 2 2 1 1 anne
    // 2 2 1 2 plat
    // 2 2 2 1 cnid
    // 2 2 2 2 moll 
    
    //CLASS LEVEL
    if (category.equals("arth"))
    {
        System.out.println("Does it have 8 or more legs?");
        if(convertStringAnswerToBoolean(in.nextLine()))
            category = "arachnid";
        else
        {
            System.out.println("Is it an insect?");
            if(convertStringAnswerToBoolean(in.nextLine()))
                category = "insect";
            else
                category = "crustacean";
        }            
    }
    
    else if (category.equals("echi"))
    {
        System.out.println("Is it shaped like a star?");
        if(convertStringAnswerToBoolean(in.nextLine()))
            category = "asterozoa";
        else
        {
            System.out.println("Does it have leathery skin?");
            if(convertStringAnswerToBoolean(in.nextLine()))
                category = "echinozoa";
            else
                category = "echinoidea";
        }            
    }
    
    else if (category.equals("cnid"))
    {
        System.out.println("Is its movement scarce?");
        if(convertStringAnswerToBoolean(in.nextLine()))
            category = "scyphozoa";
        else
            category = "sessile";
    }
    
    else if (category.equals("anne"))
    {
        System.out.println("Is it a drifting animal?");
        if(convertStringAnswerToBoolean(in.nextLine()))
            category = "polychaete";
        else
            category = "oligochaete";
    }
    
    else if (category.equals("moll"))
    {
        System.out.println("Is it bilaterally symmetrical?");
        if(convertStringAnswerToBoolean(in.nextLine()))
            category = "cephalopod";
        else
            category = "gastropod";
    }
    
    else if (category.equals("chor"))
    {
        System.out.println("Is it warm blooded?");
        if(convertStringAnswerToBoolean(in.nextLine()))
        {
            System.out.println("Does it have feathers?");
            if(convertStringAnswerToBoolean(in.nextLine()))
                category = "bird";
            else
                category = "mammal"; 
        }
        
        else
        {
            System.out.println("Does it have wet skin?");
            if(convertStringAnswerToBoolean(in.nextLine()))
            {
                System.out.println("Does it develop lungs?"); 
                if(convertStringAnswerToBoolean(in.nextLine()))
                    category = "amphibian";
                else  
                    category = "fish";   
            }                    
            else                
                category = "reptile";  
        }
    }
    
    //ORDER LEVEL
    if (category.equals("reptile"))
    {
        System.out.println("Does it have a shell?");
        if(convertStringAnswerToBoolean(in.nextLine()))
            category = "testudines";
        else
        {
            System.out.println("Does it have an elongated snout?");
            if(convertStringAnswerToBoolean(in.nextLine()))
                category = "crocodillia";
            else
            {
                System.out.println("Is it a snake?");
                if(convertStringAnswerToBoolean(in.nextLine()))
                    category = "snake";
                else
                    category = "squamata";
            }
        }        
    }
    
    else if (category.equals("fish"))
    {
        System.out.println("Does it have a cartilaginous skeleton?");
        if(convertStringAnswerToBoolean(in.nextLine()))
            category = "chondricthye";
        else
        {
            System.out.println("Is it exotic?");
            if(convertStringAnswerToBoolean(in.nextLine()))
                category = "exotic";
            else
                category = "common";
        }            
    }
    
    else if (category.equals("mammal"))
    {
        System.out.println("Is it placental?");
        if(convertStringAnswerToBoolean(in.nextLine()))
        {
            System.out.println("Is it an ungulate?");
            if(convertStringAnswerToBoolean(in.nextLine()))
            {
                System.out.println("Is it odd toed?");
                if(convertStringAnswerToBoolean(in.nextLine()))                
                    category = "perissodactyla";                
                else
                {
                    System.out.println("Is it aquatic?");
                    if(convertStringAnswerToBoolean(in.nextLine()))
                        category = "cetacea";
                    else
                        category = "artiodactyla";
                }
            }
            else
            {
                System.out.println("Is it an insectivorous mammal?");
                if(convertStringAnswerToBoolean(in.nextLine()))
                {
                    System.out.println("Is it a rodent?");
                    if(convertStringAnswerToBoolean(in.nextLine()))                    
                        category = "rodentia";                    
                    else
                    {
                        System.out.println("Is it smaller than a mouse?");
                        if(convertStringAnswerToBoolean(in.nextLine()))                    
                            category = "soricomorpha";                    
                        else
                            category = "xenarthra";
                    }
                }
                else
                {
                    System.out.println("Does it have wings?");
                    if(convertStringAnswerToBoolean(in.nextLine()))                    
                        category = "chiroptera";                    
                    else
                    {
                        System.out.println("Is it of African origin?");
                        if(convertStringAnswerToBoolean(in.nextLine()))                        
                            category = "afrotheria";                        
                        else
                        {
                            System.out.println("Is it a primate?");
                            if(convertStringAnswerToBoolean(in.nextLine()))                            
                                category = "primates";                            
                            else                            
                                category = "carnivora";
                        }
                        
                    }
                }
            }            
        }
        else
        {
            System.out.println("Does it lay eggs?");
            if(convertStringAnswerToBoolean(in.nextLine()))            
                category = "monotremata";            
            else            
                category = "marsupial";            
        }
    }
    
    //SUBORDER/FAMILY LEVEL
    if (category.equals("carnivora"))
    {
        System.out.println("Is it dog-like?");
        if(convertStringAnswerToBoolean(in.nextLine()))
        {
            //Caniformia
            System.out.println("Does it have a small skull?");                    
            if(convertStringAnswerToBoolean(in.nextLine()))
            {
                System.out.println("Does it have round ears?");
                if(convertStringAnswerToBoolean(in.nextLine()))                
                    category = "musteloidea";                
                else                
                    category = "procyonidae";
            }
            else
            {
                System.out.println("Is it a bear?");
                if(convertStringAnswerToBoolean(in.nextLine()))                
                    category = "ursoidea";                
                else
                {
                    System.out.println("Does it have flippers?");
                    if(convertStringAnswerToBoolean(in.nextLine()))                    
                        category = "pinnipedia";                    
                    else                    
                        category = "canidae";                    
                }
            }
        }
        else
        {
            //Feliformia
            System.out.println("Is it an obligate carnivore?");                    
            if(convertStringAnswerToBoolean(in.nextLine()))
            {
                System.out.println("Is it a scavenger?");
                if(convertStringAnswerToBoolean(in.nextLine()))                
                    category = "hyaenidae";                
                else                
                    category = "felidae";
            }
            else
            {
                System.out.println("Is it immune to snake venom?");
                if(convertStringAnswerToBoolean(in.nextLine()))                
                    category = "herpestidae";                
                else
                    category = "viverridae";
            }
        }
    }
    
    return(category);
}


public static void guess(Scanner in, int categoryIndex, double remainingAnimals)
{   
    int toAsk = 0; //Index of attribute to ask about   
    double[] amtTrue = new double[categories[categoryIndex].amt]; //Amount of trues for attribute
    double closest = 2147000;
    
    for (int i = 0; i < categories[categoryIndex].amt; i++) { //for every attribute of the category
        if (!asked[i]) //if not asked
            for (int j = 0; j < animalArray.length; j++) // for every animal
                if (animalArray[j].isCandidate)//if they are still candidates
                {                    
                    if (animalArray[j].attr[i].value) //And the attribute is true, increment amount true
                        amtTrue[i]++;
                }
    }
    
    for (int i = 0; i < amtTrue.length; i++) {         //Find the question with the closest 50/50 split of trues and falses to maximize efficiency
        if(Math.abs(remainingAnimals/2 - amtTrue[i]) < closest)
        {            
            closest = Math.abs(remainingAnimals/2 - amtTrue[i]);
            toAsk = i;
        }     
    }  
    
    
    askQuestion(categories[categoryIndex].descriptions[toAsk]); //Convert the index of question to a string question
    boolean answer = convertStringAnswerToBoolean(in.next()); //Input user's answer
    
    for (int j = 0; j < animalArray.length; j++) // for every candidate
        if (animalArray[j].isCandidate)
            if (animalArray[j].attr[toAsk].value != answer) //if their attr doesnt match with answer 
                animalArray[j].isCandidate = false;
    
    asked[toAsk] = true; //Set the question to already asked
}

//public void
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner (System.in);
        String category;    
        
        System.out.println("Welcome to the Animal Guessing Game");
        System.out.println("Please think of an Animal");
        System.out.println("Please enter either 'yes' or 'no'");
        System.out.println("Press Enter to Start") ;
        in.nextLine();
        
        category = initialGuesses(in); //Determing the category of animal
        
        importFromFile();       
        
        
        for (int i = 0; i < animalArray.length; i++)                     
            if (!animalArray[i].categoryName.equalsIgnoreCase(category))            
                animalArray[i].isCandidate = false; //Eliminate all animals that aren't in the category
        
        int categoryIndex = 0;
        
        for (int i = 0; i < categories.length; i++) { 
            if (categories[i].category.equalsIgnoreCase(category)) //Determine the index of the category
                categoryIndex = i;
        }
        
        asked = new boolean[categories[categoryIndex].amt]; //Set all questions in that category to unasked
        for (int i = 0; i < asked.length; i++) 
            asked[i] = false;            
                
        
        double remainingAnimals = animalArray.length;        
        while(remainingAnimals > 1)                         //As long as there is more than one animal remaining
        {
            remainingAnimals = 0;
            for (int j = 0; j < animalArray.length; j++) //recount remaining animals
                if (animalArray[j].isCandidate)                               
                        remainingAnimals++;
            if(remainingAnimals == 1) //break if only one left
                break;
            guess(in, categoryIndex, remainingAnimals);    //Ask a question        
        }
        
        for (int j = 0; j < animalArray.length; j++) //Find the remaining animal
            if (animalArray[j].isCandidate) 
                System.out.println("You are thinking of a(n) " + animalArray[j].name);
    }
}