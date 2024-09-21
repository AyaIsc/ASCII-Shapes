package g58414.atlg3.ascii.model;

/**
 * Class which is composed of all the method , attributes to create a Rectangle
 */
public class Rectangle extends ColoredShape {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * constructor of the class rectangle
     * @param upperLeft Point
     * @param width double
     * @param height double
     * @param color char
     */
    public Rectangle(Point upperLeft, double width, double height, char color){
        super(color);
        // vérifier HEIGHT WIDTH >0  lancer une iaexcpetion
        this.upperLeft=upperLeft;
        this.height=height;
        this.width=width;
    }

    /**
     * checks if the point p in the parameters is in the rectangle by returning a boolean
     * @param p Point
     * @return boolean
     */
    public boolean isInside(Point p){

        Point RightD= new Point(upperLeft.getX() +width,upperLeft.getY()-height);
        return p.getX() >= upperLeft.getX()
                && p.getX() <= RightD.getX()
                && p.getY() <= upperLeft.getY()
                && p.getY() >= RightD.getY();

    }

    /**
     * allows us to move the shape.
     * @param dx double
     * @param dy double
     */
    public void move(double dx, double dy) {

        upperLeft.move(dx,dy);
    }

    @Override
    public String toString() {
        return "Rectangle" ;
    }
}