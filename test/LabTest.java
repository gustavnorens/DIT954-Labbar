import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.awt.*;

/** testing class for the methods */
public class LabTest {
    /** Car object used for the testing */
    private Car obj;

    /** code that runs before every test*/
    @Before
    public void beforeTest() {
        obj = new Volvo240();
    }

    /** code that runs after every test */
    @After
    public void afterTest() {
        obj = null;
    }

    /** test the turnLeft() function */
    @Test
    public void turnLeftTest() {
        Dir start = obj.getDir();
        obj.turnLeft();
        Dir left = obj.getDir();
        obj.turnLeft();
        obj.turnLeft();
        obj.turnLeft();
        assert (start == obj.getDir() && left != start);
    }

    /** test that the turnRight method works on car */
    @Test
    public void turnRightTest() {
        Dir start = obj.getDir();
        obj.turnRight();
        Dir right = obj.getDir();
        obj.turnRight();
        obj.turnRight();
        obj.turnRight();
        assert (start == obj.getDir() && right != start);
    }

    /** test to make sure the move() function works properly */
    @Test
    public void moveTest() {
        obj.gas(10);
        double originalPosY = obj.getPosY();
        obj.move();
        assert (obj.getPosY() == originalPosY + obj.currentSpeed);
    }

    /** test to make sure the gas() function works properly */
    @Test
    public void gasTest() {
        for (int i = 0; i < obj.getEnginePower() + 1; i++) {
            obj.gas(1);
        }
        assert (obj.getEnginePower() == obj.getCurrentSpeed());
    }

    /** test to make sure the brake() function works properly*/
    @Test
    public void brakeTest() {
        for (int i = 0; i < obj.getEnginePower() + 1; i++) {
            obj.brake(1);
        }
        assert (0 == obj.getCurrentSpeed());
    }

    /** test to make sure the startEngine() function works properly*/
    @Test
    public void startEngineTest() {
        obj.startEngine();
        assert (obj.getCurrentSpeed() == 0.1);
    }

    /** test to make sure the setColor() function works properly*/
    @Test
    public void setColorTest() {
        obj.setColor(Color.white);
        assert (obj.getColor().equals(Color.white));
    }

    /** test to make sure the getColor() function works properly*/
    @Test
    public void getColorTest() {
        assert (obj.getColor().equals(Color.black));
    }

    /** test to make sure the getNrDoors() function works properly */
    @Test
    public void nrDoorsTest() {
        assert (obj.getNrDoors() == 4);
    }

    /** test to make sure the getPosX() function works properly*/
    @Test
    public void getPosXTest() {
        assert (obj.getPosX() == 0);
    }

    /** test to make sure the getPosY() function works properly*/
    @Test
    public void getPosYTest() {
        assert (obj.getPosY() == 0);
    }

    /** test to make sure the stopEngine() function works properly*/
    @Test
    public void stopEngineTest() {
        obj.startEngine();
        obj.stopEngine();
        assert (obj.getCurrentSpeed() == 0);
    }
}