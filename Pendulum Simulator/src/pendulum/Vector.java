/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendulum;

;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;

/**
 *
 * @author zain
 */


public class Vector {

    double velDirection;
    double centripetalAccelDirection;
    double tangentialAccelDirection;
    double velMagnitude;
    double centripetalAccelMagnitude;
    double tangentialAccelMagnitude;
    double gravityMagnitude;
    double gravityDirection;
    double scale = 2;
    double phi = Math.toRadians(45);
    int barb = 10;
    BasicStroke stroke = new BasicStroke(5);
    Color color;

    public Vector(Color c, double g) {//initializes some fields
        this.color = c;
        this.gravityMagnitude = g;
    }

    public void calculateVelMagnitude(Rope r) { //calculates velocity magnitude
        this.velMagnitude = Math.sqrt(Math.abs(2 * this.gravityMagnitude * r.length * (Math.cos(r.angle) - Math.cos(r.initialAngle)))) * scale;
        calculateVelDirection(r);
    }

    public void calculateVelDirection(Rope r) { //calculates velocity direction
        if (r.angleVel < 0) {
            this.velDirection = Math.PI + r.angle;
        } else {
            this.velDirection = r.angle;
        }

    }

    public void calculateCentripetalAccelMagnitude(Rope r) { //calculates centripetal accel magnitude
        calculateVelMagnitude(r);
        this.centripetalAccelMagnitude = Math.pow(this.velMagnitude, 2) / r.length * scale;
        calculateCentripetalAccelDirection(r);
    }

    public void calculateCentripetalAccelDirection(Rope r) { //calculates centripetal accel direction
        this.centripetalAccelDirection = r.angle;
    }

    public void calculateTangentialAccelMagnitude(Rope r) { //calculates tangential accel magnitude

        this.tangentialAccelMagnitude = r.angleAccel * r.length * scale;
        calculateTangentialAccelDirection(r);
    }

    public void calculateTangentialAccelDirection(Rope r) { //calculates tangential accel direction
        this.tangentialAccelDirection = r.angle;
    }

    public void calculateGravityMagnitude(double g) { //sets gravity magnitude
        updateGravity(g);
        this.gravityMagnitude *= scale;
        calculateGravityDirection();
    }

    public void calculateGravityDirection() { //sets gravity direction
        this.gravityDirection = 0;
    }

    public void updateGravity(double g) {
        this.gravityMagnitude = g;
    }

    public void drawVelVector(Rope r, Graphics2D g) {
        
        g.setColor(color);
        g.setStroke(stroke);
        
        double theta = this.velDirection;
        double mag = this.velMagnitude;
        
        //sets start position
        int x1 = (int) r.xEnd;
        int y1 = (int) r.yEnd;
        
        //calulates end positon
        int x2 = (int) (x1 + mag * (Math.cos(theta)));
        int y2 = (int) (y1 - mag * Math.sin((theta)));

        g.drawLine(x1, y1, x2, y2);
        
        //label for vector
        g.drawString("\u2192", x2, y2 + 15);
        g.drawString("v", x2, y2 + 20);
        
        //needed to draw arrow
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        Point sw = new Point(x2, y2);
        Point ne = new Point(x1, y1);
        g.draw(new Line2D.Double(sw, ne));
        
        drawArrowHead(g, sw, ne);

    }

    

    public void drawCentripetalAccelVector(Rope r, Graphics2D g) {
        
        g.setColor(color);
        g.setStroke(stroke);
        
        double theta = this.centripetalAccelDirection;
        double mag = this.centripetalAccelMagnitude;
        
        int x1 = (int) r.xEnd;
        int y1 = (int) r.yEnd;
        
        int x2 = (int) (x1 - mag * (Math.sin(theta))); 
        int y2 = (int) (y1 - mag * Math.cos((theta)));

        g.drawLine(x1, y1, x2, y2);

        g.drawString("\u2192", x2, y2 + 15);
        g.drawString("ac", x2, y2 + 20);
        
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Point sw = new Point(x2, y2);
        Point ne = new Point(x1, y1);
        
        g.draw(new Line2D.Double(sw, ne));
        
        drawArrowHead(g, sw, ne);
        
    }

    public void drawTangentialAccelVector(Rope r, Graphics2D g) {
        
        g.setColor(color);
        g.setStroke(stroke);
        
        double theta = this.tangentialAccelDirection;
        double mag = this.tangentialAccelMagnitude;
        
        int x1 = (int) r.xEnd;
        int y1 = (int) r.yEnd;

        int x2 = (int) (x1 + mag * (Math.cos(theta))); 
        int y2 = (int) (y1 - mag * Math.sin((theta)));

        g.drawLine(x1, y1, x2, y2);

        g.drawString("\u2192", x2, y2 + 15);
        g.drawString("at", x2, y2 + 20);
        
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        
        Point sw = new Point(x2, y2);
        Point ne = new Point(x1, y1);
        
        g.draw(new Line2D.Double(sw, ne));
        
        drawArrowHead(g, sw, ne);
        
    }

    public void drawGravityVector(Rope r, Graphics2D g) {
        
        g.setColor(color);
        g.setStroke(stroke);
        
        double theta = this.gravityDirection;
        double mag = this.gravityMagnitude;
        
        int x1 = (int) r.xEnd;
        int y1 = (int) r.yEnd;

        int x2 = (int) (x1 + mag * (Math.sin(theta))); 
        int y2 = (int) (y1 - mag * Math.cos((theta)));

        g.drawLine(x1, y1, x2, y2);

        g.drawString("\u2192", x2, y2 + 15);
        g.drawString("g", x2, y2 + 20);
        
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        Point sw = new Point(x2, y2);
        Point ne = new Point(x1, y1);
        
        g.draw(new Line2D.Double(sw, ne));
        
        drawArrowHead(g, sw, ne);
        
    }
    
    private void drawArrowHead(Graphics2D g, Point tip, Point tail) {
        
        g.setColor(this.color);
        
        //calculates change in coordinates from tail to tip
        double dy = tip.y - tail.y;
        double dx = tip.x - tail.x;
        
        //calculates angle of vector
        double theta = Math.atan2(dy, dx);
  
        double x, y;
        double rho = theta + phi;
        
        //need to do twice for left and right arrow
        for (int j = 0; j < 2; j++) {
            x = tip.x - barb * Math.cos(rho);
            y = tip.y - barb * Math.sin(rho);
            g.draw(new Line2D.Double(tip.x, tip.y, x, y));
            rho = theta - phi;
        }
    }

}
