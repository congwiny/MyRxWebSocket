package com.congwiny.rxwebsocket.utils;

import com.congwiny.rxwebsocket.constants.EventType;
import com.congwiny.rxwebsocket.constants.MessageType;
import com.congwiny.rxwebsocket.message.chatroom.PubChatModel;
import com.congwiny.rxwebsocket.message.response.BaseRespMessage;
import com.congwiny.rxwebsocket.message.response.BindUidRespMsg;
import com.congwiny.rxwebsocket.message.response.JoinRoomRespMsg;
import com.congwiny.rxwebsocket.message.response.LeaveRoomRespMsg;
import com.congwiny.rxwebsocket.message.response.PingRespMsg;
import com.congwiny.rxwebsocket.message.response.PubChatRespMsg;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;

/**
 * Created by congwiny on 2016/8/15.
 */
public class RespMsgMaker {

    public static BaseRespMessage fromJson(String json) throws Exception {
        BaseRespMessage baseModel = null;

        JSONObject object = new JSONObject(json);
        int event = object.getInt("event");
        switch (event) {
            case EventType.PING:
                baseModel = new Gson().fromJson(json, PingRespMsg.class);
                break;
            case EventType.BIND_USER_RESP:
                baseModel = new Gson().fromJson(json, BindUidRespMsg.class);
                break;
            case EventType.USER_JOIN_RESP:
                baseModel = new Gson().fromJson(json, JoinRoomRespMsg.class);
                break;
            case EventType.USER_LEAVE_RESP:
                baseModel = new Gson().fromJson(json, LeaveRoomRespMsg.class);
                break;
            case EventType.ONLINE_USER_RESP:
                // baseModel = new Gson().fromJson(json, OnlineUserRespMsg.class);
                break;
            case EventType.PUBLIC_MESSAGE_RESP:
                int type = object.getInt("type");
                switch (type) {
                    case MessageType.SYSTEM:
                        break;
                    case MessageType.LIKE:
                        break;
                    case MessageType.TEXT:
                        Gson gson = new Gson();
                        Type jsonType = new TypeToken<PubChatRespMsg<PubChatModel>>() {
                        }.getType();
                        baseModel = gson.fromJson(json, jsonType);
                        break;
                    case MessageType.GIFT:
                        break;
                    case MessageType.SHARED:
                        break;
                    case MessageType.STICKER:
                        break;
                }
                break;

            case EventType.PRIVATE_MESSAGE_RESP:
                break;
            case EventType.ERROR_RESP:
                break;
        }

        return baseModel;
    }
}
