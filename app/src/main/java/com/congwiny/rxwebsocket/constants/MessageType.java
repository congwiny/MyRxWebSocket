package com.congwiny.rxwebsocket.constants;

/**
 * Created by congwiny on 2016/8/15.
 */
public class MessageType {

    public static final int SYSTEM = 100;
    public static final int TEXT = 200;
    public static final int LIKE = 300;
    public static final int GIFT = 400;
    public static final int SHARED = 500;
    public static final int STICKER = 600;

    public static class SystemMsgType {
        public static final int NOTICE = 101;
        public static final int FOLLOW = 102;
        public static final int BANNED = 103;
        public static final int JOIN = 104;
        public static final int HOST_LEAVE = 105;
        public static final int HOST_BACK = 106;

    }
}
