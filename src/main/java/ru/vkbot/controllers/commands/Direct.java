package ru.vkbot.controllers.commands;

import com.vk.api.sdk.objects.messages.Message;
import ru.vkbot.controllers.Command;
import ru.vkbot.keyboards.VKKeyBoardDirect;
import ru.vkbot.modules.VKSendMessenger;

public class Direct extends Command {

    public Direct(String name){
        super(name);
    }
    @Override
    public void exec(Message message) {
        VKSendMessenger.placeKeyboard(VKKeyBoardDirect.getKeyboard(), message.getFromId(), name);
    }
}