package ru.vkbot.controllers;

import ru.vkbot.controllers.commands.MenuMain;
import ru.vkbot.modules.Command;

import java.util.HashSet;

public class CommandManager {
    private static HashSet<Command> commands = new HashSet<>();

    static {
        commands.add(new MenuMain("Старт"));
        //commands.add(new Weather("weather"));

    }

    public static HashSet<Command> getCommands(){
        return commands;
    }
    public static void addCommand(Command command) { commands.add(command);}
}
