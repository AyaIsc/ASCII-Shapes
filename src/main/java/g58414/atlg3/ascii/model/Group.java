package g58414.atlg3.ascii.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that allows us to group the shapes
 */
public class Group extends ColoredShape{
    private List<Shape> shapes;

    public Group(List<Shape> shapes, char color){
        super(color);
        this.shapes=shapes;

    }

    /**
     * checks if the shape is inside the list
     * @param p
     * @return
     */
    @Override
    public boolean isInside(Point p) {
        for(Shape shape : shapes ){ // for( int i = 0 ; i < shapes.size(); i++){
            if(shape.isInside(p)) {
                return true;
            }
        }
        return false;
    }

    /**
     * allows us to move the shapes
     * @param dx
     * @param dy
     */
    @Override
    public void move(double dx, double dy) { //parcours shape move le x et y de tte le sshapes
        for(Shape form : shapes){
            form.move(dx,dy);
        }
    }

    @Override
    public String toString() {
        return "Group{" + shapes +
                '}';
    }
    public List<Shape> getChildren(){  // remplacer par des méthodes de group qui gère la liste.

        return shapes;
    }

}
