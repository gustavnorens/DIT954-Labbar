
import java.awt.*;

/** Car super-class */
public abstract class Vehicle implements Movable {

    /** Current direction of the of car */
    protected Dir dir;

    /** Width, Height, and length of the Car-Object */
    protected double length, width, height;
    /** Number of doors on the car */

    protected int nrDoors;


    /** Engine power of the car */
    protected double enginePower;

    /** The current speed of the car */
    protected double currentSpeed;

    /** Color of the car */
    protected Color color;

    /** The car model name */
    protected String modelName;

    /** X position in the 2d plane */
    protected double posX;

    /** Y position in the 2d plane */
    protected double posY;

    /** return the height of the car */
    public double getHeight() {
        return height;
    }

    /** returns the length of the car */
    public double getLength() {
        return length;
    }

    /** returns the width of the car */
    public double getWidth() {
        return width;
    }

    /** returns the number of doors of the cars */
    public int getNrDoors(){
        return nrDoors;
    }

    /** return the engine power of the car */
    public double getEnginePower(){
        return enginePower;
    }

    /** returns the current speed of the car */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /** returns the color of the car */
    public Color getColor(){
        return color;
    }

    /** sets the color of the car */
    public void setColor(Color clr){
        color = clr;
    }

    /** sets the cars current speed to 0.1*/
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /** sets the cars currentspeed to 0 */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /** returns the x position of the car */
    public double getPosX(){
        return posX;
    }

    /** returns the y position of the car */
    public double getPosY(){
        return posY;
    }
    /** returns the current direction of the car */
    public Dir getDir() {
        return dir;
    }

    /** moves the car by the current speed in its current direction*/
    @Override
    public void move(){
        switch (dir) {
            case NORTH -> posY += currentSpeed;
            case SOUTH -> posY -= currentSpeed;
            case WEST -> posX += currentSpeed;
            case EAST -> posX -= currentSpeed;
        }
    }

    /** turns the car to the left */
    @Override
    public void turnLeft(){
        dir = switch (dir) {
            case NORTH -> Dir.WEST;
            case WEST -> Dir.SOUTH;
            case SOUTH -> Dir.EAST;
            case EAST -> Dir.NORTH;
        };
    }

    /** turns the car to the right */
    @Override
    public void turnRight(){
        dir = switch (dir) {
            case NORTH -> Dir.EAST;
            case WEST -> Dir.NORTH;
            case SOUTH -> Dir.WEST;
            case EAST -> Dir.SOUTH;
        };
    }

   /** returns the cars speedfactor */
    protected double speedFactor() {
        return enginePower * 0.01;
    }
    /** increases the speed of the car by a given amount */
    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /** decreases the speed of the car by a given amount */
    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // TODO fix this method according to lab pm
    /** gives gas to the car */
    public void gas(double amount){
        if (amount > 1 && currentSpeed <= enginePower) {
            incrementSpeed(1);
        }
        else if (amount > 0 && amount <= 1) {
            incrementSpeed(amount);
        }
    }

    // TODO fix this method according to lab pm
    /** brakes the car */
    public void brake(double amount){
        if (amount > 1){
            decrementSpeed(1);
        }
        else if (amount > 0 && amount <= 1){
            decrementSpeed(amount);
        }
    }
}
