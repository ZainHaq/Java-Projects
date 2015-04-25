

package mandelbrotset;
import javax.swing.JFrame;//needed for graphics
import java.awt.*;//needed for graphics
import static javax.swing.JFrame.EXIT_ON_CLOSE;//needed for graphics
import java.util.*;//needed for reading file
import java.io.*;//needed for reading file

public class MandelbrotSet extends JFrame{
    //Global Variables
    int height=800;
    int width=800;
    double xMin;
    double xMax;
    double yMin;
    double yMax;
    double xCartesian;
    double yCartesian;
    int maxIterations;

    public void initializeWindow() {
        setTitle("Mandelbrot Set");
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        setVisible(true);
    }
    
    public void paint(Graphics g) {
             double xScale=(xMax - xMin)/width;
             double yScale=(yMax - yMin) /height;
        for (int xScreen = 0; xScreen < width; xScreen++) {
            //determines the real part of a complex number based on which pixel on the screen it is checking
            xCartesian = xScale*(xScreen) + xMin;
            for (int yScreen = 0; yScreen < height; yScreen++) {
                //determines the imaginary part of a complex number based on which pixel on the screen it is checking
                yCartesian = yMax - yScale* (yScreen);   
                
                //basicPattern(g, xCartesian, yCartesian); //simple booean algorithim
                coolPattern(g, xCartesian, yCartesian); //integer based algorithim

                g.drawLine(xScreen, yScreen, xScreen + 1, yScreen + 1);// draws a pixel
            }
        }
    }
    public void basicPattern(Graphics g, double x,double y){
        if(isInMs(new Complex(x,y))){//if its in the set, sets the color to red
                    g.setColor(Color.RED);                 
                }
                else{
                     g.setColor(Color.WHITE);
                }
    }
    public void coolPattern(Graphics g, double x,double y){//determines colour based on escapeVal
       int escapeVal = determineEscapeVal(new Complex(x,y));//the value at which the point escapes the set
       //Note: As you increase the exponent the shape of the Mandelbrot set gets less defined
       int mix = (int) 100*escapeVal%255;//creates wave pattern
       Color color = new Color(mix,0,mix);   
       g.setColor(color);
       
    }
   
    public boolean isInMs(Complex C) {//just determines whether it is in the Mandelbrot Set
        int countIterations = 0;
        Complex Z = C;
        while (Z.absoluteSquared() < 4) {//more efficient 
            countIterations++;
            Z = (Z.exponent(2)).add(C);
            if (countIterations >= maxIterations) {//ensures that numbers that do not escape the set aren't stuck in an infinite loop
                return true;
            }
        }
        return false;

    }
    public int determineEscapeVal(Complex C) {//determines how close a certain complex number was to escaping
        Complex Z = C;
        for (int iterations = 0; iterations <= maxIterations; iterations++) {
            Z = (Z.exponent(2)).add(C);
            if (Z.absoluteSquared() > 4) {//determines at which iteration it escapes the set
                return iterations;
            }
        }
        return maxIterations;
    }
    public void readFile() throws IOException{//reads all required data from file
        Scanner in = new Scanner(new FileReader("Mandelbrot Inputs.txt"));
        xMin=in.nextDouble();
        xMax=in.nextDouble();
        yMin=in.nextDouble();
        yMax=in.nextDouble();
        maxIterations=in.nextInt();
    }
    
    public static void main(String[] args) throws IOException {
        MandelbrotSet set = new MandelbrotSet();
        set.readFile();
        set.initializeWindow();       
    }

}
