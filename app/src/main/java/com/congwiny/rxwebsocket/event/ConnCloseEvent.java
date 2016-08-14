package com.congwiny.rxwebsocket.event;

/**
 * Created by congwiny on 16/8/14.
 */
public class ConnCloseEvent extends ConnEvent {

    public int code;
    public String reason;

    public ConnCloseEvent(int code, String reason) {
        this.code = code;
        this.reason = reason;
    }
}
