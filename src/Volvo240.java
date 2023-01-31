import java.awt.*;
/** Subclass of car, represents the 240 */
public class Volvo240 extends Car{

    /** the trimfactor of the car */
    private final static double trimFactor = 1.25;

    /** constructor */
    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        posX = 0;
        posY = 0;
        dir = Dir.NORTH;
        stopEngine();
        length = 478;
        width = 171;
        height = 143;
    }

    /** returns the cars speedfactor */
    @Override
    protected double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}
