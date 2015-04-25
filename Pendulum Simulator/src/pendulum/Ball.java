/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendulum;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author zain
 */
public class Ball {

    double xPos, yPos;
    double radius;
    double mass;
    double diameter;
    Color color;

    public Ball(double x, double y, double r, Color c) { //initializes some fields
        this.xPos = x;
        this.yPos = y;
        this.radius = r;
        this.diameter = this.radius * 2;
        this.color = c;
        this.mass = this.diameter;
    }

    public void updatePosition(Rope r) { //updates position based on the endposition of the rope
        this.xPos = r.xEnd;
        this.yPos = r.yEnd;
    }

    public void updateDiameterAndMass() { //updates mass and diamter
        this.diameter = this.radius * 2;
        this.mass = this.diameter;
    }

    public void drawBall(Graphics g) { //draws ball based on the raidus,xPos,yPos and diameter
        updateDiameterAndMass();
        g.setColor(this.color);
        g.fillOval((int) (this.xPos - this.radius), (int) (this.yPos - this.radius), (int) this.diameter, (int) this.diameter);
    }
}
