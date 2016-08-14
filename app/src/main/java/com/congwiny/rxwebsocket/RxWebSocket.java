package com.congwiny.rxwebsocket;

import com.congwiny.rxwebsocket.event.ConnEvent;
import com.congwiny.rxwebsocket.exception.WebSocketCloseException;
import com.congwiny.rxwebsocket.event.MessageBinaryEvent;
import com.congwiny.rxwebsocket.event.ConnCloseEvent;
import com.congwiny.rxwebsocket.event.MessageEvent;
import com.congwiny.rxwebsocket.event.ConnOpenEvent;
import com.congwiny.rxwebsocket.event.MessageRawTextEvent;
import com.congwiny.rxwebsocket.event.MessageTextEvent;


import de.tavendo.autobahn.WebSocketConnection;
import de.tavendo.autobahn.WebSocketException;
import de.tavendo.autobahn.WebSocketHandler;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by congwiny on 16/8/14.
 */
public class RxWebSocket {
    private final WebSocketConnection mConnection = new WebSocketConnection();

    private String mWsUri;

    public RxWebSocket(String wsUri) {
        mWsUri = wsUri;
    }

    public Observable<ConnEvent> webSocketObserable() {
        return Observable.create(new Observable.OnSubscribe<ConnEvent>() {
            @Override
            public void call(final Subscriber<? super ConnEvent> subscriber) {
                try {
                    mConnection.connect(mWsUri, new WebSocketHandler() {
                        @Override
                        public void onOpen() {
                            subscriber.onNext(new ConnOpenEvent());
                        }

                        @Override
                        public void onClose(int code, String reason) {
                            super.onClose(code, reason);
                            subscriber.onNext(new ConnCloseEvent(code, reason));
                            subscriber.onError(new WebSocketCloseException(code, reason));
                        }

                        @Override
                        public void onTextMessage(String payload) {

                            //payload 有点--可能是错误。。
                            subscriber.onNext(new MessageTextEvent(mConnection, payload));
                        }

                        @Override
                        public void onRawTextMessage(byte[] payload) {
                            subscriber.onNext(new MessageRawTextEvent(mConnection, payload));
                        }

                        @Override
                        public void onBinaryMessage(byte[] payload) {
                            subscriber.onNext(new MessageBinaryEvent(mConnection, payload));
                        }
                    });
                } catch (WebSocketException e) {
                    e.printStackTrace();
                    //subscriber.onError(e);
                }
            }
        });
    }
}
