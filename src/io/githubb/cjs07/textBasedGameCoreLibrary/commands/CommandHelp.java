package io.githubb.cjs07.textBasedGameCoreLibrary.commands;

import io.githubb.cjs07.textBasedGameCoreLibrary.gui.GUIConsole;

/**
 * Created by CJ on 4/30/2014.
 * Developed for the Text Based Games Core Library project.
 */
public class CommandHelp extends Command {

    public CommandHelp(int id, String name) {
        super(id, name);
    }

    @Override
    public void execute() {
        for (int i = 0; i < super.commands.length; i ++) {
            if (super.commands[i] != null) {
                GUIConsole.console.append(commands[i].name);
            }
        }
    }
}
