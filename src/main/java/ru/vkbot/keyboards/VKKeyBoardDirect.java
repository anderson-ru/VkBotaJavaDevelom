package ru.vkbot.keyboards;

import com.vk.api.sdk.objects.messages.Keyboard;
import com.vk.api.sdk.objects.messages.KeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class VKKeyBoardDirect {
    public static Keyboard getKeyboard(){
        Keyboard keyboard = new Keyboard();
        List<List<KeyboardButton>> Keys = new ArrayList<>();
        List<KeyboardButton> line1 = new ArrayList<>();
        List<KeyboardButton> line2 = new ArrayList<>();
        line1.add(VKKeys.getKey("Бакалавариат/специалитет"));
        line1.add(VKKeys.getKey("Магистратура"));
        line2.add(VKKeys.getKey("Аспирантура"));
        line2.add(VKKeys.getKey("Возврат к главному разделу"));
        Keys.add(line1);
        Keys.add(line2);
        keyboard.setButtons(Keys);
        return keyboard;
    }
}
