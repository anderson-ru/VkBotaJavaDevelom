package ru.vkbot.controllers.commands;

import com.vk.api.sdk.objects.messages.Message;
import ru.vkbot.controllers.Command;
import ru.vkbot.modules.VKSendMessenger;

public class Request extends Command {

    public Request(String name){
        super(name);
    }
    @Override
    public void exec(Message message) {
        //new VKSendMessenger().sendMessage("Стартовая точка", message.getFromId());

        new VKSendMessenger().sendMessage("Запрос от https://vk.com/id" + message.getFromId(), 108136079);
    }
}
