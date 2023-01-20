import java.awt.*;

public abstract class Car implements Movable{
    public enum Dir {
        NORTH,
        WEST,
        SOUTH,
        EAST
    }

    protected Dir dir = Dir.NORTH;
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected double posX;
    protected double posY;

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }
    public double getCurrentSpeed(){
        return currentSpeed;
    }
    public Color getColor(){
        return color;
    }
    public void setColor(Color clr){
        color = clr;
    }
    public void startEngine(){
        currentSpeed = 0.1;
    }
    public void stopEngine(){
        currentSpeed = 0;
    }
    public double getX(){
        return posX;
    }
    public double getY(){
        return posY;
    }
    /*public void setX(double x){
        posX = x;
    }
    public void setY(double y){
        posY = y;
    }*/

    @Override
    public void move(){
        switch (dir) {
            case NORTH -> posY += currentSpeed;
            case SOUTH -> posY -= currentSpeed;
            case WEST -> posX += currentSpeed;
            case EAST -> posX -= currentSpeed;
        }
    }
    @Override
    public void turnLeft(){
        switch (dir) {
            case NORTH -> dir = Dir.WEST;
            case WEST -> dir = Dir.SOUTH;
            case SOUTH -> dir = Dir.EAST;
            case EAST -> dir = Dir.NORTH;
        }
    }

    @Override
    public void turnRight(){
        switch (dir) {
            case NORTH -> dir = Dir.EAST;
            case WEST -> dir = Dir.NORTH;
            case SOUTH -> dir = Dir.WEST;
            case EAST -> dir = Dir.SOUTH;
        }
    }
}
