package com.congwiny.rxwebsocket.message.request;

import com.congwiny.rxwebsocket.constants.EventType;
import com.congwiny.rxwebsocket.message.chatroom.BaseChatModel;
import com.google.gson.annotations.SerializedName;

/**
 * Created by congwiny on 2016/8/15.
 */
public class PubChatReqMsg<T extends BaseChatModel> extends BaseReqMessage {

    @SerializedName("content")
    private T content;

    public PubChatReqMsg() {
        event = EventType.PUBLIC_MESSAGE_REQ;
    }
}
