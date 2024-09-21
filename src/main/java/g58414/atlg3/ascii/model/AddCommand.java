package g58414.atlg3.ascii.model;

/**
 * class that adds command that is introduced by the user
 */
public class AddCommand implements Command {
    private Shape shape; // private
    private Drawing drawing;

    /**
     * adds the command
     * @param shape that is added
     * @param drawing where the shape is added
     */
    public AddCommand(Shape shape , Drawing drawing){
        this.shape=shape;
        this.drawing=drawing;
    }

    /**
     * method to add the shape to the drawing
     */
    @Override
    public void execute() {
        drawing.addShape(shape);
    }

    /**
     * method to delete the added shape from the drawing
     */
    @Override
    public void unexecute() {
        drawing.remove(shape);
    }
}
