package ru.vkbot;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.*;
import com.vk.api.sdk.queries.messages.MessagesGetLongPollHistoryQuery;
import ru.vkbot.modules.*;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Bot {
    public static void main(String[] args) throws ClientException, ApiException, InterruptedException {
        //TransportClient transportClient = new HttpTransportClient();
        VKCore vkCore = new VKCore();
        VkApiClient vk = vkCore.getVk();
        Random random = new Random();

        GroupActor actor = VKCore.getActor();
        Integer ts = vk.messages().getLongPollServer(actor).execute().getTs();
        AtomicBoolean switcher = new AtomicBoolean(true);

        while (switcher.get()) {
            MessagesGetLongPollHistoryQuery historyQuery = vk.messages().getLongPollHistory(actor).ts(ts);
            List<Message> messages = historyQuery.execute().getMessages().getItems();
            if (!messages.isEmpty()) {
                messages.forEach(message -> {
                    System.out.println(message.toString());
                    try {
                        if (message.getText().equals("Привет")) {
                            vk.messages().send(actor).message("Привет!").userId(message.getFromId()).randomId(random.nextInt(10000)).execute();
                            vk.messages().send(actor).userId(message.getFromId()).randomId(random.nextInt(10000)).keyboard(VKKeybord.getKeyboard()).execute();
                        } else if (message.getText().equals("Кто я?")) {
                            vk.messages().send(actor).message("Ты хороший человек.").userId(message.getFromId()).randomId(random.nextInt(10000)).execute();
                        } else if (message.getText().equals("Направления подготовки и специальности")) {
                            vk.messages().send(actor).message("https://priem.pgups.ru/bakalavriat.php").userId(message.getFromId()).randomId(random.nextInt(10000)).execute();
                        } else if (message.getText().equals("План приёма")) {
                            vk.messages().send(actor).message("https://www.pgups.ru/upload/medialibrary/473/plan_priema_bak_spec_mag_2023.pdf").userId(message.getFromId()).randomId(random.nextInt(10000)).execute();
                        } else if (message.getText().equals("Пока")) {
                            vk.messages().send(actor).message("Пока").userId(message.getFromId()).randomId(random.nextInt(10000)).execute();
                            switcher.set(false);
                        } else {
                            vk.messages().send(actor).message("Я тебя не понял.").userId(message.getFromId()).randomId(random.nextInt(10000)).execute();
                        }
                    } catch (ApiException | ClientException e) {
                        e.printStackTrace();
                    }
                });
            }
            ts = vk.messages().getLongPollServer(actor).execute().getTs();
            Thread.sleep(500);
        }
    }
}
