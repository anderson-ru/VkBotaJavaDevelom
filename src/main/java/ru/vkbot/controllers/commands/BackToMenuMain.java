package ru.vkbot.controllers.commands;

import com.vk.api.sdk.objects.messages.Message;
import ru.vkbot.controllers.Command;
import ru.vkbot.keyboards.KeyBoardMainMenu;
import ru.vkbot.modules.VKSendMessenger;

public class BackToMenuMain extends Command {

    public BackToMenuMain(String name){
        super(name);
    }
    @Override
    public void exec(Message message) {
        //new VKSendMessenger().sendMessage("Стартовая точка", message.getFromId());

        new VKSendMessenger().placeKeyboard(KeyBoardMainMenu.getKeyboard(), message.getFromId(), name);
    }
}