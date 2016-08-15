package com.congwiny.rxwebsocket.message.request;

import com.congwiny.rxwebsocket.constants.MessageType;
import com.google.gson.annotations.SerializedName;

/**
 * Created by congwiny on 2016/8/15.
 */
public class JoinRoomReqMsg extends BaseReqMessage {

    @SerializedName("user_id")
    private int userId;
    @SerializedName("room_id")
    private int roomId;
    @SerializedName("sys_type")
    protected int sysType;


    public JoinRoomReqMsg() {
        type = MessageType.SYSTEM;
        sysType = MessageType.SystemMsgType.JOIN;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
