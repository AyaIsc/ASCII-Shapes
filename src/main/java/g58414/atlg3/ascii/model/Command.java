package g58414.atlg3.ascii.model;

/**
 * Command with execute command and unexecute if the user wants to cancel it
 */
public interface Command {
    /**
     * executes the command introduced
     */
    void execute();

    /**
     * cancels the command introduced
     */
    void unexecute();
}
