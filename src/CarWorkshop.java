import java.util.ArrayList;

/** Class to represent a Car Workshop */
public class CarWorkshop<T extends Vehicle> implements ICarHolder{
    /** ArrayList that represents all slots in the workshop */

    private CarHolder<T> parent;
    /** Constructor */
    public CarWorkshop(int slots){
        parent = new CarHolder(slots);
    }
    public boolean addCar(T car) {
        return parent.addCar(car);
    }

    public T removeCar(int slot) {
        return parent.cars.set(slot, null);
    }

    /** Returns the list of all cars currently in the workshop*/
    public ArrayList<T> getCars(){
        return parent.getCars();
    }
}
