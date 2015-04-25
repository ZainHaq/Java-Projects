package sierpinski;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.lang.Thread;

public class Sierpinski extends JPanel {
    
    static int height = 999;
    static int width = 999;
    
    static int maximumLevel = 7;
    static boolean animateAllLevelsUpToMaximum = true;
    static int waitTimeBetweenFrames = 1000;
    static int currLevel = 1;
    
    static boolean labelsOn = false;
    static int label = 1;
    
    
    public void drawSierpinskiCarpet( Graphics2D g, int level, Point2 UL, Point2 LR ) {
       g.setColor( Color.yellow);
       
       double widthBig = LR.x - UL.x;
       
       //BASE CASE
       if (level == 1) {
            fillSquare(g, UL, LR, widthBig);
            label++;
        } 
       
        //RECURSIVE CALLS
       else {
            double widthSmall = widthBig / 3;

            //GENERATE THE 16 MIDDLE POINTS            
            double x = UL.x;
            double y = UL.y;            
            Point2[][] middlePoints = new Point2[4][4];
            
            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 4; col++) {
                    middlePoints[row][col] = new Point2(x, y);
                    
                    x = x + widthSmall; 
                }
                x = UL.x;
                y = y + widthSmall;
           }

            //RECURSIVE CALLS ON 8 SMALLER SQUARES
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if ( !(row == 1 && col ==1) ) //all 9 subsquares except for the middle one
                        //System.out.println(row + " " + col);
                       drawSierpinskiCarpet( g, level - 1, middlePoints[row][col], middlePoints[row+1][col+1] );
                }
           }
       }
    }

   
    public static void fillSquare( Graphics g, Point2 p1, Point2 p2, double width ) {
           
           g.fillRect( (int) p1.x, (int) p1.y, (int) width, (int) width );
           g.drawRect( (int) p1.x, (int) p1.y, (int) width, (int) width );
           
           
           //IF LABELS OPTION IS CHOSEN, WRITE THE NUMBER OF THE TRIANGLE AS ITS DRAWN
           if ( labelsOn && currLevel < 7 ) {
                g.setColor(Color.red);
           
                double xLabel = (p1.x + p2.x)/2;
                double yLabel = (p1.y + p2.y)/2;
        
                g.drawString( Integer.toString(label), (int) xLabel, (int) yLabel );
           }
    }
    
    
    public void paint( Graphics g ) {
        
        Graphics2D g2 = (Graphics2D) g;
        
        int padding = 50;
        
        Point2 upperLeft = new Point2( padding, padding );
        Point2 lowerRight = new Point2( width-padding, height-padding );
        
        drawSierpinskiCarpet( g2, currLevel, upperLeft, lowerRight  );     
   }
    
    
    public static void main(String[] args) {
        JFrame screen = new JFrame();
        
        screen.add( new Sierpinski() );
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setBackground(Color.black);
        screen.setSize( width, height );
        screen.setVisible(true);
        
        if ( animateAllLevelsUpToMaximum ) {
            
            for ( int i=1; i < maximumLevel; i++ ) {
                sleep( waitTimeBetweenFrames );
                label = 1;
                screen.repaint();
                currLevel++;
            }  
        }
        
        else
            currLevel = maximumLevel;
   }

    
    public static void sleep( int duration ) {
        try {
              Thread.sleep( duration );
            }
        catch (Exception e) {
            }
    }
}