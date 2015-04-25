
package sortingandsearching;

import java.util.Random;

public class SortingAndSearching {

    static int numBubbleSortComparisons;
    static int numInsertionSortComparisons;
    static int numMergeSortComparisons;
    static int numBinarySearchComparisons;
    static int numDumbSearchComparisons;
    
    //SEARCHES A PRE-SORTED ARRAY FOR searchItem BETWEEN INDICES lowerIndex AND upperIndex
    public static void binarySearch( int lowerIndex, int upperIndex, int searchItem, int[] sortedArray) {        
        
        System.out.println("Running binarySearch(" + lowerIndex + ", " + upperIndex + ")");

        if (lowerIndex == upperIndex) { //We've narrowed the search to a single element
            
            numBinarySearchComparisons++;
            
            if (sortedArray[ lowerIndex ] == searchItem) { //the search-item was found!
                numBinarySearchComparisons++;
                System.out.println("Found at index " + lowerIndex);
            } 
            
            else {
                System.out.println("Item not found.");
            }
        } 
        
        else {
            
            int middleIndex = (lowerIndex + upperIndex) / 2; //find the midpoint of the upper and lower indices
            
            numBinarySearchComparisons++;
            
            if ( sortedArray[ middleIndex ] == searchItem ) { //the search-item was found!
                System.out.println( "Found at index " + middleIndex );
            } 
            
            else if (sortedArray[ middleIndex ] > searchItem ) { //search the lower half of the array
                binarySearch( lowerIndex, middleIndex, searchItem, sortedArray );
            } 
            
            else { //search the upper half of the array
                binarySearch( middleIndex + 1, upperIndex, searchItem, sortedArray );
            }
        }

    }
    
    
    //SEARCHES AN ARRAY FOR searchItem BY EXAMINING EACH ELEMENT OF THE ARRAY FROM LEFT TO RIGHT
    public static void dumbSearch(int searchItem, int[] a) {
        System.out.println("Running dumb search");
        
        boolean found = false;

        for (int i = 0; i < a.length && !found; i++) { //GO THROUGH THE ARRAY FROM LEFT TO RIGHT UNTIL THE ITEM IS FOUND
            
            numDumbSearchComparisons ++;
            
            if ( a[i] == searchItem ) {
                
                System.out.println( "Found at index " + i);
                
		found = true;
            }
        }

        if ( ! found ) 
            System.out.println("Item not found.");
   
    }
    

    public static int[] bubbleSort(int[] a) {
        int temp;

        for (int pass = 1; pass < a.length; pass++) {

            for (int i = 0; i < a.length - pass; i++) {

                if (a[i] > a[i + 1]) {
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }

                numBubbleSortComparisons += 2;
            }

	   numBubbleSortComparisons += 1;

        }

        return a;
    }

    
    public static int[] insertionSort(int[] a) {

        int insert; // temporary variable to hold element to insert

        for (int i = 1; i < a.length; i++) {
            // store value in current element
            insert = a[ i];

            // initialize location to place element
            int moveItem = i;

            // search for place to put current element
            while (moveItem > 0 && a[ moveItem - 1] > insert) {
                // shift element right one slot
                a[ moveItem] = a[ moveItem - 1];
                moveItem--;

                numInsertionSortComparisons += 2;
            } // end while

            a[ moveItem] = insert; // place inserted element

        }

        return a;
    }

    
    private static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int i = 0;
	int lenA = a.length, lenB = b.length

        while ( i < lenA && j < lenB ) {

            if (a[i] <= b[j]) {
                c[k] = a[i];
                i++;
            } 
	    
	    else {
                c[k] = b[j];
                j++;
            }

            k++;
            numMergeSortComparisons += 3;

        }

        if (i == lenA ) {
            for (int m = j; m < b.length; m++) {
                c[k] = b[m];
                k++;
            }
        } 
	
