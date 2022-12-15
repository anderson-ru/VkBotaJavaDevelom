package ru.vkbot.controllers.commands;

import com.vk.api.sdk.objects.messages.Message;
import ru.vkbot.controllers.Command;
import ru.vkbot.keyboards.VKKeyBoardFAQ;
import ru.vkbot.modules.VKSendMessenger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConnectAndFAQ extends Command {

    public ConnectAndFAQ(String name){
        super(name);
    }
    @Override
    public void exec(Message message) {
        new VKSendMessenger().placeKeyboard(VKKeyBoardFAQ.getKeyboard(), message.getFromId(), name);
    }
}