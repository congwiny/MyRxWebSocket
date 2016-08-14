package com.congwiny.rxwebsocket.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.congwiny.rxwebsocket.RxWebSocket;
import com.congwiny.rxwebsocket.constants.ApiConstants;
import com.congwiny.rxwebsocket.event.ConnEvent;

import de.tavendo.autobahn.WebSocketConnection;
import de.tavendo.autobahn.WebSocketException;
import de.tavendo.autobahn.WebSocketHandler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MessageService extends Service {

    private static final String TAG = MessageService.class.getSimpleName();
    private final WebSocketConnection mConnection = new WebSocketConnection();

    private RxWebSocket mRxWebSocket = new RxWebSocket(ApiConstants.WS_URI);

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //start();

        subscribeWebSocket();
    }

    private void subscribeWebSocket() {
        mRxWebSocket.webSocketObserable()
                .subscribe(new Subscriber<ConnEvent>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError=" + e);
                    }

                    @Override
                    public void onNext(ConnEvent connEvent) {
                        Log.e(TAG, "onNext=" + connEvent);
                    }
                });
    }


    private void start() {

        final String wsuri = "ws://47.89.37.30:7272";

        try {
            mConnection.connect(wsuri, new WebSocketHandler() {

                @Override
                public void onOpen() {
                    Log.e(TAG, "Status: Connected to " + wsuri);
                    mConnection.sendTextMessage("Hello, world!");
                }

                @Override
                public void onTextMessage(String payload) {
                    Log.e(TAG, "Got echo: " + payload);
                }

                @Override
                public void onClose(int code, String reason) {
                    Log.e(TAG, "Connection lost.");
                }

                @Override
                public void onBinaryMessage(byte[] payload) {
                    super.onBinaryMessage(payload);
                }

                @Override
                public void onRawTextMessage(byte[] payload) {
                    super.onRawTextMessage(payload);
                }
            });
        } catch (WebSocketException e) {

            Log.e(TAG, "exception = " + e.toString());
        }
    }

}
