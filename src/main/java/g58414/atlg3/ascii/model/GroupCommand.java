package g58414.atlg3.ascii.model;

import java.util.ArrayList;
import java.util.List;

public class GroupCommand implements Command{
    private final Drawing drawing;
    private final List<Integer> index;
    private final Group group;
    private final List<Shape> shapesGrp;


    public GroupCommand(List<Integer> index, Drawing drawing ){
        shapesGrp = new ArrayList();
        this.drawing = drawing;
        this.index = index;


        for(int j : index) {
            shapesGrp.add(drawing.getShape(j));
        }
        group = new Group(shapesGrp,shapesGrp.get(0).getColor());
    }

    @Override
    public void execute() {


        for(Shape shape : shapesGrp) {
            drawing.remove(shape);
        }
        drawing.addShape(group);

    }

    @Override
    public void unexecute() {
        for(int i = 0; i < shapesGrp.size(); i++) {
            drawing.addShapeAt(shapesGrp.get(i), index.get(i));
        }
        drawing.remove(group);
    }

}

