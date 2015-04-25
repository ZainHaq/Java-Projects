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
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

/**
 *
 * @author zain
 */
public class Energy {

    double GPE;
    double KE;
    double height;
    double velocity;
    double mass;
    double gravity;
    double scale = 0.005;
    Color color;
    BasicStroke stroke = new BasicStroke(20);

    public Energy(Ball b, Color c, double g) { //initialzes some fields
        this.mass = b.mass;
        this.gravity = -g;
        this.color = c;
    }

    public void calculateGPE(Rope r, Ball b) { //calulates GPE
        updateMass(b);
        this.height = r.length * (1 - Math.cos(r.angle));
        this.GPE = this.mass * this.gravity * this.height;
    }

    public void calculateKE(Rope r, Ball b) { //calulates KE
        updateMass(b);
        this.velocity = Math.sqrt(Math.abs(2 * this.gravity * r.length * (Math.cos(r.angle) - Math.cos(r.initialAngle))));
        this.KE = 0.5 * this.mass * Math.pow(this.velocity, 2);
    }

    public void updateMass(Ball b) {
        this.mass = b.mass;
    }

    public void drawGPELevel(Graphics2D g, int width, int height) { //draw GPE relative to window
        g.setColor(color);
        g.setStroke(stroke);

        g.drawLine(50, height - 100, 50, height - 100 - (int) (this.GPE * scale));
        g.drawString("GPE", 40, height - 75);
    }

    public void drawKELevel(Graphics2D g, int width, int height) { //draw KE relative to window
        g.setColor(color);
        g.setStroke(stroke);

        g.drawLine(100, height - 100, 100, height - 100 - (int) (this.KE * scale));
        g.drawString("KE", 90, height - 75);
    }
    
}
