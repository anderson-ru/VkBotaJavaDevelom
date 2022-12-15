package ru.vkbot.controllers.commands;

import com.vk.api.sdk.objects.messages.Message;
import ru.vkbot.modules.Command;
import ru.vkbot.modules.VKSendMessenger;

public class MenuMain extends Command {

    public MenuMain(String name){
        super(name);
    }
    @Override
    public void exec(Message message) {
        new VKSendMessenger().sendMessage("Стартовая точка", message.getFromId());
    }
}
