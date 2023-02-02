import java.awt.*;

public class Scania extends Vehicle implements ITrailer{
    private double trailerTilt;

    /** constructor for Scania */
    public Scania(){
        nrDoors = 2;
        color = Color.white;
        enginePower = 100;
        modelName = "Scania";
        posX = 0;
        posY = 0;
        dir = Dir.NORTH;
        trailerTilt = 0;
        stopEngine();
        length = 2100;
        width = 250;
        height = 300;
    }

    /** Increases the trailer tilt by a chosen amount of degrees */
    public void increaseTrailerTilt(double deg){
       if (currentSpeed == 0 && deg >= 0) {
           if (deg + trailerTilt > 70) {
               trailerTilt = 70;
               return;
           }
           trailerTilt += deg;
       }
    }

    /** decreaseTrailerTilt will increase the tilt by the chosen amount in degrees with a double */     /** decreases the trailer tilt a chosen amount of degrees */
    public void decreaseTrailerTilt(double deg){
        if (currentSpeed == 0 && deg >= 0) {
            if (trailerTilt - deg < 0) {
                trailerTilt = 0;
                return;
            }
            trailerTilt -= deg;
        }
    }

    /** Returns the current trailer tilt */
    public double getTrailerTilt(){
        return trailerTilt;
    }

    @Override
    public boolean canDrive() {
        if (trailerTilt > 0) {
            return false;
        }
        return true;

    }

    @Override
    public void changeTilt() {

    }
}
