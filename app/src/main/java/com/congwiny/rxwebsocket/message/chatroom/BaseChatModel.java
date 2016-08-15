package com.congwiny.rxwebsocket.message.chatroom;

import com.google.gson.annotations.SerializedName;

/**
 * Created by congwiny on 2016/2/20.
 */
public class BaseChatModel {


    protected BaseChatModel() {
    }

    @SerializedName("room_id")
    protected int roomId;

    @SerializedName("type")
    protected int type;

}
