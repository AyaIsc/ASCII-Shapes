package g58414.atlg3.ascii.model;

import java.util.List;

public class UngroupCommand implements Command{
    private Drawing drawing;
    private int i;
    private Shape group;


    public UngroupCommand(int i, Drawing drawing) {
        this.i = i;
        this.drawing= drawing;
        group = drawing.getShape(i);
    }

    @Override
    public void execute() {
        if(!(group instanceof Group)) {
            throw new IllegalArgumentException("This element is not a group");
        }
        List<Shape> shapesGrp = ((Group) group).getChildren();
        for(Shape shape : shapesGrp) {
            drawing.addShape(shape);
        }
        drawing.remove(group);
    }

    @Override
    public void unexecute() {
        List <Shape> shapesGrp = ((Group) group).getChildren();
        for(Shape shape : shapesGrp) {
            drawing.remove(shape);
        }
        drawing.addShape(group);
        drawing.addShapeAt(group, i);
    }

}
