package ru.vkbot.keyboards;

import com.vk.api.sdk.objects.messages.Keyboard;
import com.vk.api.sdk.objects.messages.KeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class KeyBoardMainMenu {
    public static Keyboard getKeyboard(){
        Keyboard keyboard = new Keyboard();
        List<List<KeyboardButton>> Keys = new ArrayList<>();
        List<KeyboardButton> line1 = new ArrayList<>();
        List<KeyboardButton> line2 = new ArrayList<>();
        line1.add(ru.vkbot.keyboards.Keys.getKey("Поступление"));
        line1.add(ru.vkbot.keyboards.Keys.getKey("Об университете"));
        line2.add(ru.vkbot.keyboards.Keys.getKey("Образовательные услуги"));
        line2.add(ru.vkbot.keyboards.Keys.getKey("Связь и FAQ"));
        Keys.add(line1);
        Keys.add(line2);
        keyboard.setButtons(Keys);
        return keyboard;
    }
}
