package g58414.atlg3.ascii.view;
import java.util.List;
import java.util.Scanner;

import g58414.atlg3.ascii.model.AsciiPaint;
import g58414.atlg3.ascii.model.Drawing;
import g58414.atlg3.ascii.model.Shape;
import g58414.atlg3.ascii.model.Point;




/**
 * class with all the displays that are being used.
 */
public class AsciiView {




    /**
     * Displays Title and welcomes the user
     */
    public void displayTitle(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Welcome to the AsciiPaint of user G58414");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }

    /**
     * displays the constructions to the user.
     */
    public void displayInstructions(){
        System.out.println("choose what do you want to display with the keyword <<add>> ,your " +
                "shape , its parameters and finish your command with <<show>> ");
    }

    /**
     *  asks the user the height and width of the drawing.
     * @return AsciiPaint
     */
    public AsciiPaint displaySize(){

        Scanner clavier = new Scanner(System.in);
        System.out.println("Choose the height of your paint :");
        int height  = clavier.nextInt();
        System.out.println("choose the width of your paint : ");
        int width = clavier.nextInt();
        while(height<=0 || width <= 0 ){
            System.out.println("please enter valid parameters to the size");
            clavier.nextInt();
        }
        return new AsciiPaint(height,width); // on ne construit pas le modèle dans la vue.
    }

    /**
     * displays the drawing
     * @param drawing
     */
    public void displayDrawing(Drawing drawing){
        for(int i = 0;i <drawing.getHeight() ; i++  ){
            for(int j = 0 ; j < drawing.getWidth(); j ++){
                Shape shape = drawing.getShapeAt(new Point(j,i));

                if(shape != null){
                    System.out.print(shape.getColor());
                }else{
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }


    /**
     * displays a message to help the user
     */
    public void displayHelp(){
        System.out.println("Follow this example :" +
                "add circle 5 3 1 c" );
        System.out.println("use the word add followed by the shape , its parameters, and the color");
    }

    /**
     * displays the message for the end
     */
    public void displayEnd(){
        System.out.println("you reached the end , thank you for playing");
    }

    /**
     * displays the list of the drawing's shapes.
     * @param shapes
     */
    public void displayShapes(List<Shape> shapes){
        int index = 0;
        for(Shape form : shapes){
            System.out.println(index+". "+" shape : "+form+" , color : "+ form.getColor());
            index++;
        }
    }

    /**
     * displays a text if the command is added to the drawing
     */
    public void displayCorrect(){
        System.out.println("command added");
    }

    /**
     * displays an error if its detected.
     * @param s
     */
    public void displayError(String s){
        System.out.println("an error was detected : "+s);
    }
}
