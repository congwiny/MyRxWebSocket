package com.congwiny.rxwebsocket.message.request;

import com.congwiny.rxwebsocket.constants.EventType;
import com.google.gson.annotations.SerializedName;

/**
 * Created by congwiny on 2016/8/15.
 */
public class LeaveRoomReqMsg extends BaseReqMessage{
    @SerializedName("user_id")
    private int userId;
    @SerializedName("room_id")
    private int roomId;

    public LeaveRoomReqMsg(){
        event = EventType.LEAVE_ROOM_REQ;
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
