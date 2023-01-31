import java.util.ArrayList;

public class CarWorkshop<T extends Car>  {
    private final ArrayList<T> carSlots;

    public CarWorkshop(int slots){
        this.carSlots = new ArrayList<>(slots);
        for (int i = 0; i < slots; i++){
            carSlots.add(null);
        }
    }


    public void printCars (){
        for (int i = 0; i < carSlots.size(); i++) {
            System.out.println("Car " + i + ", " + carSlots.get(i).color + ", " + carSlots.get(i).modelName);
        }
    }

    private int findEmptySlot() {
        for (int i = 0; i < carSlots.size(); i++) {
            if (carSlots.get(i) == null) {
                return i;
            }
        }
        return -1; // Didn't find an empty slot
    }

    public boolean addCar(T car) {
        int slots = findEmptySlot();
        if(slots == -1){
            return false;
        }
        carSlots.set(slots, car);
        return true;
    }

    public T removeCar(int slot) {
        return carSlots.set(slot, null);
    }
}
