package com.congwiny.rxwebsocket.message.response;

import com.congwiny.rxwebsocket.constants.EventType;

/**
 * Created by congwiny on 2016/8/15.
 */
public class ExceptionRespMsg extends BaseRespMessage {
    private Throwable error;
    private String message;

    public ExceptionRespMsg(String message, Throwable error) {
        event = EventType.ERROR;
        this.error = error;
        this.message = message;
    }


    public Throwable getError() {
        return error;
    }

    public void setError(Throwable error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Object convertToModel() {
        return null;
    }
}
