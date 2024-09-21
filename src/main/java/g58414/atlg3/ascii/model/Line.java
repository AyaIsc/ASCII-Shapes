package g58414.atlg3.ascii.model;

/**
 * Class to create a line
 */
public class Line extends ColoredShape {
    private Point ptA ;
    private Point ptB ;

    /**
     * Constructor of the class line
     * @param ptA point A of the line (beginning)
     * @param ptB point B of the line (end)
     * @param color color of the line
     */
    public Line(Point ptA,Point ptB,char color) {
        super(color);
        this.ptA=ptA;
        this.ptB=ptB;
    }

    /**
     * Checks if the point p is inside the line
     * @param p
     * @return
     */
    @Override
    public boolean isInside(Point p) {
        //y = mx + b
        //y-a2=m.(x-a1)
        double m = (ptB.getY()-ptA.getY())/(ptB.getX()-ptA.getX());
        return p.getY()-ptB.getX()==m*(p.getX()-ptA.getX());
    }

    /**
     * moves the line
     * @param dx horizontal coordination
     * @param dy vertical coordination
     */
    public void move(double dx, double dy) {

        ptA.move(dx,dy);
    }

    /**
     * To string method for the line
     * @return
     */
    @Override
    public String toString() {
        return "Line";
    }
}
