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
        line1.add(VKKeys.getKey("Поступление"));
        line1.add(VKKeys.getKey("Об университете"));
        line2.add(VKKeys.getKey("Образовательные услуги"));
        line2.add(VKKeys.getKey("Связь и FAQ"));
        Keys.add(line1);
        Keys.add(line2);
        keyboard.setButtons(Keys);
        return keyboard;
    }
}