	else {
            for (int m = i; m < a.length; m++) {
                c[k] = a[m];
                k++;
            }
        }
        return c;
    }

    
    public static int[] mergeSort(int[] array, int start, int end ) {
        if (start == end) // base case
        {
            int[] arrayWithOneElement = {array[start]};
            return arrayWithOneElement;
        } 
        
        else {
            int middle = (end + start) / 2;

            int[] sortedLeftHalf = mergeSort(array, start, middle);  // recursive call
            int[] sortedRightHalf = mergeSort(array, middle + 1, end); // recursive call

            return merge(sortedLeftHalf, sortedRightHalf);  // merge the two sorted halves
        }

    }

    
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println("");
    }
    
    
    private static int[] makeRandomSortedArray( int size, int maxIncrementSize ) { 
        Random generator = new Random();
        
        int [] a = new int[size];
        int currItem = 0;
        
        for (int i = 0; i < a.length; i++) {
            int increment = generator.nextInt( maxIncrementSize );
            currItem += increment;
            a[i] = currItem;
        }
        
        return a;
    }
    
    
    //COMPARES THE PERFORMANCE OF 3 SORTING ALGORITHMS:  BUBBLE SORT, INSERTION SORT & MERGE SORT
    public static void compareSortingAlgorithms() {
        Random generator = new Random();
        
        long startTime, elapsedTime1, elapsedTime2, elapsedTime3;

        int arraySize = 10; //CHANGE THIS

        int[] randomArray = new int[ arraySize ];
        int[] randomArrayCopy1 = new int[ arraySize ];
        int[] randomArrayCopy2 = new int[ arraySize ];

        for (int i = 0; i < randomArray.length; i++) { //makes 3 copies of a random array 
            randomArray[i] = generator.nextInt( arraySize*2 );
            randomArrayCopy1[i] = randomArray[i];
            randomArrayCopy2[i] = randomArray[i];
        }

        //Test Bubble sort
        startTime = System.currentTimeMillis();
        int[] b1 = bubbleSort( randomArray );
        printArray(b1); //print the sorted array to verify. Comment this out if arraySize is more than 100.
        elapsedTime1 = System.currentTimeMillis() - startTime; //the time bubble sort took
        System.out.println("Bubblesort made " + numBubbleSortComparisons + " comparisons and took " + elapsedTime1 + " milliseconds" + "\n");
        
        //Test Insertion sort
        startTime = System.currentTimeMillis();
        int[] b2 = insertionSort( randomArrayCopy1 );
        printArray(b2);
        elapsedTime2 = System.currentTimeMillis() - startTime; //the time insertion sort took
        System.out.println("Insertionsort made " + numInsertionSortComparisons + " comparisons and took " + elapsedTime2 + " milliseconds"+ "\n");
       
        //test Merge sort
        startTime = System.currentTimeMillis();
        int[] b3 = mergeSort( randomArrayCopy2, 0, randomArrayCopy2.length - 1 );
        printArray(b3);
        elapsedTime3 = System.currentTimeMillis() - startTime; //the time merge sort took               
        System.out.println("Mergesort made " + numMergeSortComparisons + " comparisons and took " + elapsedTime3 + " milliseconds"+ "\n"); 
        
        
        double performanceRatio = (double) numInsertionSortComparisons / numMergeSortComparisons;
        
        System.out.println("Insertion sort needed " + performanceRatio + " times as many comparisons as merge sort.");
    }
    

    //COMPARES THE PERFORMANCE OF DUMB SEARCH AND BINARY SEARCH
    public static void compareSearchAlgorithms () {
        
        Random generator = new Random();
        
        int size = 50; //CHANGE THIS
        
        int [] sortedArray = makeRandomSortedArray(size, 10);
        printArray(sortedArray);
        
        int n = sortedArray.length;
        long startTime, elapsedTime;
        
        int searchItem = sortedArray[ generator.nextInt(size-1) ]; //A random element from the sorted array
        
        //TEST DUMB SEARCH ON THE RANDOM ARRAY
        startTime = System.currentTimeMillis();
        dumbSearch( searchItem, sortedArray );
        elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Dumb search took " + elapsedTime + " milliseconds and made " + numDumbSearchComparisons + " comparisons.");
        
        System.out.println("\n");
        
        //TEST BINARY SEARCH ON THE RANDOM ARRAY
        startTime = System.currentTimeMillis();
        binarySearch( 0, n-1, searchItem, sortedArray);  
        elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Binary search took " + elapsedTime + " milliseconds and made " + numBinarySearchComparisons + " comparisons.");

    }
         
    
    public static void main(String[] args) {
        
        compareSearchAlgorithms();
        //compareSortingAlgorithms();

    }
}
