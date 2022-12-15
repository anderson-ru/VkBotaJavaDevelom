package ru.vkbot.controllers.commands;

import com.vk.api.sdk.objects.messages.Message;
import ru.vkbot.controllers.Command;
import ru.vkbot.keyboards.VKKeyBoardFAQ;
import ru.vkbot.modules.VKSendMessenger;

public class FAQ extends Command {

    public FAQ(String name){
        super(name);
    }
    @Override
    public void exec(Message message) {
        //new VKSendMessenger().sendMessage("Стартовая точка", message.getFromId());

        new VKSendMessenger().placeKeyboard(VKKeyBoardFAQ.getKeyboard(), message.getFromId(), name);
    }
}