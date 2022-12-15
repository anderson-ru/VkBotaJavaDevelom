package ru.vkbot.controllers;

import ru.vkbot.controllers.commands.MenuMain;

import java.util.HashSet;

public class CommandManager {
    private final static HashSet<Command> commands = new HashSet<>();

    static {
        commands.add(new MenuMain("Привет"));
        commands.add(new MenuMain("Привет"));
        //commands.add(new Weather("weather"));

    }

    public static HashSet<Command> getCommands(){
        return commands;
    }
    public static void addCommand(Command command) { commands.add(command);}
}
