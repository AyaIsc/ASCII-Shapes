package g58414.atlg3.ascii.model;

/**
 * Command that allows us to move a shape.
 */
public class MoveCommand implements Command{

    private Shape shape;
    private int dx;
    private int dy;
    //ancienne position shape get x et get y
    //nouvelle position attributs

    /**
     * constructor of the class MoveCommand
     * @param shape chosen shape
     * @param dx coordination horizontally
     * @param dy coordination vertically
     */
    public MoveCommand(Shape shape, int dx , int dy){
        this.shape=shape;
        this.dx= dx;
        this.dy=dy;

    }

    /**
     * Moves the shape
     */
    @Override
    public void execute() {
        shape.move(dx, dy);
    } // move dx, dy

    /**
     * undo the shape's movement
     */
    @Override
    public void unexecute() {
        shape.move(-dx, -dy);
    } // move -dx -dy
}
