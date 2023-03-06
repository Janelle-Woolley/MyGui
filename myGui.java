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
}
