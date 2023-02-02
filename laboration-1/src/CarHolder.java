import java.util.ArrayList;
import java.util.List;

public class CarHolder<T extends Vehicle> {
    public int numberOfCurrentCars;
    public ArrayList<T> cars;
    public CarHolder(int capacity){
        numberOfCurrentCars = -1;
        cars = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            cars.add(null);
        }
    }
    boolean addCar(T car) {
        int slots = findEmptySlot();
        if(slots == -1){
            return false;
        }
        cars.set(slots, car);
        numberOfCurrentCars++;
        return true;
    }

    public int findEmptySlot() {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i) == null) {
                return i;
            }
        }
        return -1; // Didn't find an empty slot
    }

    public ArrayList<T> getCars() {
        return cars;
    }

    public T removeCar(int index){
        numberOfCurrentCars--;
        return cars.set(index, null);
    }
}