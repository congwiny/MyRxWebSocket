package com.congwiny.rxwebsocket.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.congwiny.rxwebsocket.RxRespWebSocket;
import com.congwiny.rxwebsocket.RxWebSocket;
import com.congwiny.rxwebsocket.constants.ApiConstants;
import com.congwiny.rxwebsocket.event.ConnEvent;
import com.congwiny.rxwebsocket.event.MessageTextEvent;
import com.congwiny.rxwebsocket.message.response.BaseRespMessage;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MessageService extends Service {

    public static final String ACTION_START_SERVICE = "action_start_service";
    public static final String ACTION_STOP_SERVICE = "action_stop_service";
    public static final String ACTION_SEND_MESSAGE = "action_send_message";

    private static final String TAG = MessageService.class.getSimpleName();

    private RxWebSocket mRxWebSocket = new RxWebSocket(ApiConstants.WS_URI);

    private Subscription mSub;

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

       // subscribeWebSocketJson();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && intent.getAction() != null) {
            switch (intent.getAction()) {
                case ACTION_START_SERVICE:
                    break;
                case ACTION_STOP_SERVICE:
                    break;
                case ACTION_SEND_MESSAGE:
                    sendTextMessage();
                    break;
            }
        }
        return START_STICKY;
    }

    private void sendTextMessage() {
        //随便发送点东西到服务器
        mRxWebSocket.sendTextMessage("abcd");
    }

    private void subscribeWebSocketJson() {

        RxRespWebSocket socket = new RxRespWebSocket(mRxWebSocket);

        mSub = socket.webSocketObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BaseRespMessage>() {
                    @Override
                    public void call(BaseRespMessage baseRespMessage) {
                        Log.e(TAG, "message=" + baseRespMessage);
                    }
                });

    }


    private void subscribeWebSocket() {
        mSub = mRxWebSocket.webSocketObserable()
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

                        switch (connEvent.getEventType()) {
                            case ConnEvent.CONN_OPEN_EVENT:
                                Log.e(TAG, "conn open event");
                                String message = "{\n" +
                                        "    \"type\": 7,\n" +
                                        "    \"user_id\": 100015\n" +
                                        "}";

                                Log.e(TAG, "message=" + message);
                                mRxWebSocket.sendTextMessage(message);
                                break;
                            case ConnEvent.CONN_CLOSE_EVENT:
                                break;
                            case ConnEvent.MESSAGE_BINARY_EVENT:
                                break;
                            case ConnEvent.MESSAGE_TEXT_EVENT:
                                MessageTextEvent textEvent = (MessageTextEvent) connEvent;
                                Log.e(TAG, "textEvent=" + textEvent.payload);
                                break;

                        }
                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (!mSub.isUnsubscribed()) {
            mSub.unsubscribe();
        }

    }
}
