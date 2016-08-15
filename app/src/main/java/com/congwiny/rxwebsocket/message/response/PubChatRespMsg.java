package com.congwiny.rxwebsocket.message.response;

import com.congwiny.rxwebsocket.constants.EventType;
import com.congwiny.rxwebsocket.message.chatroom.BaseChatModel;
import com.google.gson.annotations.SerializedName;

/**
 * Created by congwiny on 2016/8/15.
 */
public class PubChatRespMsg<T extends BaseChatModel> extends BaseRespMessage {
    @SerializedName("content")
    private T content;

    public PubChatRespMsg() {
        event = EventType.PUBLIC_MESSAGE_RESP;
    }

    @Override
    public Object convertToModel() {
        return null;
    }
}
