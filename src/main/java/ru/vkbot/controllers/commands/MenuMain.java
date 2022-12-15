package ru.vkbot.controllers.commands;

import com.vk.api.sdk.objects.messages.Message;
import ru.vkbot.controllers.Command;
import ru.vkbot.keyboards.KeyBoardMainMenu;
import ru.vkbot.modules.VKSendMessenger;

public class MenuMain extends Command {

    public MenuMain(String name){
        super(name);
    }
    @Override
    public void exec(Message message) {
        //new VKSendMessenger().sendMessage("Стартовая точка", message.getFromId());

        VKSendMessenger.placeKeyboard(KeyBoardMainMenu.getKeyboard(), message.getFromId(), name);
    }
}
