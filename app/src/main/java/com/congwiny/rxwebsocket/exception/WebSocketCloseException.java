package com.congwiny.rxwebsocket.exception;

import java.io.IOException;

/**
 * Created by congwiny on 16/8/14.
 */
public class WebSocketCloseException extends IOException {
    private final int code;
    private final String reason;

    public WebSocketCloseException(int code, String reason){
        this.code = code;
        this.reason = reason;
    }

    public int getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }
}
