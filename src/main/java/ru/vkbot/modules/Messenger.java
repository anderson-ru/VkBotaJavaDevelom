package ru.vkbot.modules;

import com.vk.api.sdk.objects.messages.Message;
import ru.vkbot.controllers.MessengerController;

public class Messenger implements Runnable{

        private Message message;

        public Messenger(Message message){
            this.message = message;
        }

        @Override
        public void run() {
            MessengerController.execute(message);
        }
    }

