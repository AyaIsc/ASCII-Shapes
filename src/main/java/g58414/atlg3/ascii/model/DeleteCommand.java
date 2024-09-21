package g58414.atlg3.ascii.model;

public class DeleteCommand implements Command {

    private Drawing drawing;
    private Shape shape;
    private int i;



    public DeleteCommand(int i, Drawing drawing) {
        this.i=i;
        this.drawing = drawing;
        this.shape = drawing.getShape(i);
    }


    @Override
    public void execute() {
        drawing.remove(shape);
    }

    @Override
    public void unexecute() {
        drawing.addShapeAt(shape, i);
    }

}

