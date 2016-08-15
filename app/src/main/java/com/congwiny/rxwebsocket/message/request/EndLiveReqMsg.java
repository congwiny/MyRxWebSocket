package com.congwiny.rxwebsocket.message.request;

import com.congwiny.rxwebsocket.constants.EventType;
import com.google.gson.annotations.SerializedName;

/**
 * Created by congwiny on 2016/8/15.
 */
public class EndLiveReqMsg extends BaseReqMessage {
    @SerializedName("user_id")
    private int userId;
    @SerializedName("room_id")
    private int roomId;
    @SerializedName("live_id")
    private int liveId;

    public EndLiveReqMsg() {
        event = EventType.END_LIVE_REQ;
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

    public int getLiveId() {
        return liveId;
    }

    public void setLiveId(int liveId) {
        this.liveId = liveId;
    }
}
