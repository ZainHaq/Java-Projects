

package kochsnowflake; 
import javax.swing.*; 
import java.awt.*; 
import java.util.logging.Level;
import java.util.logging.Logger;
  
public class KochSnowflake extends JFrame { 
      
    static double angle60deg = (Math.PI)/3; 
    static int currLevel=1;
    static int maxLevel=10;
    static int width=700, height=700;
    public void paint(Graphics g) { 
        g.fillRect(0, 0, 800, 800);
        g.setColor(Color.red);
        
        double Ax = width/5;
        double Bx = width - Ax;
        double Cx = (Ax+Bx)/2;
        
        double Ay = 4*height/5;
        double By = Ay;
        double Cy = Ay - (Bx-Ax)*Math.sqrt(3)/2;
       
        
        drawSnowFlake(g, Bx, By, Ax, Ay, currLevel);
        drawSnowFlake(g, Cx, Cy, Bx, By, currLevel);
        drawSnowFlake(g, Ax, Ay, Cx, Cy, currLevel);
        
         
          
    } 
      
    public void drawSnowFlake( Graphics g, double x1,double y1, double x2,double y2,int level) { 
            
            double dx=x2-x1; 
            double dy= y1-y2;
            double length = Math.hypot( dx, dy ); 
            double thirdLength = length/3; 
            double theta = (Math.atan2(dy,dx));
            
             
        //BASE CASE 
        if (level==1) { 
            g.drawLine((int) x1,(int)y1,(int)x2,(int)y2);          
        } 
          
        //RECURSIVE CASE 
        else { 
            
           
            double hor = thirdLength*Math.cos(theta);
            double vert= thirdLength*Math.sin(theta);
            double addAngleCos = thirdLength*Math.cos(theta+angle60deg);;
            double addAngleSin = thirdLength*Math.sin(theta+angle60deg);
            double subAngleCos = thirdLength*Math.cos(angle60deg-theta);
            double subAngleSin = thirdLength*Math.sin(angle60deg-theta);
            double x3=x1+hor;
            double y3=y1-vert;
            
            drawSnowFlake(g, x1,y1,x3,y3,level-1);
            drawSnowFlake(g, x3,y3,x3+(addAngleCos),y3-(addAngleSin),level-1);      
            drawSnowFlake(g, x3+(addAngleCos),y3-(addAngleSin),x3+(addAngleCos) +(subAngleCos) ,y3-(addAngleSin) + (subAngleSin),level-1);
            drawSnowFlake(g, x3+hor ,y3-vert, x3+hor+hor,y3-vert-vert,level-1);  
        } 
    } 

    public static void main(String[] args) { 
        KochSnowflake k = new KochSnowflake(); 
        k.setSize(800,800);  
        k.setBackground(Color.black); 
        k.setDefaultCloseOperation(EXIT_ON_CLOSE);
        k.setVisible(true); 
        for (int i = 1; i <maxLevel; i++) {
            sleep(500);
            currLevel++;     
            k.repaint();
        }
    } 
    public static void sleep(int t){
        try {
            Thread.sleep(t);
        } catch (InterruptedException ex) {
            Logger.getLogger(KochSnowflake.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
} 
