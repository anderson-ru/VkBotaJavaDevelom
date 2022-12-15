package ru.vkbot.controllers;

import com.vk.api.sdk.objects.messages.Message;

public class MessengerController{
    public static void execute(Message message) {
        CommanderDeterminant.getCommand(CommandManager.getCommands(), message).exec(message);

    }
}
