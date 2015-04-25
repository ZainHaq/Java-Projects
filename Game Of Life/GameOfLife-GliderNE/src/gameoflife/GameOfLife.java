package gameoflife;
/* TITLE:  GAME OF LIFE SIMULATOR
 * PROGRAMMER: Zain Haq
 * LAST MODIFIED FEB 25, 2014
 */

import java.io.*; //needed to read file
import java.util.*; //needed to read file
import java.awt.*; //needed for graphics
import javax.swing.*; //needed for graphics
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class GameOfLife extends JFrame {

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //global variables
    static int width = 800;
    static int height = 800;
    static int borderWidth = 100;
    static int numCellsX = 60; //width of the grid (in cells)
    static int numCellsY = 60;
    static int cellSizeX = (width-(2*borderWidth))/numCellsX; //formula that determines optimal cell size
    static int cellSizeY = (height-(2*borderWidth))/numCellsY; //formula that determines optimal cell size
    static int labelX = borderWidth;
    static int labelY = borderWidth-1;//cleaner look
    static int numGenerations = 200;//sufficient for most designs
    static int currGeneration;
    
    static Color aliveColor = Color.WHITE;
    static Color deadColor = Color.BLUE;
    
    static boolean alive[][] = new boolean[numCellsX][numCellsY]; //array for current generation
    static boolean aliveNext[][] = new boolean[numCellsX][numCellsY]; //array for next generation
    static String fileName = "Initial cells.txt";
    
    static int pause=100;
    
    //sets the initial alive cells
    public void plantFirstGeneration() throws IOException {
        makeEveryoneDead();
        
        //plantFromFile(fileName);
        plantBlock(10, 10, 15, 15);
        //plantCenteredSquare(9);
        //plantGlider(29, 29, "SE");
        //plantGlider(29, 29, "SW");
        //plantGlider(29, 29, "NW");
        plantGlider(29, 28, "NE");              
    }
    
    //sets all cells to dead
    public void makeEveryoneDead() {
        for (int i = 0; i < numCellsX; i++) {
            for (int j = 0; j < numCellsY; j++) {
                alive[i][j] = false;
            }
        }
    }

    
    //reads the first generations' alive cells from a file
    public void plantFromFile(String fileName) throws IOException {

        File f = new File(fileName); //needed to read file
        Scanner s = new Scanner(f);
        
        numCellsX = s.nextInt(); //determine size of grid
        numCellsY = s.nextInt();
        
        numGenerations = s.nextInt();
        
        pause=s.nextInt();
        
        //redefine variables according to specifications from file
        alive = new boolean[numCellsX][numCellsY];
        aliveNext = new boolean[numCellsX][numCellsY];
        
        //redefine variables to accomadate specifications from file
        cellSizeX = (width - borderWidth*2) / numCellsX;
        cellSizeY = (height - borderWidth*2) / numCellsY;      
        
        while (s.hasNext()) {// reads coordinates from file
            int i = s.nextInt();         
            int j = s.nextInt();
            alive[i][j] = true; 
        }
    
    }
   
    //plants a solid rectangle of alive cells
    public void plantBlock(int startX, int startY, int numColumns, int numRows) {
        //ensures block isn't bigger than the grid and all of the block fits on the screen
        int endCol = Math.min(startX + numColumns, numCellsX);
        int endRow = Math.min(startY + numRows, numCellsY);
        
        pause =500;
        
        //creates block
        for (int i = startX; i < endCol; i++) {
            for (int j = startY; j < endRow; j++) {
                alive[i][j] = true;
            }
        }
    }

    
    //plants a solid square of alive cells in the centre of the grid
    public void plantCenteredSquare(int size) {
        //ensures square is planted in the center
        int startCol = (numCellsX - size) / 2;
        int endCol = (numCellsX + size) / 2;
        int startRow = (numCellsY - size) / 2;
        int endRow = (numCellsY + size) / 2;
        
        pause=1000;//has to be slowed down to admire it's beauty
        
        //creates square
        for (int i = startCol; i < endCol; i++) {
            for (int j = startRow; j < endRow; j++) {
                alive[i][j] = true;
            }
        }
    }

    
    //plants a "glider" group, which is a cluster of living cells that migrates across the grid from 1 generation to the next
    public void plantGlider(int startX, int startY, String direction) { //direction can be "SW", "NW", "SE", or "NE"

        for (int i = startX; i <= startX + 2; i++) {
            for (int j = startY; j <= startY + 2; j++) {
                //calls the right method based upon direction
                if (direction.equalsIgnoreCase("NW")) {
                    plantGliderNW(i,j,startX,startY);
                } else if (direction.equalsIgnoreCase("NE")) {
                    plantGliderNE(i,j,startX,startY);
                } else if (direction.equalsIgnoreCase("SW")) {
                    plantGliderSW(i,j,startX,startY);
                } else {
                    plantGliderSE(i,j,startX,startY);
                }
            }
        }
    }   
    
    //positions Glider so it goes in the specified direction
    public void plantGliderNW(int i, int j, int startX, int startY){
        if ((i == startX + 2 && (j != startY + 1)) || (i == startX + 1 && (j != startY))) {
                        alive[i][j] = false;
                    } 
                    else{
                        alive[i][j] = true;
                    }
    }  
    //positions Glider so it goes in the specified direction
    public void plantGliderNE(int i, int j, int startX, int startY){
        if ((i == startX && (j != startY + 1)) || (i == startX + 1 && (j != startY))) {
                        alive[i][j] = false;
                    } 
                    else{
                        alive[i][j] = true;
                    }
    }
    //positions Glider so it goes in the specified direction
    public void plantGliderSW(int i, int j, int startX, int startY){
        if ((i == startX+1 && (j != startY + 2)) || (i == startX+2  && (j != startY+1))) {
                        alive[i][j] = false;
                    } 
                    else{
                        alive[i][j] = true;
                    }
    }
    //positions Glider so it goes in the specified direction
    public void plantGliderSE(int i, int j, int startX, int startY){
        if ((i == startX + 1 && (j != startY + 2)) || (i == startX && (j != startY + 1))) {
                        alive[i][j] = false;
                    } else {
                        alive[i][j] = true;
                    }
    }
    
    //Glider Gun is a group of living cells that continually creates gliders
    public void plantGliderGun(int x, int y) { 
    //it consists of four shapes: two squares and two disorderly shapes
        
        //sets up the two squares
        gliderGunSquares(x,y);
              
        //sets up first shape
        gliderGunFirstShape(x,y);
        
        //sets up second shape
        gliderGunSecondShape(x,y);
        
    }

    public void gliderGunSquares(int x,int y){
        for (int i = x; i <= x + 1; i++) {
            for (int j = y; j <= y + 1; j++) {
                alive[i][j] = true;
                alive[i + 34][j - 2] = true;
            }
        }
    }
    public void gliderGunFirstShape(int x,int y){
        //keeps coordinates manageable
        int a= x+10;
        int b= y+1;
        
         //shape lacks a coherent pattern
        alive[a][b-1]=true;
        alive[a][b]=true;
        alive[a][b+1]=true;
        alive[a+1][b+2]=true;
        alive[a+1][b-2]=true;
        alive[a+2][b+3]=true;
        alive[a+2][b-3]=true;
        alive[a+3][b+3]=true;
        alive[a+3][b-3]=true;
        alive[a+4][b]=true;
        alive[a+5][b+2]=true;
        alive[a+5][b-2]=true;
        alive[a+6][b-1]=true;
        alive[a+6][b]=true;
        alive[a+6][b+1]=true;
        alive[a+7][b]=true;
    }  
    public void gliderGunSecondShape(int x,int y){
        //keeps coordinates manageable
        int a= x+20;
        int b= y-1;
        
        //has somewhat of a coherent pattern
        for (int i = a; i <= a + 1; i++) {
            for (int j = b - 1; j <= b + 1; j++) {
                alive[i][j] = true;
            }
        }
        for (int i = a + 2; i <= a + 4; i += 2) {
            for (int j = b - 2; j <= b + 2; j += 4) {
                alive[i][j] = true;
            }
        }
        
        for (int j = b - 3; j <= b + 3; j += 6) {
                alive[a+4][j] = true;
            }
           
     }
    
    //applies the rules of The Game of Life to determine which cells will be alive in the next generation
    public void computeNextGeneration() {
        for (int i = 0; i < alive.length; i++) {
            for (int j = 0; j < alive.length; j++) {
                int numNeighbours = countLivingNeighbors(i, j);//stores the number of living neigbours
                updateCell(i, j, numNeighbours);//passes the values to the next method
            }
        }
    }
    
    //sets up the array for the next generation
    public void updateCell(int i, int j, int numNeighbours) {
        if (alive[i][j]) {
            if (numNeighbours == 2 || numNeighbours == 3) {
                aliveNext[i][j] = true;
            } else {
                aliveNext[i][j] = false;
            }
        } else {
            if (numNeighbours == 3) {
                aliveNext[i][j] = true;
            } else {
                aliveNext[i][j] = false;
            }
        }
    }
    
    //sets the current generation equal to the next generation
    public void plantNextGeneration() {
       for(int i=0;i<aliveNext.length;i++){
           for(int j=0;j<aliveNext.length;j++){
               alive[i][j]=aliveNext[i][j];
       }
       }
    }
   
    //counts the number of living cells adjacent to cell (i, j)
    public int countLivingNeighbors(int i, int j) {
        int livingNeighbours = 0;//initial condition of counter
        
        for (int x = i + 1; x >= i - 1; x--) {
            for (int y = j + 1; y >= j - 1; y--) {
                if ((x < 0 || y < 0 || x >= alive.length || y >= alive.length) || (x == i && y == j)) {
                    //all out of bound values enter here
                    //ensures only values within bounds get passed to the array
                } else if (alive[x][y]) {
                    livingNeighbours++;//counts the neighbours
                }
            }
        }
        return livingNeighbours;//returns the number of neighbours
    }
    
    //makes the pause
    public static void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } 
        catch (Exception e) {}
    }
    
    //displays the statistics at the top of the screen
    void drawLabel(Graphics g, int state) {
        g.setColor(Color.black);
        g.fillRect(0, 0, width, borderWidth);
        g.setColor(Color.WHITE);
        g.drawString("Generation: " + state, labelX, labelY);
    }
    
    //draws the current generation of living cells on the screen
    public void paint(Graphics g) {
        int x, y, i, j;
        
        x = borderWidth;
        
        drawLabel(g, currGeneration);//draws the number of generations on the screen

        //draws the living cells
        for (i = 0; i < numCellsX; i++) {//ensures indices are within bounds
            y = borderWidth;
            
            for (j = 0; j < numCellsY; j++) {//ensures indices are within bounds
                
                if ( alive[i][j] ) //sets alive cells to appropriate colour
                    g.setColor( aliveColor );
                
                else  //sets dead cells to appropriate colour
                    g.setColor( deadColor );
                
                //draws each individual cell
                g.fillRect( x, y, cellSizeX, cellSizeY );
                g.setColor( Color.black );
                g.drawRect( x, y, x+cellSizeX, y+cellSizeY );
                
                y += cellSizeY;
            }
            
            x += cellSizeX;
        }
        
    }

    //sets up the JFrame screen
    public void initializeWindow() {
        setTitle("Game of Life Simulator");
        setSize(height, width);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.black);
        setVisible(true);
    }
     
    //main algorithm
    public static void main(String args[]) throws IOException {

        GameOfLife currGame = new GameOfLife();//creates an instance of our class
        
        currGame.initializeWindow();

        currGame.plantFirstGeneration(); //sets the initial generation of living cells, either by reading from a file or creating them algorithmically

        for (currGeneration = 1; currGeneration <= numGenerations; currGeneration++) {
            sleep(pause);//pauses after each generation
            currGame.repaint();//draws the grid for the current generation  
            currGame.computeNextGeneration();//determines the next generation
            currGame.plantNextGeneration();//plants the next generation
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
