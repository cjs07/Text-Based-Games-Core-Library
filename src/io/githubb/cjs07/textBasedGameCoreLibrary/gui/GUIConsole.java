package io.githubb.cjs07.textBasedGameCoreLibrary.gui;

import io.githubb.cjs07.textBasedGameCoreLibrary.commands.Command;
import io.githubb.cjs07.textBasedGameCoreLibrary.commands.CommandExecutor;
import io.githubb.cjs07.textBasedGameCoreLibrary.commands.CommandHelp;
import io.githubb.cjs07.textBasedGameCoreLibrary.core.TextBasedGameCore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by CJ on 4/22/14.
 * Developed for the Text Based Games Core Library project.
 */
public class GUIConsole extends JFrame {

    JTextField input;
    public static JTextArea console;

    CommandExecutor executor = new CommandExecutor(Command.commands);

    //Basic Commands, the defaults needed to make a game. Other commands are added by games that use the library.
    Command help = new CommandHelp(0, "help");

    public GUIConsole (TextBasedGameCore core) {
        input = new JTextField();
        console = new JTextArea();

        add (input, BorderLayout.SOUTH);
        add(new JScrollPane(console), BorderLayout.CENTER);

        console.setEditable(false);

        //TODO: MAKE LONG STRINGS OF COMMANDS AND ARGUMENTS ACCEPTABLE, INSTEAD OF ONLY ONE COMMAND/ARGUMENT AT A TIME
        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                console.append(e.getActionCommand() + "\n");
                input.setText("");

                executor.handleInput(e.getActionCommand());
            }
        });

        for (int i = 0; i < Command.commands.length; i++) {
            executor.registerCommand(Command.commands[i]);
        }

        setSize(700, 450);
        setVisible(true);
    }
}
