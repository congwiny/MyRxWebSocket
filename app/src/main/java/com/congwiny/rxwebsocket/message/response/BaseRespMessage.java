package com.congwiny.rxwebsocket.message.response;

import com.congwiny.rxwebsocket.constants.MessageType;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;

/**
 * Created by congwiny on 2016/8/15.
 */
public abstract class BaseRespMessage<T> {

    @SerializedName("type")
    protected int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public abstract T convertToModel();

    public static class Deserializer implements JsonDeserializer<BaseRespMessage> {

        @Override
        public BaseRespMessage deserialize(JsonElement jsonElement,
                                           Type type,
                                           JsonDeserializationContext jsonDeserializationContext)
                throws JsonParseException {
            final JsonObject jsonObject = jsonElement.getAsJsonObject();
            final JsonElement typeElement = jsonObject.get("type");
            if (typeElement == null) {
                throw new JsonParseException("No \"type\" field in reference");
            }
            int messageType = typeElement.getAsInt();

            switch (messageType) {
                case MessageType.PING:
                    return jsonDeserializationContext.deserialize(jsonObject, PingRespMsg.class);
                case MessageType.BIND_USER:
                    return jsonDeserializationContext.deserialize(jsonObject, BindUidRespMsg.class);
                case MessageType.GIFT:
                    return jsonDeserializationContext.deserialize(jsonObject, GiftRespMsg.class);
                case MessageType.LIKE:
                    return jsonDeserializationContext.deserialize(jsonObject, LikeRespMsg.class);
                case MessageType.SHARED:
                    return jsonDeserializationContext.deserialize(jsonObject, SharedRespMsg.class);
                case MessageType.STICKER:
                    return jsonDeserializationContext.deserialize(jsonObject, StickerRespMsg.class);
                case MessageType.PUBLIC:
                    return jsonDeserializationContext.deserialize(jsonObject, PubChatRespMsg.class);
                case MessageType.SYSTEM:
                    return jsonDeserializationContext.deserialize(jsonObject, SysRespMsg.class);
                case MessageType.ERROR:
                    //这个暂时不用解析
                    return jsonDeserializationContext.deserialize(jsonObject, ExceptionRespMsg.class);
                default:
                    throw new JsonParseException("Unknown type " + messageType);
            }

        }
    }
}
