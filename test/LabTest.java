import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.awt.*;

/** testing class for the methods */
public class LabTest {
    /** Car object used for the testing */
    private Volvo240 volvo;
    private Scania scania;
    private CarTransport transport;
    private CarWorkshop normalWorkshop;
    private CarWorkshop<Volvo240> volvoWorkshop;

    /** code that runs before every test*/
    @Before
    public void beforeTest() {
        volvo = new Volvo240();
        scania = new Scania();
        transport = new CarTransport();
        normalWorkshop = new CarWorkshop<>(10);
        volvoWorkshop = new CarWorkshop<>(5);
    }

    /** code that runs after every test */
    @After
    public void afterTest() {
        obj = null;
    }

    /** test the turnLeft() function */
    @Test
    public void turnLeftTest() {
        Dir start = volvo.getDir();
        volvo.turnLeft();
        Dir left = volvo.getDir();
        volvo.turnLeft();
        volvo.turnLeft();
        volvo.turnLeft();
        assert (start == volvo.getDir() && left != start);
    }

    /** test that the turnRight method works on car */
    @Test
    public void turnRightTest() {
        Dir start = volvo.getDir();
        volvo.turnRight();
        Dir right = volvo.getDir();
        volvo.turnRight();
        volvo.turnRight();
        volvo.turnRight();
        assert (start == volvo.getDir() && right != start);
    }

    /** test to make sure the move() function works properly */
    @Test
    public void moveTest() {
        volvo.gas(10);
        double originalPosY = volvo.getPosY();
        volvo.move();
        assert (volvo.getPosY() == originalPosY + volvo.currentSpeed);
    }

    /** test to make sure the gas() function works properly */
    @Test
    public void gasTest() {
        for (int i = 0; i < volvo.getEnginePower() + 1; i++) {
            volvo.gas(1);
        }
        assert (volvo.getEnginePower() == volvo.getCurrentSpeed());
    }

    /** test to make sure the brake() function works properly*/
    @Test
    public void brakeTest() {
        for (int i = 0; i < volvo.getEnginePower() + 1; i++) {
            volvo.brake(1);
        }
        assert (0 == volvo.getCurrentSpeed());
    }

    /** test to make sure the startEngine() function works properly*/
    @Test
    public void startEngineTest() {
        volvo.startEngine();
        assert (volvo.getCurrentSpeed() == 0.1);
    }

    /** test to make sure the setColor() function works properly*/
    @Test
    public void setColorTest() {
        volvo.setColor(Color.white);
        assert (volvo.getColor().equals(Color.white));
    }

    /** test to make sure the getColor() function works properly*/
    @Test
    public void getColorTest() {
        assert (volvo.getColor().equals(Color.black));
    }

    /** test to make sure the getNrDoors() function works properly */
    @Test
    public void nrDoorsTest() {
        assert (volvo.getNrDoors() == 4);
    }

    /** test to make sure the getPosX() function works properly*/
    @Test
    public void getPosXTest() {
        assert (volvo.getPosX() == 0);
    }

    /** test to make sure the getPosY() function works properly*/
    @Test
    public void getPosYTest() {
        assert (volvo.getPosY() == 0);
    }

    /** test to make sure the stopEngine() function works properly*/
    @Test
    public void stopEngineTest() {
        volvo.startEngine();
        volvo.stopEngine();
        assert (volvo.getCurrentSpeed() == 0);
    }
}