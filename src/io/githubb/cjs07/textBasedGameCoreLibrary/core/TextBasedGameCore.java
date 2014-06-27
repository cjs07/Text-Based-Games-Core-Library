package io.githubb.cjs07.textBasedGameCoreLibrary.core;

import io.githubb.cjs07.textBasedGameCoreLibrary.gui.GUIConsole;

import javax.swing.*;

/**
 * Created by CJ on 4/22/14.
 * Developed for the Text Based Games Core Library project.
 */
public class TextBasedGameCore {

    public TextBasedGameCore () {
        GUIConsole guiConsole = new GUIConsole(this);
        guiConsole.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main (String[] args) {
        TextBasedGameCore core = new TextBasedGameCore();
    }
}
