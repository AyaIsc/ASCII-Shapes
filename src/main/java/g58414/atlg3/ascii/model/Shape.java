package g58414.atlg3.ascii.model;

/**
 * interface Shape who describes the behavior of class ColoredShape.
 */
public interface Shape {
     /**
      * checks if a point is inside the shape
      * @param p
      * @return a boolean that confirms if its inside
      */
     boolean isInside(Point p);

     /**
      * moves the shape in the drawing
      * @param dx horizontal coordination
      * @param dy vertical coordination
      */
     void move(double dx, double dy);

     /**
      * getter of the shape's color
      * @return color's shape
      */
     char getColor();

     /**
      * Setter of the shape's color
      * @param color
      */
     void setColor(char color);//setColor

}
