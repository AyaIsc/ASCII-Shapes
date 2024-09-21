package g58414.atlg3.ascii.model;


/**
 * Class which is composed of all the method , attributes to create a Circle
 */
public class Circle extends ColoredShape {
    private double radius;
    private Point center;

    /**
     * Constructor of our class circle
     * @param center Point
     * @param radius double
     * @param color char
     */
    public Circle(Point center, double radius, char color) {
        super(color);
        if (radius <= 0) {
            throw new IllegalArgumentException("radius must be positive" +", received: " + radius);
        }
        this.radius=radius;
        this.center = center;
    }

    /**
     * checks if the point in the parameters isInside the shape.
     * @param p Point
     * @return boolean
     */
    public boolean isInside(Point p){
        return center.distanceTo(p) <= radius;
    }

    /**
     * allows us to move the shape
     * @param dx double
     * @param dy double
     */
    public void move(double dx, double dy){
        center.move(dx, dy);
    }

    @Override
    public String toString() {
        return "Circle";
    }
}