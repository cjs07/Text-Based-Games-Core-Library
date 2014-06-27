package io.githubb.cjs07.textBasedGameCoreLibrary.commands;

import io.githubb.cjs07.textBasedGameCoreLibrary.gui.GUIConsole;

/**
 * Created by CJ on 4/28/14.
 * Developed for the Text Based Games Core Library project.
 */
public class CommandExecutor {

    Command[] validCommands;

    public static String[] args = new String[10];

    public static boolean waitingForCommand = true;

    public CommandExecutor(Command[] validCommands) {
        this.validCommands = validCommands;
    }

    public void handleInput (String input) {
        System.out.println("Input " + input + " received. Handling. ");
        if (waitingForCommand) {
            for (int i = 0; i < Command.commands.length; i++) {
                if (Command.commands[i] != null) {
                    String command = Command.commands[i].name;
                    if (command.equals(input)) {
                        System.out.println("Input " + input + " is a valid command. Executing");
                        Command toExecute = Command.commands[i];
                        toExecute.execute();
                        waitingForCommand = false;
                    } else {
                        System.out.println("Input " + input + " is not a valid command, and a command is required.");
                        GUIConsole.console.append(input + " is not a valid command. type help for a list of valid " +
                                "commands.");
                    }
                }
            }
        } else if (!waitingForCommand) {
            //TODO: ATTACH ARGUMENTS TO COMMAND AND SEE IF COMMAND CAN BE EXECUTED
        }
    }

    public void registerCommand (Command command) {
        for (int i = 0; i < validCommands.length; i++) {
            if (validCommands[i] != null) {
                return;
            } else {
                validCommands[i] = command;
            }
            System.out.println("Command " + command + " registered as valid at position " + i);
        }
    }

    public void addArgs (String argToAdd, int index) {
        args[index] = argToAdd;
    }

    public String[] getArgs () {
        return args;
    }

    public void resetArgs() {
        for (int i = 0; i < args.length; i++) {
            args[i] = null;
        }
    }
}
