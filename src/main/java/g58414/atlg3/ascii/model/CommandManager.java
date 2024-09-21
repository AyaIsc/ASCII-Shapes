package g58414.atlg3.ascii.model;

import java.util.Stack;

/**
 * class that works with stacks for the user's commands
 */
public class CommandManager {
    private Stack<Command> undoStack=new Stack<>();
    private Stack<Command> redoStack=new Stack<>();

    /**
     * adds command to the stack
     * @param command
     */
    public void addCommand(Command command){
        command.execute();
        undoStack.push(command);
        redoStack.clear();
    }

    /**
     * cancels the last command introduced in the stack
     */
    public void undo(){
        if(!undoStack.isEmpty()) {
            Command command = undoStack.pop(); //enlève dernier element
            command.unexecute();
            redoStack.push(command);
        }
    }

    /**
     * brings back the last command in the stack
     */
    public void redo(){
        if(!redoStack.isEmpty()){
            Command command = redoStack.pop();
            command.execute();
            undoStack.push(command); //<- reverse code de undo
        }
    }
}
