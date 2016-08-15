package com.congwiny.rxwebsocket.message.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by congwiny on 2016/8/15.
 */
public abstract class BaseReqMessage {

    @SerializedName("type")
    protected int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
