package sierpinski;

import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.lang.Thread;

public class Sierpinski extends JPanel {
    
    static int height = 600;
    static int width = 600;
    static int level = 1;
    Color[] colors = {Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW};
    
    
    public void drawSierpinskiFractal(Graphics2D g, int level, Point p1, Point p2, Point p3 ) {
       
        
       g.setColor( Color.BLUE);
        
       if (level == 1) {
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
            g.drawLine(p1.x, p1.y, p3.x, p3.y);
            g.drawLine(p3.x, p3.y, p2.x, p2.y);
            
        } 
        else {
            Point p4 = midpoint(p1, p2);
            Point p5 = midpoint(p2, p3);
            Point p6 = midpoint(p1, p3);

            // recurse on 3 triangular areas
            drawSierpinskiFractal(g, level - 1, p1, p4, p6 );
            drawSierpinskiFractal(g, level - 1, p4, p2, p5 );
            drawSierpinskiFractal(g, level - 1, p6, p5, p3 );
        }
    }

    public static void sleep( int duration ) {
        try {
              Thread.sleep( duration );
            }
        catch (Exception e) {
            }
    }
    
    public static Point midpoint(Point p1, Point p2) {
        return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
    }
    
    
    public void paint( Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        Point A = new Point( width/2, 10 );
        Point B = new Point( 10, height);
        Point C = new Point( width, height );
        
        g2.setColor( Color.BLUE);
        drawSierpinskiFractal( g2, level, A, B, C  );
        
   }
    
    
    public static void main(String[] args) {
        JFrame screen = new JFrame();
        
        screen.add( new Sierpinski() );
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setSize( width, height );
        screen.setVisible(true);
        
        for (int i=0; i<=7; i++) {
            level++;
         
            screen.repaint();
            
            sleep(1000);
        }  
        
    }

}