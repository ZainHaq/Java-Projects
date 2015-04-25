/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendulum;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author zain
 */
public class Rope {

    double xStart, yStart;
    double xEnd, yEnd;
    double initialAngle;
    double angle;
    double angleVel;
    double angleAccel;
    double length;
    double dampingConstant;
    Color color;
    BasicStroke stroke;

    public Rope(Ball b, double a, double l, Color c, double d) { //initializes fields
        this.xStart = b.xPos;
        this.yStart = b.yPos;
        this.initialAngle = a;
        this.angle = a;
        this.color = c;
        this.length = l;
        this.dampingConstant = d;
        stroke = new BasicStroke(3);

    }

    public void setEndPosition() { //sets end postion based on the angle
        this.xEnd = this.xStart + this.length * Math.sin(this.angle);
        this.yEnd = this.yStart + this.length * Math.cos(this.angle);
    }

    public void calculateAccelAngle(double g, Ball b) { //calulate angular acceleration with friction
        this.angleAccel = (g / this.length) * Math.sin(this.angle) + ((-this.dampingConstant / (b.mass * Math.pow(this.length, 2)) * this.angleVel));
    }

    public void calculateVelAngle(double g, double t, Ball b) { //calulate angular velocity
        calculateAccelAngle(g, b);
        this.angleVel += this.angleAccel * t;
    }

    public void updateAngle(double g, double t, Ball b) { //calculates updated angle
        calculateVelAngle(g, t, b);
        this.angle += this.angleVel * t;
    }

    public void drawRope(Graphics2D g) { //draws rope based on starting and ending positions
        g.setStroke(this.stroke);
        g.setColor(this.color);
        g.drawLine((int) this.xStart, (int) this.yStart, (int) this.xEnd, (int) this.yEnd);
    }
    
}
