import ecs100.*;
import java.awt.Color;
import javax.swing.JColorChooser;
/**
 * making some sliders and responing to mouse events
 *
 * @author Janelle Woolley
 * @version 1.0 07/03/2023
 */
public class myGui
{
    // instance variables - replace the example below with your own
    private double speed;
    
    // feilds to remeber the "pressed" postion
    private double startX, startY;
    
    // remember the colour
    private Color currentColor = Color.black;
    
    // remembers the line size
    private double size;
    
    // circle or rectangle button
    private boolean circle = true; 
    /**
     * Constructor for objects of class myGui
     */
    public myGui()
    {
        // initialise instance variables
        speed = 0;
        
        // set up some buttons
        UI.addButton("Quit", UI::quit);
        
        // button clears canvas
        UI.addButton("Clear Canvas", this::clearCanvas);
        
        // colour buttons
        UI.addButton("Colour", this::chooseColour);
        UI.addButton("Random Colour", this::changeColour);
        
        // circle or rectangle button
        UI.addButton("Switch Shape", this::switchShape);
        
        // set up slider
        UI.addSlider("Speed", 0, 100, 20, this::setSpeed);
        UI.addSlider("Line Size", 1, 21, 10, this::setSize);
        
        // set up mouse listener
        UI.setLineWidth(10);
        UI.setMouseListener(this::doMouse);
    }
    
    /**
     * Callback method for speed slider
     */
    public void setSpeed(double km) {
        // check if it is greater or less than last speed
        if(speed < km) {
            UI.println("Accelerating");
        } else if (speed > km){
            UI.println("Decelerating");
        } else {
            UI.println("Stationary");
        }
        
        // set the speed to the new speed
        this.speed = km;
    }
    
    /**
     * Callback method to mouse listener
     * only make one callback method to the mouse listener
     */
    public void doMouse(String action, double x, double y) {
        double width = 50;
        double height = 50;
        if (action.equals("clicked")) {
            if (circle == true){
                UI.fillOval(x-width/2, y-height/2, width, height);
            } else{
                UI.fillRect(x-width/2, y-height/2, width, height);
            }
        } else if (action.equals("released")) {
            UI.drawLine(this.startX, this.startY, x, y);
        } else if (action.equals("pressed")) {
            this.startX = x;
            this.startY = y;
        }
    }
    
    /**
     * change to random colour
     */
    public void changeColour() {
        this.currentColor = new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
        UI.setColor(this.currentColor);
    }
    
    /**
     * allows a user to choose a colour using the swing library
     */
    public void chooseColour() {
        this.currentColor = JColorChooser.showDialog(null, "Choose Colour", this.currentColor);
        UI.setColor(this.currentColor);
    }
    
    /**
     * callback method for slider to change the line size
     */
    public void setSize(double lineSize) {
        this.size = lineSize;
        UI.setLineWidth(this.size);
    }
    
    /**
     * callback method for switch shape button
     */
    public void switchShape() {
        if (this.circle == true){
            this.circle = false;
        } else {
            this.circle = true;
        }
    }
    
    /**
     * callback method for clear canvas button
     */
    public void clearCanvas() {
        UI.setColor(Color.white);
        UI.fillRect(0, 0, 10000000, 10000000);
        UI.setColor(this.currentColor);
    }
}
