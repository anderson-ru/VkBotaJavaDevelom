package ru.vkbot.keyboards;

import com.vk.api.sdk.objects.messages.Keyboard;
import com.vk.api.sdk.objects.messages.KeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class KeyBoardIncoming {
    public static Keyboard getKeyboard(){
        Keyboard keyboard = new Keyboard();
        List<List<KeyboardButton>> Keys = new ArrayList<>();
        List<KeyboardButton> line1 = new ArrayList<>();
        List<KeyboardButton> line2 = new ArrayList<>();
        line1.add(ru.vkbot.keyboards.Keys.getKey("Даты приёма"));
        line1.add(ru.vkbot.keyboards.Keys.getKey("Минимальные баллы"));
        line2.add(ru.vkbot.keyboards.Keys.getKey("Вступительные испытания"));
        line2.add(ru.vkbot.keyboards.Keys.getKey("Назад"));
        Keys.add(line1);
        Keys.add(line2);
        keyboard.setButtons(Keys);
        return keyboard;
    }
}
