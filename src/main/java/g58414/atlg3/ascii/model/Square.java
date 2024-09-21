package g58414.atlg3.ascii.model;

/**
 * Class which is composed of all the method , attributes to create a Rectangle
 */
public class Square extends Rectangle{
    /**
     * Constrctor of the class Square
     * @param upperLeft Point for the square
     * @param side of the square
     * @param color of the square
     */
    public Square(Point upperLeft , double side, char color) {
        super(upperLeft,side, side , color);

    }
    @Override
    public String toString() {
        return "Square" ;
    }
}
