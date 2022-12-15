package ru.vkbot.modules;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;

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
            //vkCore.getVk().messages().send(vkCore.getActor()).userId(peerId).message(msg).execute();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }
}
