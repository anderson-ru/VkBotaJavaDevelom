package ru.vkbot.modules;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VKServer {
    public static VKCore vkCore;

    public static void main(String[] args) throws InterruptedException {
        vkCore = new VKCore();
        while (true){
            Thread.sleep(300);
            try {
                Message message = vkCore.getMessage();
                if (message != null){
                    ExecutorService exec = Executors.newCachedThreadPool();
                    exec.execute(new Messenger(message));
                }
            }
            catch (ClientException | ApiException e){
                e.printStackTrace();
            }


        }

    }
}
