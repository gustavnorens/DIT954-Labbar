import java.awt.*;
import java.util.ArrayList;


public class CarTransport extends Truck implements ICarHolder {
    private boolean rampUp;
    private final double maxCarWidth, maxCarLength, maxCarHeight;
    private final int maxCars;

    private CarHolder<Vehicle> parent;

    public boolean isRampUp(){
        return rampUp;
    }

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

    /** Toggles the ramp */ /**
     * Toggles the ramp
     *
     * @return
     */
    public void rampToggle() {
        rampUp = !rampUp;
    }

    /** Adds the given car to the transport */
    public boolean addCar(Vehicle car) {
        if (!rampUp && fitsOnTruck(car) && isNearby(car)) {
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
    private boolean isNearby(Vehicle car) {
        if (car.posX <= posX + 10 && car.posX >= posX - 10 &&
                car.posY <= posY + 10 && car.posY >= posY - 10) {
           return true;
        }
        return false;
    }

    /** Checks if the car fits on the transport */
    private boolean fitsOnTruck(Vehicle car) {
        if (car.length <= maxCarLength && car.width <= maxCarWidth &&
                car.height <= maxCarHeight && parent.numberOfCurrentCars < 3) {
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
}

