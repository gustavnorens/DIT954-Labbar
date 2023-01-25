import java.awt.*;
/** Subclass of car, represents the Saab 95 */
public class Saab95 extends Car{

    /** turbo of the car */
    private boolean turboOn;

    /** constructor */
    public Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        posX = 0;
        posY = 0;
        dir = Dir.NORTH;
        stopEngine();
    }

    /** turns on the cars turbo */
    private void setTurboOn(){
        turboOn = true;
    }

    /** turns off the cars turbo */
    private void setTurboOff(){
        turboOn = false;
    }

    /** returns the cars speedfactor */
    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}
