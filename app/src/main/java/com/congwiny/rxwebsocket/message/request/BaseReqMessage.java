package com.congwiny.rxwebsocket.message.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by congwiny on 2016/8/15.
 */
public abstract class BaseReqMessage {

    @SerializedName("event")
    protected int event;

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }
}
