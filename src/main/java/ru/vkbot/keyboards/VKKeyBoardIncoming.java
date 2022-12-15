package ru.vkbot.keyboards;

import com.vk.api.sdk.objects.messages.Keyboard;
import com.vk.api.sdk.objects.messages.KeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class VKKeyBoardIncoming {
    public static Keyboard getKeyboard(){
        Keyboard keyboard = new Keyboard();
        List<List<KeyboardButton>> Keys = new ArrayList<>();
        List<KeyboardButton> line1 = new ArrayList<>();
        List<KeyboardButton> line2 = new ArrayList<>();
        line1.add(VKKeys.getKey("Даты приёма"));
        line1.add(VKKeys.getKey("Минимальные баллы"));
        line2.add(VKKeys.getKey("Вступительные испытания"));
        line2.add(VKKeys.getKey("Возврат к главному разделу"));
        Keys.add(line1);
        Keys.add(line2);
        keyboard.setButtons(Keys);
        return keyboard;
    }
}
