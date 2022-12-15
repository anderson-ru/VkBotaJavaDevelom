package ru.vkbot.controllers.commands;

import com.vk.api.sdk.objects.messages.Message;
import ru.vkbot.controllers.Command;
import ru.vkbot.modules.VKSendMessenger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AboutUniversity extends Command {

    public AboutUniversity(String name){
        super(name);
    }
    @Override
    public void exec(Message message) {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        try {
            bufferedReader = new BufferedReader( new FileReader("src/main/texts/about_pgups.txt"));
            String line;
            while((line = bufferedReader.readLine()) != null){
                sb.append(line);
                sb.append("\n");
            }
            VKSendMessenger.sendMessage(sb.toString(), message.getFromId());
        } catch (IOException e) {
                e.printStackTrace();
        }



    }
}
