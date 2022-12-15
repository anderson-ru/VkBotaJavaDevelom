package ru.vkbot.modules;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;

public class VKServer {
    public static VKCore vkCore;

    public static void main(String[] args) throws InterruptedException {
        vkCore = new VKCore();
        while (true){
            Thread.sleep(300);
            try {
                vkCore.getMessage();
            }
            catch (ClientException | ApiException e){
                e.printStackTrace();
            }


        }

    }
}
