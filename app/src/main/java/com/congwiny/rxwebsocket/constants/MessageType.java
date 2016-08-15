package com.congwiny.rxwebsocket.constants;

/**
 * Created by congwiny on 2016/8/15.
 */
public class MessageType {

    /**
     * SYSTEM = 1 # 系统消息
     * PUBLIC = 2 # 广播消息， 房间内群聊
     * LIKE = 3 # 标记喜欢
     * GIFT = 4 # 赠送礼物
     * SHARED = 5 #
     * STICKER = 6
     * BIND_USER = 7 # 绑定用户
     * PING = 8 # 心跳检测
     */
    public static final int SYSTEM = 1;
    public static final int PUBLIC = 2;
    public static final int LIKE = 3;
    public static final int GIFT = 4;
    public static final int SHARED = 5;
    public static final int STICKER = 6;
    public static final int BIND_USER = 7;
    public static final int PING = 8;

    public static final int ERROR = 0;

    public static class SystemMsgType {
        /**
         * 在 type 为 1 时, sys_type 取值
         * NOTICE = 11
         * FOLLOW = 12 # 关注
         * BANNED = 13 # 禁用户
         * JOIN = 14 # 进入房间
         * HOST_LEAVE = 15 # 主播离开
         * HOST_BACK = 16 # 主播回到房间
         * <p/>
         * UNFOLLOW = 17 # 取消关注
         * LEAVE = 18 # 用户离开房间
         * START_LIVE = 19 # 开始直播
         * END_LIVE = 20 # 结束直播
         */
        public static final int NOTICE = 11;
        public static final int FOLLOW = 12;
        public static final int BANNED = 13;
        public static final int JOIN = 14;
        public static final int HOST_LEAVE = 15;
        public static final int HOST_BACK = 16;
        public static final int UNFOLLOW = 17;
        public static final int LEAVE = 18;
        public static final int START_LIVE = 19;
        public static final int END_LIVE = 20;

    }

}
