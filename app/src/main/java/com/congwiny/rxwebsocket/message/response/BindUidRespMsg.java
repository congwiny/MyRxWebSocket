package com.congwiny.rxwebsocket.message.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by congwiny on 2016/8/15.
 */
public class BindUidRespMsg extends BaseRespMessage {

    @SerializedName("code")
    protected int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public Object convertToModel() {
        return null;
    }
}
