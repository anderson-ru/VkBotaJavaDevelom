package ru.vkbot.modules;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Keyboard;


import java.util.Random;


public class VKSendMessenger {
    public static VKCore vkCore = new VKCore();

    public void sendMessage(String msg, int userId){
        if (msg == null){
            System.out.println("null");
            return;
        }
        try {
            vkCore.getVk().messages().send(vkCore.getActor())
                            .message(msg).userId(userId).randomId(new Random().nextInt(10000)).execute();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }

    public void placeKeyboard(Keyboard myKeyboard, int peerId, String msg){
        try {
            vkCore.getVk().messages().send(vkCore.getActor()).userId(peerId).message(msg)
                    .randomId(new Random().nextInt(10000)).keyboard(myKeyboard).execute();
        }
        catch (ClientException | ApiException e) {
            System.out.println("Здесь проблема!!!");
            e.printStackTrace();
        }

    }
}
