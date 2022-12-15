package ru.vkbot.keyboards;

import com.vk.api.sdk.objects.messages.Keyboard;
import com.vk.api.sdk.objects.messages.KeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class VKKeyBoardMainMenu  {
    public static Keyboard getKeyboard(){
        Keyboard keyboard = new Keyboard();
        List<List<KeyboardButton>> Keys = new ArrayList<>();
        List<KeyboardButton> line1 = new ArrayList<>();
        List<KeyboardButton> line2 = new ArrayList<>();
        List<KeyboardButton> line3 = new ArrayList<>();
        line1.add(VKKeys.getKey("Привет"));
        line1.add(VKKeys.getKey("Кто я?"));
        line2.add(VKKeys.getKey("Направления подготовки и специальности"));
        line1.add(VKKeys.getKey("Пока"));
        line3.add(VKKeys.getKey("План приёма"));
        Keys.add(line1);
        Keys.add(line2);
        Keys.add(line3);
        keyboard.setButtons(Keys);
        return keyboard;
    }
}
