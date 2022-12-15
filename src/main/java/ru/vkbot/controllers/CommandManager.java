package ru.vkbot.controllers;

import ru.vkbot.controllers.commands.Incoming;
import ru.vkbot.controllers.commands.MenuMain;
import ru.vkbot.controllers.commands.BackToMenuMain;
import ru.vkbot.controllers.commands.Education;


import java.util.HashSet;

public class CommandManager {
    private final static HashSet<Command> commands = new HashSet<>();

    static {
        commands.add(new MenuMain("Главное меню"));
        commands.add(new Incoming("Поступление"));
        commands.add(new BackToMenuMain("Возврат к главному разделу"));
        commands.add(new Education("Образовательные услуги"));
        //commands.add(new Weather("weather"));

    }

    public static HashSet<Command> getCommands(){
        return commands;
    }
    public static void addCommand(Command command) { commands.add(command);}
}
