package ru.vkbot.modules;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.messages.Keyboard;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.queries.messages.MessagesGetLongPollHistoryQuery;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class VKCore {
    private VkApiClient vk;
    private static int ts;
    private static GroupActor actor;
    private int groupId;
    private static String access_token;

    private static int maxMsgId = -1;

    public VkApiClient getVk() {
        return vk;
    }

    public static GroupActor getActor() {
        return actor;
    }

    public VKCore(){
        TransportClient transportClient = new HttpTransportClient();
        vk = new VkApiClient(transportClient);

        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/main/resources/vkconfig.properties"));
            groupId = Integer.valueOf(prop.getProperty("groupId"));
            access_token = prop.getProperty("accessToken");
            actor = new GroupActor(groupId, access_token);

            ts = vk.messages().getLongPollServer(actor).execute().getTs();
        } catch (IOException | ApiException | ClientException e) {
            e.printStackTrace();
            System.out.println("Ошибка при загрузке файла конфигурации");
        }
    }
    public Message getMessage() throws ClientException, ApiException {

        MessagesGetLongPollHistoryQuery eventsQuery = vk.messages()
                .getLongPollHistory(actor)
                .ts(ts);
        if (maxMsgId > 0){
            eventsQuery.maxMsgId(maxMsgId);
        }
        List<Message> messages = eventsQuery
                .execute()
                .getMessages()
                .getItems();

        if (!messages.isEmpty()){
            try {
                ts =  vk.messages()
                        .getLongPollServer(actor)
                        .execute()
                        .getTs();
            } catch (ClientException e) {
                e.printStackTrace();
            }
        }
        if (!messages.isEmpty() && !messages.get(0).isOut()) {
                /*
                messageId - максимально полученный ID, нужен, чтобы не было ошибки 10 internal server error,
                который является ограничением в API VK. В случае, если ts слишком старый (больше суток),
                а max_msg_id не передан, метод может вернуть ошибку 10 (Internal server error).
                 */
            int messageId = messages.get(0).getId();
            if (messageId > maxMsgId){
                maxMsgId = messageId;
            }

            return messages.get(0);
        }

        return null;
    }
}
