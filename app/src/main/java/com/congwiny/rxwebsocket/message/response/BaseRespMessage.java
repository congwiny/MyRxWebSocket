package com.congwiny.rxwebsocket.message.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by congwiny on 2016/8/15.
 */
public abstract class BaseRespMessage<T> {

    @SerializedName("event")
    protected int event;


    @SerializedName("type")
    protected String type;

    public abstract T convertToModel();
}
