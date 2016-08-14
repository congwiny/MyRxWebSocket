package com.congwiny.rxwebsocket.event;

import de.tavendo.autobahn.WebSocketConnection;

/**
 * Created by congwiny on 16/8/14.
 */
public class MessageBinaryEvent extends MessageEvent {
    public byte[] payload;

    public MessageBinaryEvent(WebSocketConnection connection, byte[] payload) {
        super(connection);
        this.payload = payload;
    }
}
