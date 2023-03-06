import ecs100.*;
import java.awt.Color;
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
    /**
     * Constructor for objects of class myGui
     */
    public myGui()
    {
        // initialise instance variables
        speed = 0;
        
        // set up some buttons
        UI.addButton("Quit", UI::quit);
        
        // set up slider
        UI.addSlider("Speed", 0, 100, 20, this::setSpeed);
        
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
        if (action.equals("pressed")){
            this.startX = x;
            this.startY = y;
        } else if (action.equals("released")){
            UI.drawLine(this.startX, this.startY, x, y);
        }
    }
}
