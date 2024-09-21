package g58414.atlg3.ascii.controller;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.jdi.IntegerValue;
import g58414.atlg3.ascii.view.AsciiView;
import g58414.atlg3.ascii.model.AsciiPaint;

/**
 * Class application that creates and shows the paint.
 */
public class Application {
    private static final String ADD_CIRCLE_PATTERN = "add circle\s(\\d+)\s(\\d+)\s(\\d+)\s([a-z])";
    public static final String ADD_SQUARE_PATTERN = "add square\s(\\d+)\s(\\d+)\s(\\d+)\s([a-z])";
    public static final String ADD_RECTANGLE_PATTERN ="add rectangle\s(\\d+)\s(\\d+)\s(\\d+)\s(\\d+)\s([a-z])";
    public static final String ADD_GROUP_PATTERN= "group\\s(\\d\\s*)*+[a-z]";
    public static final String ADD_UNGROUP_PATTERN="ungroup\s(\\d)";
    public static final String ADD_LINE_PATTERN="add line\s(\\d+)\s(\\d+)\s(\\d+)\s(\\d+)\s([a-z])";
    public static final String MOVE_SHAPE_PATTERN="move\s(\\d+)\s(\\d+)\s(\\d)";
    public static final String CHANGE_COLOR_PATTERN="color\s([a-z]+)\s(\\d)";
    public static final String DELETE_SHAPE_PATTERN="delete\s(\\d)";
    private AsciiView view;
    private AsciiPaint paint;

    /**
     * Constructor of the class Application
     * @param view AsciiView
     * @param paint AsciiPaint
     */
    public Application(AsciiView view, AsciiPaint paint) {
        this.view = view;
        this.paint=paint;
    }

    /**
     * Displays the commands and interacts with the user for the paint
     */
    public void start() {
        boolean askDrawing = true;
        view.displayTitle();
        Scanner clavier = new Scanner(System.in);
        this.paint = view.displaySize();
        view.displayInstructions();
        while (askDrawing) {
            try {
                String command = clavier.nextLine().toLowerCase();

                String[] param = command.split(" ");
                if (Pattern.matches(ADD_CIRCLE_PATTERN, command)) {
                    // utiliser les gorup: https://www.tutorialspoint.com/javaregex/javaregex_capturing_groups.htm
                    //didn't work for me unfortunately after multiples tries

                    this.paint.newCircle(Integer.valueOf(param[2]), Integer.valueOf(param[3]), Integer.valueOf(param[4]), param[5].charAt(0));

                    view.displayCorrect();
                }
                if (Pattern.matches(ADD_SQUARE_PATTERN,
                        command)) {

                    this.paint.newSquare(Integer.valueOf(param[2]), Integer.valueOf(param[3]), Integer.valueOf(param[4]), param[5].charAt(0));
                    view.displayCorrect();
                }
                if (Pattern.matches(ADD_RECTANGLE_PATTERN,
                        command)) {

                    this.paint.newRectangle(Integer.valueOf(param[2]), Integer.valueOf(param[3]), Integer.valueOf(param[4]), Integer.valueOf(param[5]), param[6].charAt(0));
                    view.displayCorrect();
                }
                if (Pattern.matches(ADD_GROUP_PATTERN, command)) {
                    view.displayCorrect();
                    ArrayList nbs = new ArrayList<Integer>();
                    for (int i = 1; i < param.length - 1; i++) {
                        nbs.add(Integer.parseInt(param[i]));
                    }
                    this.paint.newGroup(nbs);

                }
                if (Pattern.matches(ADD_UNGROUP_PATTERN, command)) {
                    view.displayCorrect();
                    this.paint.newUngroup(Integer.valueOf(param[1]));
                }
                if (Pattern.matches(ADD_LINE_PATTERN, command)) {
                    this.paint.newLine(Integer.valueOf(param[2]), Integer.valueOf(param[3]), Integer.valueOf(param[4]), Integer.valueOf(param[5]), param[6].charAt(0));
                    view.displayCorrect();
                }
                if (Pattern.matches(MOVE_SHAPE_PATTERN, command)) {
                    view.displayCorrect();
                    this.paint.newMove(paint.getDrawing().getShapes().get(Integer.valueOf(param[1])), Integer.valueOf(param[2]), Integer.valueOf(param[3]));
                }
                if (Pattern.matches(CHANGE_COLOR_PATTERN, command)) {
                    this.paint.newColor(param[1].charAt(0), paint.getDrawing().getShapes().get(Integer.valueOf(param[2])));
                    view.displayCorrect();
                }
                if (Pattern.matches(DELETE_SHAPE_PATTERN, command)) {
                    this.paint.newDelete(Integer.valueOf(param[1]));
                    // just donner l'indice (pas chercher la shape).
                    view.displayCorrect();
                }
                if (command.equals("show")) {
                    view.displayDrawing(paint.getDrawing());
                } else if (command.equals("undo")) {
                    this.paint.undo();
                    view.displayCorrect();
                } else if (command.equals("redo")) {
                    this.paint.redo();
                    view.displayCorrect();
                } else if (command.equals("help")) {
                    view.displayHelp();
                } else if (command.equals("exit")) {
                    view.displayEnd();
                    askDrawing = false;
                } else if (command.equals("list")) {
                    view.displayShapes(paint.getDrawing().getShapes());
                }
            } catch (Exception e) {
                view.displayError(e.getMessage());
            }
        }
    }
}
