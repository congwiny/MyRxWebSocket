package com.congwiny.rxwebsocket.message.chatroom;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Geek4IT on 2/24/16.
 */
public class PubChatModel extends BaseChatModel {

    @SerializedName("content")
    protected String content;
    //是不是主播发送的消息
    @SerializedName("isHost")
    private boolean isHost;


    public boolean isHost() {
        return isHost;
    }

    public void setHost(boolean isHost) {
        this.isHost = isHost;
    }

    @Override
    public String toString() {
        return "PubChatModel [type = " + type + "\'" +
                ", content = " + content + ", base: " + super.toString() + "]";
    }

}
