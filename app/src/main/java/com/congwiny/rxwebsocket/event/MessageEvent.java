package com.congwiny.rxwebsocket.event;

import de.tavendo.autobahn.WebSocketConnection;

/**
 * Created by congwiny on 16/8/14.
 */
public class MessageEvent extends ConnEvent{
    private WebSocketConnection mConnection;

    public MessageEvent(WebSocketConnection mConnection) {
        this.mConnection = mConnection;
    }

    public WebSocketConnection getWebSocketConn(){
        return mConnection;
    }

}
