package ru.vkbot.controllers;

import ru.vkbot.controllers.commands.AboutUniversity;
import ru.vkbot.controllers.commands.Incoming;
import ru.vkbot.controllers.commands.MenuMain;

import java.util.HashSet;

public class CommandManager {
    private final static HashSet<Command> commands = new HashSet<>();

    static {
        commands.add(new MenuMain("Старт"));
        commands.add(new Incoming("Поступление"));
        commands.add(new AboutUniversity("Об университете"));
        //commands.add(new Weather("weather"));

    }

    public static HashSet<Command> getCommands(){
        return commands;
    }
}
