package pendulum;
//all the imports needed
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author zain
 */
public class Pendulum extends JPanel implements ItemListener, ChangeListener, ActionListener {
    //Global Variables
    static int winWidth = 1000;
    static int winHeight = 575;
    
    static int whiteBoxXPos = winWidth - 225; //starting position of the whitbox containing all the buttons
    static int whiteBoxYPos = 10;
    
    static double pivotStartPosX = (whiteBoxXPos) / 2; //starting postion of the pivot
    static double pivotStartPosY = (winHeight - whiteBoxYPos) / 2 - 50;
    
    static double startingAngle = Math.PI / 2; //angle is measured from imaginary vertical line along the pivot
    static double ropeLength = 50; 
    static double ballRadius = 10; 
    static double gravitationalConstant = -9.81; 
    static double deltaTime = 0.1; //controls the speed of the animation
    static double dampingConstant = 0; //controls the affect of friction
    
    //Components of the pendulum
    static Ball pivot = new Ball(pivotStartPosX, pivotStartPosY, 5, Color.white);
    static Rope rope = new Rope(pivot, startingAngle, ropeLength, Color.white, dampingConstant);        
    static Ball ball = new Ball(rope.xEnd, rope.yEnd, ballRadius, Color.white);
    
    //Vectors
    static Vector velocity = new Vector(Color.RED, gravitationalConstant);
    static Vector centripetalAccel = new Vector(Color.YELLOW, gravitationalConstant);
    static Vector tangentialAccel = new Vector(Color.ORANGE, gravitationalConstant);
    static Vector gravity = new Vector(Color.GREEN, gravitationalConstant);
    
    //Energy Levels
    static Energy potentialEnergy = new Energy(ball, Color.magenta, gravitationalConstant);
    static Energy kineticEnergy = new Energy(ball, Color.BLUE, gravitationalConstant);
    static Energy heatEnergy = new Energy(ball, Color.PINK, gravitationalConstant);
    
    //Buttons
    static JButton resetButton = new JButton("Reset");    
    static JButton sButton; //pause/play button
    
    //Sliders with corresponding labels
    static JSlider frictionSlider;
    static JLabel fsLabel;
    static JSlider massSlider;
    static JLabel msLabel;
    static JSlider lengthSlider;
    static JLabel lsLabel;
    static JSlider angleSlider;
    static JLabel asLabel;

    //Radiobuttons
    static JRadioButton gEarth;
    static JRadioButton gMoon;
    static JRadioButton gJupiter;
    static JRadioButton gPlanetX;
    static JRadioButton g0;
    
    //ButtonGroup of the radiobuttons
    static ButtonGroup gButtons;
    
    //Checkboxes
    static JCheckBox vVector;
    static JCheckBox acVector;
    static JCheckBox atVector;
    static JCheckBox gVector;
    static JCheckBox potenNRGLevel;
    static JCheckBox kenNRGLevel;
    
    //booleans asscoiated with the state of the checkboxes
    static boolean showVel;
    static boolean showCentripAccel;
    static boolean showTanAccel;
    static boolean showGravity;
    static boolean showGPE;
    static boolean showKE;
    
    //boolean needed to stop and start the swing
    static boolean running = true;
    
    //Custom color, personal preference
    Color lightBlue = new Color(0, 220, 255);
    
    //Custom font, personal preference
    Font customFont = new Font("GothamNarrow-Light", Font.PLAIN, 16);
    
    //Icons for the pause/play button
    ImageIcon playIcon = new ImageIcon("play.png");
    ImageIcon pauseIcon = new ImageIcon("pause.png");

