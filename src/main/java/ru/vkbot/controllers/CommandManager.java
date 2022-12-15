package ru.vkbot.controllers;

import ru.vkbot.controllers.commands.*;

import java.util.HashMap;

public class CommandManager {
    private final static HashMap<String,Command> commands = new HashMap<>(40);

    static {
        commands.put("Главное меню", new MenuMain("Главное меню"));
        commands.put("Поступление", new Incoming("Поступление"));
        commands.put("Возврат к главному разделу", new BackToMenuMain("Возврат к главному разделу"));
        commands.put("Образовательные услуги", new Education("Образовательные услуги"));
        commands.put("Связь и FAQ", new FAQ("Связь и FAQ"));
        commands.put("Направления", new Direct("Направления"));
        commands.put("Об университете", new AboutUniversity("Об университете"));
        commands.put("Контакты", new Contacts("Контакты"));
        commands.put("СПО", new SPO("СПО"));

    }

    public static HashMap<String, Command> getCommands(){
        return commands;
    }
}
