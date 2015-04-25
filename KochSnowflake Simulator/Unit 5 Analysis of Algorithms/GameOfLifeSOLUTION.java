public class GameOfLifeSOLUTION extends JFrame {
    static int width = 800;
    static int height = 800;
    static int borderWidth = 50;
    static int numCellsX = 30; //width of the grid (in cells)
    static int numCellsY = 30;
    static int cellSizeX = (width - 2 * borderWidth) / numCellsX;
    static int cellSizeY = (height - 2 * borderWidth) / numCellsY;
    static int numGenerations = 100;
    static int currGeneration = 1;
    static Color aliveColor = Color.YELLOW;
    static Color deadColor = Color.BLUE;
    static boolean alive[][] = new boolean[numCellsX][numCellsY]; //whether each cell is alive or dead
    static boolean aliveNext[][] = new boolean[numCellsX][numCellsY]; //whether each cell will be alive or dead in the next generation
    
    //sets the initial alive cells
    public void plantFirstGeneration() throws IOException {
        makeEveryoneDead();
        plantGlider(1, 2, 4);
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
        File f = new File(fileName);
        Scanner s = new Scanner(f);
        int x, y;

        while (s.hasNext()) {
            x = s.nextInt();
            y = s.nextInt();
            System.out.println(x + " " + y);
            alive[x - 1][y - 1] = true;
        }
    }
 
    //applies the rules of The Game of Life to determine which cells will be alive in the next generation
    public void computeNextGeneration() {
        int numNeighbors = 0;
        for (int i = 0; i < numCellsX; i++) {
            for (int j = 0; j < numCellsY; j++) {
                
                numNeighbors = countNeighbors(i, j);

                if (alive[i][j]) { //rules for currently living cells
                    
                    if (numNeighbors <= 1 || numNeighbors >= 4) //if it's too sparse or too crowded, you're dead next round
                        aliveNext[i][j] = false;
                    else 
                        aliveNext[i][j] = true;                   
                }
                
                else if (numNeighbors == 3) //if you're dead now but have 3 living neighbours, you're alive next round
                    aliveNext[i][j] = true;
                
                else 
                    aliveNext[i][j] = false;
            }
        }
    }
    
    //sets the current generation equal to the next generation
    public void plantNextGeneration() {
        for (int i = 0; i < numCellsX; i++) {
            for (int j = 0; j < numCellsY; j++) {
                alive[i][j] = aliveNext[i][j];
            }
        }
    }
    
    //counts the number of living cells adjacent to cell (i, j)
    public int countNeighbors(int i, int j) {
        int count = 0,startRow, startCol,endRow, endCol;

        if (i == 0)
            startCol = i;
        else 
            startCol = i - 1;
        if (i == numCellsX - 1) 
            endCol = i;
        else 
            endCol = i + 1;
        if (j == 0) 
            startRow = j;
        else 
            startRow = j - 1;
        if (j == numCellsY - 1) 
            endRow = j;
        else 
            endRow = j + 1;        

        for (int m = startCol; m <= endCol; m++) {
            for (int n = startRow; n <= endRow; n++) {                
                if (m != i || n != j) {
                    if (alive[m][n]) 
                        count++;                    
                }
            }
        }
        return count;
    }
        
    //draws the current generation of living cells on the screen
    public void paint(Graphics g) {
        int x, y, i, j;
        x = borderWidth;

        drawLabel(g, currGeneration);

        for (i = 0; i < numCellsX; i++) {
            y = borderWidth;
            
            for (j = 0; j < numCellsY; j++) {
                
                if (alive[i][j]) 
                    g.setColor(aliveColor);
                
                else 
                    g.setColor(deadColor);
                
                g.fillRect(x, y, cellSizeX, cellSizeY);
                g.setColor(Color.black);
                g.drawRect(x, y, cellSizeX, cellSizeY);
                
                y += cellSizeY;
            }
            x += cellSizeX;
        }
    }

    //sets up the JFrame screen
    public void initializeWindow() {
        setTitle("Game of Life Simulator");
        setSize(height, width);
        setVisible(true);
    }
       
    //main algorithm
    public static void main(String args[]) throws IOException {
        GameOfLifeSOLUTION currGame = new GameOfLifeSOLUTION();
        currGame.initializeWindow();
        currGame.plantFirstGeneration(); //Sets the initial generation of living cells, either by reading from a file or creating them algorithmically

        for (int i = 1; i <= numGenerations; i++) {
            currGame.repaint();                 //Redraw the grid for the current generation
            currGame.computeNextGeneration();   //Determine which cells will be alive in the next generation
            currGame.plantNextGeneration();     //Set the current generation equal to the new generation  
            currGame.sleep(200);                //Delay 200 milliseconds so the grid doesn't change too quickly for us to see
            currGeneration++;                   //Increment the generation
        }
    }
}