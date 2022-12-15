package ru.vkbot.controllers.commands;

import com.vk.api.sdk.objects.messages.Message;
import ru.vkbot.controllers.Command;
import ru.vkbot.modules.VKSendMessenger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Contacts extends Command {
    public Contacts(String name){
        super(name);
    }
    @Override
    public void exec(Message message) {
        BufferedReader bufferedReader;
        VKSendMessenger vkSendMessenger = new VKSendMessenger();
        try {
            bufferedReader = new BufferedReader( new FileReader("src/main/texts/contacts.txt"));
            String line;
            while((line = bufferedReader.readLine()) != null){
                vkSendMessenger.sendMessage(line, message.getFromId());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
