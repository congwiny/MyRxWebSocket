package com.congwiny.rxwebsocket.message.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by congwiny on 2016/8/15.
 */
public class JoinRoomRespMsg extends BaseRespMessage {

    @SerializedName("user_id")
    private int userId;
    @SerializedName("room_id")
    private int roomId;
    @SerializedName("online_count")
    private int onlineCount;

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

    public int getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(int onlineCount) {
        this.onlineCount = onlineCount;
    }

    @Override
    public Object convertToModel() {
        return null;
    }
}
