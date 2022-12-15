package ru.vkbot.controllers.commands;

import com.vk.api.sdk.objects.messages.Message;
import ru.vkbot.controllers.Command;
import ru.vkbot.keyboards.VKKeyBoardIncoming;
import ru.vkbot.modules.VKSendMessenger;

public class Incoming extends Command {

    public Incoming(String name){
        super(name);
    }
    @Override
    public void exec(Message message) {
        //new VKSendMessenger().sendMessage("Стартовая точка", message.getFromId());

        new VKSendMessenger().placeKeyboard(VKKeyBoardIncoming.getKeyboard(), message.getFromId(), name);
    }
}