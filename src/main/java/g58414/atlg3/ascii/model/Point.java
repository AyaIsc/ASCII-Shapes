package g58414.atlg3.ascii.model;

/**
 * Class which is composed of all the method , attributes to create a Point
 *
 * @author Aya Kaoun
 */
public class Point {
    private double x;
    private double y;

    /**
     * Constructor of the class Point
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Point(double x, double y) {
        this.x = x ;
        this.y = y;
    }

    /**
     * Getter of the attribute x
     * @return the x coordinate
     */
    public double getX() {
        return x;
    }
    /**
     * Getter of the attribute y
     * @return the y coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Getter of the attribute p
     */
    public Point(Point p){
        this(p.x, p.y);
    }

    /**
     *
     * @param dx coordinate
     * @param dy coordinate
     */
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public double distanceTo(Point other){
        return Math.sqrt((this.x - other.x) *(this.x - other.x)
                + ((this.y-other.y) *(this.y-other.y)));
    }
}
