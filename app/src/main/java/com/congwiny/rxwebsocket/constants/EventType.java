package com.congwiny.rxwebsocket.constants;

/**
 * Created by congwiny on 2016/8/15.
 */
public class EventType {

    public static final int PING = 1000;
    public static final int PONG = 1001;
    public static final int BIND_USER_REQ = 1002;
    public static final int BIND_USER_RESP = 1003;

    public static final int JOIN_ROOM_REQ = 2000;
    public static final int LEAVE_ROOM_REQ = 2001;
    public static final int USER_JOIN_RESP = 2002;
    public static final int USER_LEAVE_RESP = 2003;

    public static final int ONLINE_USER_REQ = 2004;
    public static final int ONLINE_USER_RESP = 2005;

    public static final int PUBLIC_MESSAGE_REQ = 3000;
    public static final int PUBLIC_MESSAGE_RESP = 3001;
    public static final int PRIVATE_MESSAGE_REQ = 3002;
    public static final int PRIVATE_MESSAGE_RESP = 3003;

    public static final int START_LIVE_REQ = 4000;
    public static final int END_LIVE_REQ = 4001;


    public static final int ERROR_RESP = 9999;

    public static final int ERROR = 0;
}
