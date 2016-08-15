package com.congwiny.rxwebsocket.event;

import de.tavendo.autobahn.WebSocketConnection;

/**
 * Created by congwiny on 16/8/14.
 */
public class MessageTextEvent extends MessageEvent {
    public String payload;


    public MessageTextEvent(WebSocketConnection connection, String payload) {
        super(connection, MESSAGE_TEXT_EVENT);
        this.payload = payload;
    }

}
