package ru.vkbot;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.messages.*;
import com.vk.api.sdk.queries.messages.MessagesGetLongPollHistoryQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Bot {
    public static void main(String[] args) throws ClientException, ApiException, InterruptedException {
        TransportClient transportClient = new HttpTransportClient();
        VkApiClient vk = new VkApiClient(transportClient);
        Random random = new Random();
        Keyboard keyboard1 = new Keyboard();
        List<List<KeyboardButton>> Keys1 = new ArrayList<>();
        List<KeyboardButton> line1 = new ArrayList<>();
        List<KeyboardButton> line2 = new ArrayList<>();
        List<KeyboardButton> line3 = new ArrayList<>();
        line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Привет").setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.POSITIVE));
        line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Кто я?").setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.POSITIVE));
        line2.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Направления подготовки и специальности").setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.POSITIVE));
        line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Пока").setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.POSITIVE));
        line3.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("План приёма").setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.POSITIVE));
        Keys1.add(line1);
        Keys1.add(line2);
        Keys1.add(line3);
        keyboard1.setButtons(Keys1);

        Keyboard keyboard2 = new Keyboard();
        List<List<KeyboardButton>> Keys2 = new ArrayList<>();
        Keys2.add(line3);
        keyboard2.setButtons(Keys2);
        GroupActor actor = new GroupActor(217762775, "vk1.a.JVCk6wfsRPNF2mdilVhn6k6fN7Lf1qJM7-oAbyNA-BdlUzDtspVEW-UsBD7z0441QgjrQOp_Sv8UrcBq8PsTcgBbrqT5bZgChKOskNgAlmufc38b5KdnvfKO0eX_lVxU5QBqibT0GGEaAJ-e8LNBqO0MLzP0-Np4u7RrQ5_ZYcqpW-RPsxYP6PsDyaFy9Mxh8GhMRrESB2KqLSmKuPZ8tg");

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
                            vk.messages().send(actor).userId(message.getFromId()).randomId(random.nextInt(10000)).keyboard(keyboard1).execute();
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
