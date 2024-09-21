package g58414.atlg3.ascii.model;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;


public class Drawing {
    private static final int DEFAULT_WIDTH = 50;

    private static final int DEFAULT_HEIGHT = 50;

    private List<Shape> shapes;
    private int height;
    private int width;

    public Drawing(){
        this(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
    public Drawing(int width, int height){
        this.width=width;
        this.height=height;
        this.shapes = new ArrayList<>();
    }

    /**
     * adds shape to the list of the shapes.
     * @param shape
     */
    void addShape(Shape shape){
        shapes.add(shape);
    }

    public Shape getShapeAt(Point p){
        for(Shape shape : shapes ){ // for( int i = 0 ; i < shapes.size(); i++){
            if(shape.isInside(p)) {
                return shape;
            }
        }
        return null;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public List<Shape> getShapes() {
        return new ArrayList<>(shapes); // on fait une copie.
    }

    void remove(Shape shape) {
        shapes.remove(shape);
    }
    public Shape getShape(int i) {
        if(i > shapes.size()-1 || i < 0) {
            throw new IllegalArgumentException("shape not found in this list !");
        }
        return shapes.get(i);
    }
    public void addShapeAt(Shape shape, int index) {
        if(shapes.contains(shape)) {
            throw new IllegalArgumentException("shape not found in this list !");
        }
        shapes.add(index, shape);
    }


}
