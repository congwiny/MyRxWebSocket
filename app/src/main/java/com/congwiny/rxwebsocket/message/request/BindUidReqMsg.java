package com.congwiny.rxwebsocket.message.request;

import com.congwiny.rxwebsocket.constants.EventType;
import com.google.gson.annotations.SerializedName;

/**
 * Created by congwiny on 2016/8/15.
 */
public class BindUidReqMsg extends BaseReqMessage {
    @SerializedName("user_id")
    protected int userId;

    public BindUidReqMsg() {
        event = EventType.BIND_USER_REQ;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
