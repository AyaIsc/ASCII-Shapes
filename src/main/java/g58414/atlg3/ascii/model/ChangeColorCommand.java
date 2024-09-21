package g58414.atlg3.ascii.model;

/**
 * class to change de color of a shape with a new color and the number of the shape
 */
public class ChangeColorCommand implements Command {
    private char newColor;
    private char oldColor;
    private Shape shape;

    /**
     * constructor of the class
     * @param newColor char
     * @param shape shape
     */
    public  ChangeColorCommand(char newColor,Shape shape){
        this.newColor=newColor;
        this.oldColor= shape.getColor();
        this.shape=shape;
    }

    /**
     * changes the color of the shape
     */
    @Override
    public void execute() {
        shape.setColor(newColor);
    }

    /**
     * resets the original color of the shape
     */
    @Override
    public void unexecute() {
        shape.setColor(oldColor);
    }
}

// dans addcommandexecute drawing.add(shape)
// dans add shape et drawing en attribute , ajouter dans drawing methode pr remove dans unexececute

//ici ajouter