    public Pendulum() {
        setLayout(null); //needed to set positions of the buttons
        
        //Registering my custom font
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("GothamNarrow-Light.otf")));
        } catch (IOException | FontFormatException e) {

        }
        
        //Formatting following buttons with this layout using an external library
        try { 
        UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel"); 
        } catch(Exception e){ 
        }
        
        //Setting up Sliders and correspoding labels
        //Angle slider/label
        asLabel = new JLabel("Angle(°)");
        asLabel.setForeground(Color.GRAY);
        asLabel.setFont(customFont);
        asLabel.setBounds(whiteBoxXPos + 75, whiteBoxYPos + 25, 100, 20);
        add(asLabel);
        angleSlider = new JSlider(JSlider.HORIZONTAL, -180, 180, 90);
        add(angleSlider);
        angleSlider.addChangeListener(this); //needed to detect changes in the state of the slider
        angleSlider.setBounds(whiteBoxXPos + 25, whiteBoxYPos + 45, 150, 20);
        angleSlider.setBackground(Color.white);
        
        //Mass slider/label
        msLabel = new JLabel("Mass(kg)");
        msLabel.setForeground(Color.GRAY);
        msLabel.setFont(customFont);
        msLabel.setBounds(whiteBoxXPos + 70, whiteBoxYPos + 65, 100, 20);
        add(msLabel);
        massSlider = new JSlider(JSlider.HORIZONTAL, 10, 100, 10);
        add(massSlider);
        massSlider.setBackground(Color.white);
        massSlider.addChangeListener(this);
        massSlider.setBounds(whiteBoxXPos + 25, whiteBoxYPos + 85, 150, 20);

        //Length slider/label
        lsLabel = new JLabel("Length(m)");
        lsLabel.setForeground(Color.GRAY);
        lsLabel.setBounds(whiteBoxXPos + 65, whiteBoxYPos + 110, 100, 20);
        lsLabel.setFont(customFont);
        add(lsLabel);
        lengthSlider = new JSlider(JSlider.HORIZONTAL, 50, 300, 50);
        add(lengthSlider);
        lengthSlider.setBackground(Color.white);
        lengthSlider.addChangeListener(this);
        lengthSlider.setBounds(whiteBoxXPos + 25, whiteBoxYPos + 125, 150, 20);

        //Friction slider/label
        fsLabel = new JLabel("Friction");
        fsLabel.setForeground(Color.GRAY);
        fsLabel.setFont(customFont);
        fsLabel.setBounds(whiteBoxXPos + 75, whiteBoxYPos + 150, 100, 20);
        add(fsLabel);
        frictionSlider = new JSlider(JSlider.HORIZONTAL, 0, 50000, 0);
        add(frictionSlider);
        frictionSlider.addChangeListener(this);
        frictionSlider.setBounds(whiteBoxXPos + 25, whiteBoxYPos + 165, 150, 20);
        frictionSlider.setBackground(Color.white);

        //Formatting following buttons with this layout using an external library
        try { 
        UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel"); 
        } catch(Exception e){ 
        }
        
        //Setting up the vector checkboxe
        //Velocity vector checkbox
        vVector = new JCheckBox("Velocity Vector");
        add(vVector);
        vVector.addItemListener(this); //needed to detect change in state of button
        vVector.setFont(customFont);
        vVector.setBounds(whiteBoxXPos + 25, whiteBoxYPos + 195, 150, 20);
        vVector.setForeground(Color.GRAY);
        vVector.setBackground(Color.white);
        vVector.setDoubleBuffered(true);
        
        //Centripetal acceleration vector checkbox
        acVector = new JCheckBox("Centripetal Accel");
        add(acVector);
        acVector.setBounds(whiteBoxXPos + 25, whiteBoxYPos + 215, 150, 20);
        acVector.setForeground(Color.GRAY);
        acVector.addItemListener(this);
        acVector.setBackground(Color.white);
        acVector.setFont(customFont);
        
        //Tangential acceleration vector checkbox
        atVector = new JCheckBox("Tangential Accel");
        atVector.setBackground(Color.white);
        add(atVector);
        atVector.addItemListener(this);
        atVector.setBounds(whiteBoxXPos + 25, whiteBoxYPos + 235, 150, 20);
        atVector.setForeground(Color.GRAY);
        atVector.setFont(customFont);
        
        //Gravity vector checkbox
        gVector = new JCheckBox("Gravity Vector");
        add(gVector);
        gVector.addItemListener(this);
        gVector.setBounds(whiteBoxXPos + 25, whiteBoxYPos + 255, 150, 20);
        gVector.setBackground(Color.white);
        gVector.setForeground(Color.GRAY);
        gVector.setFont(customFont);
        
        //Potentinal energy check box
        potenNRGLevel = new JCheckBox("GPE Levels");
        add(potenNRGLevel);
        potenNRGLevel.addItemListener(this);
        potenNRGLevel.setBackground(Color.white);
        potenNRGLevel.setFont(customFont);
        potenNRGLevel.setBounds(whiteBoxXPos + 25, whiteBoxYPos + 275, 150, 20);
        potenNRGLevel.setForeground(Color.GRAY);
        
        //Kenetic energy check box
        kenNRGLevel = new JCheckBox("KE Levels");
        add(kenNRGLevel);
        kenNRGLevel.setBackground(Color.white);
        kenNRGLevel.setBounds(whiteBoxXPos + 25, whiteBoxYPos + 295, 150, 20);
        kenNRGLevel.setForeground(Color.GRAY);
        kenNRGLevel.setFont(customFont);
        kenNRGLevel.addItemListener(this);
        
        //Setting up the Radio Buttons
        //Earth gravity button
        gEarth = new JRadioButton("Earth", true);
        gEarth.setActionCommand("Earth"); //needed to detect if this button is selected
        gEarth.setFont(customFont);
        gEarth.setBackground(Color.white);
        gEarth.setBounds(whiteBoxXPos + 25, whiteBoxYPos + 325, 100, 20);
        gEarth.setForeground(Color.GRAY);
        gEarth.addActionListener(this);
        add(gEarth);
        
        //Moon gravity button
        gMoon = new JRadioButton("Moon", false);
        gMoon.setActionCommand("Moon");
        gMoon.setBackground(Color.white);
        gMoon.setFont(customFont);
        gMoon.setBounds(whiteBoxXPos + 25, whiteBoxYPos + 345, 100, 20);
        gMoon.setForeground(Color.GRAY);   
        gMoon.addActionListener(this);
        add(gMoon);
        
        //Jupiter gravity button
        gJupiter = new JRadioButton("Jupiter", false);
        gJupiter.setActionCommand("Jupiter");
        gJupiter.setBounds(whiteBoxXPos + 25, whiteBoxYPos + 365, 100, 20);
        gJupiter.setBackground(Color.white);
        gJupiter.setForeground(Color.GRAY);
        gJupiter.setFont(customFont);
        gJupiter.addActionListener(this);
        add(gJupiter);
        
        //PlanetX gravity button
        gPlanetX = new JRadioButton("PlanetX", false);
        gPlanetX.setActionCommand("PlanetX");
        gPlanetX.setBounds(whiteBoxXPos + 25, whiteBoxYPos + 385, 100, 20);
        gPlanetX.setForeground(Color.GRAY);
        gPlanetX.setBackground(Color.white);
        gPlanetX.setFont(customFont);
        gPlanetX.addActionListener(this);
        add(gPlanetX);
        
        //Zero gravity button
        g0 = new JRadioButton("g=0", false);
        g0.setActionCommand("g=0");
        g0.setFont(customFont);
        g0.setBounds(whiteBoxXPos + 25, whiteBoxYPos + 405, 100, 20);
        g0.setForeground(Color.GRAY);
        g0.setBackground(Color.white);
        g0.addActionListener(this);
        add(g0);
        
        //Adding the radiobuttons to a ButtonGroup
        //Only allows one button to be selected at a time
        gButtons = new ButtonGroup();
        gButtons.add(gEarth);
        gButtons.add(gMoon);
        gButtons.add(gJupiter);
        gButtons.add(gPlanetX);
        gButtons.add(g0);

        //Setting up the resetButton
        resetButton.setVerticalTextPosition(AbstractButton.CENTER);
        resetButton.setHorizontalTextPosition(AbstractButton.LEADING); 
        resetButton.setActionCommand("Reset"); //needed to detect changes in state
        resetButton.setBounds(whiteBoxXPos + 25, whiteBoxYPos + 445, 150, 40);
        resetButton.addActionListener(this);
        add(resetButton);

        //Setting up pause/play button
        sButton = new JButton(pauseIcon);
        sButton.setVerticalTextPosition(AbstractButton.CENTER);
        sButton.setHorizontalTextPosition(AbstractButton.LEADING);
        sButton.setActionCommand("Start/Stop");
        sButton.setBounds((int) pivot.xPos - 15, winHeight - 100, 30, 30);
        sButton.addActionListener(this);
        add(sButton);
                      
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Pendulum Simulator");
        Pendulum p = new Pendulum();
        f.add(p);
        f.setSize(winWidth, winHeight);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.swing(); //calls swing() method
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D G = (Graphics2D) g;
        super.paintComponent(g); //clears the screen
        Image img = createImageWithText(); //creates an image of the screen
        g.drawImage(img, 0, 0, this);//to prevent flickering
    }

    private Image createImageWithText() {
        BufferedImage bufferedImage = new BufferedImage(winWidth, winHeight, BufferedImage.TYPE_INT_RGB); //prevents flickering      
        Graphics g = bufferedImage.getGraphics();
        Graphics2D G = (Graphics2D) g;
        
        //sets the background to custom colour
        G.setColor(lightBlue);
        G.fillRect(0, 0, winWidth, winHeight);
        
        //makes the whitebox that contains all the buttons
        G.setColor(Color.white);
        G.fillRoundRect(winWidth - 225, 10, 200, winHeight - 55, 20, 20);
        
        //sets the endpostion of the rope before painting it
        rope.setEndPosition();
        ball.updatePosition(rope); //update based on rope
        
        //Draws all components
        pivot.drawBall(g);
        rope.drawRope(G);
        ball.drawBall(g);
        
        //checks to see if the checkboxes have been selected, if so display
        if (showVel) {
            velocity.drawVelVector(rope, G);
        }
        if (showCentripAccel) {
            centripetalAccel.drawCentripetalAccelVector(rope, G);
        }
        if (showTanAccel) {
            tangentialAccel.drawTangentialAccelVector(rope, G);
        }
        if (showGravity) {
            gravity.drawGravityVector(rope, G);
        }
        if (showGPE) {
            potentialEnergy.drawGPELevel(G, winWidth, winHeight);
        }
        if (showKE) {
            kineticEnergy.drawKELevel(G, winWidth, winHeight);
        }

        return bufferedImage;
    }

    public void resetVariables() { //resets the variables to their initial conditions
        startingAngle = Math.PI / 2; 
        ropeLength = 50; 
        ballRadius = 10;  
        gravitationalConstant = -9.81; 
        deltaTime = 0.1; 
        dampingConstant = 0;
        
        pivot = new Ball(pivotStartPosX, pivotStartPosY, 5, Color.white);
        rope = new Rope(pivot, startingAngle, ropeLength, Color.white, dampingConstant);
        ball = new Ball(rope.xEnd, rope.yEnd, ballRadius, Color.white);
        
        velocity = new Vector(Color.RED, gravitationalConstant);
        centripetalAccel = new Vector(Color.YELLOW, gravitationalConstant);
        tangentialAccel = new Vector(Color.ORANGE, gravitationalConstant);
        gravity = new Vector(Color.GREEN, gravitationalConstant);
        
        potentialEnergy = new Energy(ball, Color.magenta, gravitationalConstant);
        kineticEnergy = new Energy(ball, Color.BLUE, gravitationalConstant);

    }

    public void swing() { //Main algorithim
        while (true) { //infinite loop
            if (running) {
                rope.updateAngle(gravitationalConstant, deltaTime, ball); //updates angle of the pendulum
            }
            //Calculations for vectors
            velocity.calculateVelMagnitude(rope);
            centripetalAccel.calculateCentripetalAccelMagnitude(rope);
            tangentialAccel.calculateTangentialAccelMagnitude(rope);
            gravity.calculateGravityMagnitude(gravitationalConstant);
            
            //Calculations for energy levels
            potentialEnergy.calculateGPE(rope, ball);
            kineticEnergy.calculateKE(rope, ball);
            
            repaint();
            sleep(10);
        }
    }

    public void sleep(int duration) { //stops thread for a certain amount of time
        try {
            Thread.sleep(duration);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pendulum.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setVariables() { //sets variables based on what the user sets them to
        startingAngle = rope.initialAngle; 
        ropeLength = rope.length; 
        ballRadius = ball.radius;  
        deltaTime = 0.1; 
        dampingConstant = rope.dampingConstant;
        
        pivot = new Ball(pivotStartPosX, pivotStartPosY, 5, Color.white);
        rope = new Rope(pivot, startingAngle, ropeLength, Color.white, dampingConstant);
        ball = new Ball(rope.xEnd, rope.yEnd, ballRadius, Color.white);
        
        velocity = new Vector(Color.RED, gravitationalConstant);
        centripetalAccel = new Vector(Color.YELLOW, gravitationalConstant);
        tangentialAccel = new Vector(Color.ORANGE, gravitationalConstant);
        gravity = new Vector(Color.GREEN, gravitationalConstant);
        
        potentialEnergy = new Energy(ball, Color.magenta, gravitationalConstant);
        kineticEnergy = new Energy(ball, Color.BLUE, gravitationalConstant);
    }

    public void actionPerformed(ActionEvent e) { //checks state of buttons
        if ("Reset".equals(e.getActionCommand())){ //if pressed....do the following
            running = true;
            
            //resets the sliders
            frictionSlider.setValue(0);
            massSlider.setValue(10);
            lengthSlider.setValue(50);
            angleSlider.setValue(90);
            
            //resets the radiobuttons
            gButtons.clearSelection();
            gEarth.setEnabled(true);
            
            //resets all checkboxes
            vVector.setSelected(false);
            acVector.setSelected(false);
            atVector.setSelected(false);
            gVector.setSelected(false);           
            potenNRGLevel.setSelected(false);
            kenNRGLevel.setSelected(false);
            
            //resets variables
            resetVariables();

        }
        if ("Start/Stop".equals(e.getActionCommand())) {
            if (running) { //changes icon based on its state
                running = false;
                sButton.setIcon(playIcon);
            } else {
                running = true;
                sButton.setIcon(pauseIcon);
            }
        }
        
        //sets gravity for different planets
        if ("Earth".equals(e.getActionCommand())) {
            gravitationalConstant = -9.81;
            setVariables();
        }
        if ("Moon".equals(e.getActionCommand())) {
            gravitationalConstant = -1.62;
            setVariables();
        }
        if ("Jupiter".equals(e.getActionCommand())) {
            gravitationalConstant = -24.79;
            setVariables();
        }
        if ("PlanetX".equals(e.getActionCommand())) {
            gravitationalConstant = -100;
            setVariables();
        }
        if ("g=0".equals(e.getActionCommand())) {
            gravitationalConstant = 0;
            setVariables();
        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        //sets to value of slider
        int fsValue = frictionSlider.getValue();
        int msValue = massSlider.getValue();
        int lsValue = lengthSlider.getValue();
        int asValue = angleSlider.getValue();
        
        //assigns variables to those slider values
        ball.radius = msValue;
        rope.length = lsValue;
        rope.initialAngle = Math.toRadians(asValue);
        rope.dampingConstant = fsValue;
        
        //sets variables based on the new valuse
        setVariables();
       
        //disables all checkboxes if friction is selected
        //haven't been optimized for friction
        if (fsValue != 0) {
            vVector.setEnabled(false);
            acVector.setEnabled(false);
            atVector.setEnabled(false);
            gVector.setEnabled(false);
            vVector.setSelected(false);
            acVector.setSelected(false);
            atVector.setSelected(false);
            gVector.setSelected(false);
            potenNRGLevel.setEnabled(false);
            kenNRGLevel.setEnabled(false);
            potenNRGLevel.setSelected(false);
            kenNRGLevel.setSelected(false);
        } else {
            vVector.setEnabled(true);
            acVector.setEnabled(true);
            atVector.setEnabled(true);
            gVector.setEnabled(true);
            potenNRGLevel.setEnabled(true);
            kenNRGLevel.setEnabled(true);
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //checks to see if the check box is selected
        if (vVector.isSelected()) {
            showVel = true;
        } else {
            showVel = false;
        }

        if (acVector.isSelected()) {
            showCentripAccel = true;
        } else {
            showCentripAccel = false;
        }

        if (atVector.isSelected()) {
            showTanAccel = true;
        } else {
            showTanAccel = false;
        }

        if (gVector.isSelected()) {
            showGravity = true;
        } else {
            showGravity = false;
        }

        if (potenNRGLevel.isSelected()) {
            showGPE = true;
        } else {
            showGPE = false;
        }

        if (kenNRGLevel.isSelected()) {
            showKE = true;
        } else {
            showKE = false;
        }
    }

}


