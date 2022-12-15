package ru.vkbot.controllers.commands;

import com.vk.api.sdk.objects.messages.Message;
import ru.vkbot.controllers.Command;
import ru.vkbot.keyboards.KeyBoardMainMenu;
import ru.vkbot.modules.VKSendMessenger;

public class Unknown extends Command {
    public Unknown(String name){
        super(name);
    }
    @Override
    public void exec(Message message) {
        VKSendMessenger.sendMessage(name, message.getFromId());
    }
}
