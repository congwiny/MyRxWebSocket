package com.congwiny.rxwebsocket.message.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by congwiny on 2016/8/15.
 */
public class LeaveRoomRespMsg extends BaseRespMessage{

    @SerializedName("user_id")
    private int userId;
    @SerializedName("room_id")
    private int roomId;
    @SerializedName("online_count")
    private int onlineCount;

    @Override
    public Object convertToModel() {
        return null;
    }
}
