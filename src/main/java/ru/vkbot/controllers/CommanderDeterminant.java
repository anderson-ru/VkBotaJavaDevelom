package ru.vkbot.controllers;

import com.vk.api.sdk.objects.messages.Message;
import ru.vkbot.controllers.commands.MenuMain;
import ru.vkbot.modules.Command;

import java.util.HashSet;

public class CommanderDeterminant {
    public static Command getCommand(HashSet<Command> commands, Message message){
        String text = message.getText();
        for(Command command: commands){
            if (command.name.equals(text)){
                return command;
            }
        }
        return new MenuMain("Старт");
    }
}
