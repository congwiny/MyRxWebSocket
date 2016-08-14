package com.congwiny.rxwebsocket.event;

import de.tavendo.autobahn.WebSocketConnection;

/**
 * Created by congwiny on 16/8/14.
 */
public class MessageRawTextEvent extends MessageEvent{
    public byte[] payload;

    public MessageRawTextEvent(WebSocketConnection connection,byte[]payload) {
        super(connection);
        this.payload = payload;
    }
}
