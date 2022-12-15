package ru.vkbot.keyboards;

import com.vk.api.sdk.objects.messages.KeyboardButton;
import com.vk.api.sdk.objects.messages.KeyboardButtonAction;
import com.vk.api.sdk.objects.messages.KeyboardButtonColor;
import com.vk.api.sdk.objects.messages.TemplateActionTypeNames;

public class Keys {

    public static KeyboardButton getKey(String Label){
        return new KeyboardButton().setAction(new KeyboardButtonAction().setLabel(Label).setType(TemplateActionTypeNames.TEXT)).setColor(KeyboardButtonColor.POSITIVE);
    }
}