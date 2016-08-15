package com.congwiny.rxwebsocket.event;

/**
 * Created by congwiny on 16/8/14.
 */
public abstract class ConnEvent {

    public static final int CONN_CLOSE_EVENT = 1;
    public static final int CONN_OPEN_EVENT = 2;
    public static final int MESSAGE_BINARY_EVENT = 3;
    public static final int MESSAGE_EVENT = 4;
    public static final int MESSAGE_RAW_EVENT = 5;
    public static final int MESSAGE_TEXT_EVENT = 6;

    protected int eventType;

    public ConnEvent(int eventType) {
        this.eventType = eventType;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }
}
