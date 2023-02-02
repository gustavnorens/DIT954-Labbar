/** Interface to implement the methods required by a movable object*/
public interface Movable {
    /** asserts that all subtypes of Movable must implement move */
    void move();
    /** asserts that all subtypes of Movable must implement turnLeft */
    void turnLeft();
    /** asserts that all subtypes of Movable must implement turnRight */
    void turnRight();
}
