import java.awt.*;
import java.util.Stack;

public class CarTransport<T extends Car> extends Car implements ICarHolder {
    private boolean rampUp;
    private final int maxCars;
    private final double maxCarWidth, maxCarLength, maxCarHeight;
    private Stack<Car> cars = new Stack<>();


    /** Constructor for CarTransport */
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
        length = 1500;
        width = 270;
        height = 450;

        maxCarHeight = 200;
        maxCarWidth = 250;
        maxCarLength = 600;

    }

    /** Toggles the ramp */
    public void rampToggle() {
        if (currentSpeed == 0) {
            rampUp = !rampUp;
        }
    }

    /** adds the car to the truck */
    @Override
    public boolean addCar(Car car) {
        if (!rampUp && fitsOnTruck(car) && isNearby(car)) {
            car.posX = posX;
            car.posY = posY;
            car.currentSpeed = currentSpeed;
            car.dir = dir;
            cars.push(car);
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
    private  boolean fitsOnTruck(Car car) {
        if (car.length <= maxCarLength && car.width <= maxCarWidth &&
                car.height <= maxCarHeight && cars.size() < 3) {
            return true;
        }
        return false;
    }

    /** removes the last stowed car from the transport */
    @Override
    public Car removeCar() {
        if (!rampUp && !cars.isEmpty()){
            Car car = cars.pop();
            car.currentSpeed = -5;
            car.move();
            car.currentSpeed = 0;
            return car;
        }
        return null;
    }

    /** Increments the transports speed as well as all the speed of all the cars inside the transport */
    @Override
    public void incrementSpeed(double amount) {
        if (rampUp) {
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
            for (Car c : cars) {
                c.currentSpeed = currentSpeed;
            }
        }
    }

    /** Decrements the transports speed as well as all the speed of all the cars inside the transport */
    @Override
    public void decrementSpeed(double amount) {
        if (rampUp) {
            currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
            for (Car c : cars) {
                c.currentSpeed = currentSpeed;
            }
        }
    }

}

