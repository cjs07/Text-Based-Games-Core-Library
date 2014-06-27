package io.githubb.cjs07.textBasedGameCoreLibrary.commands;

/**
 * Created by CJ on 4/22/14.
 * Developed for the Text Based Games Core Library project.
 */
public abstract class Command {

    String name;
    public static Command[] commands = new Command[1000];

    //TODO: ADD COMMAND ARGUMENT INITIALIZATION TO CONSTRUCTOR
    public Command (int id, String name) {
        if (commands[id] != null) {

        } else {
            commands[id] = this;
            this.name = name;
            System.out.println("[Command Initialization] Command " + name + " successfully initialized with id "
                    + id + " and allowable arguments:" /*allowable args will be printed here.*/);
        }
    }

    public abstract void execute();
}
