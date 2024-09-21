package g58414.atlg3.ascii.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * This class adds the shape to the drawing and "paints" it.
 */
public class AsciiPaint {
    private Drawing drawing;
    private CommandManager commandManager = new CommandManager();
    /**
     * the constructor of AsciiPaint
     */
    public AsciiPaint() {
        drawing = new Drawing();
    }

    /**
     * The second constructor of AsciiPaint
     * @param width int
     * @param height int
     */
    public AsciiPaint(int width, int height){
       drawing = new Drawing(width, height);
    }

    /**
     * Undoes the command
     */
    public void undo(){
        commandManager.undo();
    }

    /**
     * redoes the command
     */
    public void redo(){
        commandManager.redo();
    }
    /**
     * This method creates a new Circle.
     * @param x int of the circle's center
     * @param y int of the circle's center
     * @param radius double of the circle's radius
     * @param color char of the circle's color
     */
    public void newCircle(int x , int y, double radius, char color){
        if(radius <= 0){
            throw new IllegalArgumentException("radius must be positive: "+radius);
        }
        Point center = new Point(x,y);
        Circle circle = new Circle(center , radius , color);
        Command command = new AddCommand(circle,drawing);
        commandManager.addCommand(command);
        //drawing.addShape(circle);
        // drawing.shape add cercle etc
    }

    /**
     * This method creates a new Rectangle.
     * @param x int
     * @param y int
     * @param width double
     * @param height double
     * @param color char
     */
    public void newRectangle(int x , int y, double width , double height, char color){
        //largeur aussi
        if(width <= 0){ // et hauteur
            throw new IllegalArgumentException("width must be positive , received : "  + width);
        }
        if(height <= 0){
            throw new IllegalArgumentException("width must be positive , received : "+height);
        }
        Point upperLeft = new Point(x,y);
        Rectangle rectangle = new Rectangle(upperLeft,width,height,color);
        Command command = new AddCommand(rectangle,drawing);
        commandManager.addCommand(command);
    }

    /**
     * This method creates a new Square.
     * @param x int
     * @param y int
     * @param side double
     * @param color char
     */
    public void newSquare( int x , int y , double side , char color){
        //side aussi
        if(side <=0){
            throw new IllegalArgumentException("side must be positive , received : "+side );
        }
        Point upperLeft = new Point(x,y);
        Square square= new Square(upperLeft,side,color);
        Command command = new AddCommand(square,drawing);
        commandManager.addCommand(command);
    }


    //public void newGroup(List<Integer> shapesIndexes,char color) { //group les shapes 1,2,5,7
        /*
        - créer un groupe avec les shape
        - ajouter ton groupe au drawing
        - retirer les shape du groupe du drawing.

         */
        /*List <Shape> list = new ArrayList<>();
        List<Shape> list2 = drawing.getShapes(); //shapes dans drawing
        for(int i :shapesIndexes) {
            list.add(list2.get(i)); //ajoute les shapes du drawing dans nvl liste
        }
        Group groupe = new Group(list,color);
        for (Shape shape : list){
            drawing.remove(shape);
        }
        Command command = new AddCommand(groupe, drawing);
        /* il faut faire une command GroupCommand:
            - qui ajoute le groupe et retire les shape
            - poru le unexectute: retire le groupe et rajoute les shapes qui composaient le gorupe.
         */


       // commandManager.addCommand(command);


    public void newGroup(List<Integer> indexs){
        Command group = new GroupCommand(indexs,drawing);
        //grp.execute();
        commandManager.addCommand(group);

    }


    /*public void newUnGroup(int index) {
        // il faut faire la commande pour le undo redo.
        if(!(drawing.getShapes().get(index) instanceof Group)) {
            throw new IllegalArgumentException("this is not a group ");
        }
        drawing.getShapes().addAll(((Group) drawing.getShapes().get(index)).getChildren());
        drawing.getShapes().remove(index);

    }*/


    /*public void newDelete(Shape shape){
        drawing.remove(shape); // commande.
    }*/
    public void newDelete(int i) {
        Command delete = new DeleteCommand(i, drawing);
        commandManager.addCommand(delete);
    }

    public void newUngroup(int index) {
        Command ungroup = new UngroupCommand(index,drawing);
        //ungrp.execute();
        commandManager.addCommand(ungroup);
    }


    public void newMove(Shape shape , int dx , int dy){
        MoveCommand move = new MoveCommand(shape,dx,dy);
        commandManager.addCommand(move);
    }
    /**
     * creates a new line in the drawing
     * @param ax int of first point
     * @param ay int of first point
     * @param bx int of second point
     * @param by int of second point
     * @param color char of the lines color
     */
    public void newLine(int ax,int ay , int bx , int by,char color){
        Point ptA = new Point(ax,ay);
        Point ptB = new Point(bx,by);

        Line line = new Line(ptA,ptB,color);
        Command command = new AddCommand(line,drawing);
        commandManager.addCommand(command);

    }

    /**
     * changes the color of the chosen shape.
     * @param newColor the new color of the shape
     * @param shape shape that needs to be colored
     */
    public void newColor(char newColor, Shape shape){
        if(drawing.getShapes()!=shape){
            throw new IllegalArgumentException("shape is not in the drawing");
        }
        Command command = new ChangeColorCommand(newColor,shape);
        commandManager.addCommand(command);

    }
    /**
     * Getter for the attribute drawing.
     * @return
     */
    public Drawing getDrawing() {
        return drawing;
    }
}
