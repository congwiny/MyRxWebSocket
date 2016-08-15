package com.congwiny.rxwebsocket.parser;

import com.congwiny.rxwebsocket.exception.ObjectParseException;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;


public class GsonObjectSerializer implements ObjectSerializer {


    private final Gson gson;

    private final Type typeOfT;

    public GsonObjectSerializer(Gson gson, Type typeOfT) {
        this.gson = gson;
        this.typeOfT = typeOfT;
    }


    @Override
    public Object serialize(String message) throws ObjectParseException {
        try {
            return gson.fromJson(message, typeOfT);
        } catch (JsonParseException e) {
            throw new ObjectParseException("Could not parse", e);
        }
    }


    @Override
    public Object serialize(byte[] message) throws ObjectParseException {
        throw new ObjectParseException("Could not parse binary messages");
    }


    @Override
    public byte[] deserializeBinary(Object message) throws ObjectParseException {
        throw new IllegalStateException("Only serialization to string is available");
    }


    @Override
    public String deserializeString(Object message) throws ObjectParseException {
        try {
            return gson.toJson(message);
        } catch (JsonParseException e) {
            throw new ObjectParseException("Could not parse", e);
        }
    }

    @Override
    public boolean isBinary(Object message) {
        return false;
    }
}