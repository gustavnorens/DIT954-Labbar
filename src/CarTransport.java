import java.awt.*;
import java.util.ArrayList;


public class CarTransport extends Vehicle implements ICarHolder, ITrailer {
    private boolean rampUp;
    private final double maxCarWidth, maxCarLength, maxCarHeight;
    private final int maxCars;

    private CarHolder<Vehicle> parent;


    public CarTransport () {
        nrDoors = 2;
        color = Color.blue;
        enginePower = 100;
        modelName = "Mercedes";
        posX = 0;
        posY = 0;
        dir = Dir.NORTH;
        rampUp = true;
        stopEngine();
        maxCars = 3;

        parent = new CarHolder<>(maxCars);

        length = 1500;
        width = 270;
        height = 450;

        maxCarHeight = 200;
        maxCarWidth = 250;
        maxCarLength = 600;
    }

    /** Gets the current state of the ramp. True if ramp is up and False otherwise */
    public boolean getRamp(){
        return rampUp;

    }

    /** Toggles the ramp */
    public void rampToggle() {
        if (currentSpeed == 0) {
            rampUp = !rampUp;
        }
    }

    /** Adds the given car to the transport */
    public boolean addCar(Vehicle car) {
        if (!rampUp /*&& fitsOnTruck(car) */ && isNearby(car)) {
            car.posX = posX;
            car.posY = posY;
            car.currentSpeed = 0;
            car.dir = dir;
            parent.addCar(car);
            return true;
        }
        return false;
    }

    /** Checks if the car is nearby to the transport */
    private boolean isNearby(Car car) {
        if (car.posX <= posX + 10 && car.posX >= posX - 10 &&
                car.posY <= posY + 10 && car.posY >= posY - 10) {
           return true;
        }
        return false;
    }

    /** Checks if the car fits on the transport */
    private boolean fitsOnTruck(Vehicle car) {
        if (car.length <= maxCarLength && car.width <= maxCarWidth &&
                car.height <= maxCarHeight && parent.cars.size() < 3) {
            return true;
        }
        return false;
    }

    /** getCars returns the Stack<Car> called cars */
    public ArrayList<Vehicle> getCars() {
        return parent.cars;
    }

    /** removes the last stowed car from the transport */
    public Vehicle removeCar() {
        if (!rampUp && !parent.cars.isEmpty()){
            Vehicle car = parent.removeCar(parent.numberOfCurrentCars);
            car.dir = dir;
            car.currentSpeed = -5;
            car.move();
            car.currentSpeed = 0;
            return car;
        }
        return null;
    }

    /** Moves the CarTransport and all the cars currently on it's trailer */
    @Override
    public void move(){
        for (Vehicle c : parent.cars) {
            if (c != null) {
                c.currentSpeed = this.currentSpeed;
                c.dir = dir;
                c.move();
            }
        }
        super.move();
    }

    @Override
    public boolean canDrive() {
        return !getRamp();
    }

    @Override
    public void changeTilt() {

    }
}

