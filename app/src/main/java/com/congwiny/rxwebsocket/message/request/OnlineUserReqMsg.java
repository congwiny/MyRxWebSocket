package com.congwiny.rxwebsocket.message.request;

import com.congwiny.rxwebsocket.constants.EventType;
import com.google.gson.annotations.SerializedName;

/**
 * Created by congwiny on 2016/8/15.
 */
public class OnlineUserReqMsg extends BaseReqMessage {

    @SerializedName("page")
    private int page;
    @SerializedName("size")
    private int size;
    @SerializedName("room_id")
    private int roomId;

    public OnlineUserReqMsg(){
        event = EventType.ONLINE_USER_REQ;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
