package com.congwiny.rxwebsocket.message.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by congwiny on 2016/8/15.
 */
public class EndLiveRespMsg extends BaseRespMessage {

    @SerializedName("user_id")
    private int userId;
    @SerializedName("room_id")
    private int roomId;
    @SerializedName("live_id")
    private int liveId;

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

    @Override
    public Object convertToModel() {
        return null;
    }


}
