package ru.vkbot.controllers.commands;

import com.vk.api.sdk.objects.messages.Message;
import ru.vkbot.controllers.Command;
import ru.vkbot.keyboards.VKKeyBoardEducation;
import ru.vkbot.modules.VKSendMessenger;

public class Education extends Command {

    public Education(String name){
        super(name);
    }
    @Override
    public void exec(Message message) {
        //new VKSendMessenger().sendMessage("Стартовая точка", message.getFromId());

        new VKSendMessenger().placeKeyboard(VKKeyBoardEducation.getKeyboard(), message.getFromId(), name);
    }
}