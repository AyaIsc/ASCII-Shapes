package g58414.atlg3.ascii.model;

/**
 * Class that implements the class Shape to color the Shape.
 */
abstract class ColoredShape implements Shape {
    private char color;

    public ColoredShape(char color){
        this.color=color;
    }

    @Override
    public char getColor() {
        return color;
    }

    @Override
    public void setColor(char color) {
        this.color = color;
    }
}
