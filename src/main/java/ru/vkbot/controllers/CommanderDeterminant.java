package ru.vkbot.controllers;

import com.vk.api.sdk.objects.messages.Message;
import ru.vkbot.controllers.commands.MenuMain;

import java.util.HashMap;
import java.util.HashSet;

public class CommanderDeterminant {
    public static Command getCommand(HashMap<String, Command> commands, Message message){
        String text = message.getText();
        if (commands.containsKey(text)) return commands.get(text);
        else return new MenuMain("Старт");

    }
}
