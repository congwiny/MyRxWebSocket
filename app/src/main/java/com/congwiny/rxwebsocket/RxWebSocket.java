package com.congwiny.rxwebsocket;

import com.congwiny.rxwebsocket.event.ConnEvent;
import com.congwiny.rxwebsocket.exception.WebSocketCloseException;
import com.congwiny.rxwebsocket.event.MessageBinaryEvent;
import com.congwiny.rxwebsocket.event.ConnOpenEvent;
import com.congwiny.rxwebsocket.event.MessageRawTextEvent;
import com.congwiny.rxwebsocket.event.MessageTextEvent;


import java.util.concurrent.TimeUnit;

import de.tavendo.autobahn.WebSocketConnection;
import de.tavendo.autobahn.WebSocketException;
import de.tavendo.autobahn.WebSocketHandler;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by congwiny on 16/8/14.
 */
public class RxWebSocket {
    private static final String TAG = RxWebSocket.class.getSimpleName();
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
                            System.out.println("websocket onClose");
                            // subscriber.onNext(new ConnCloseEvent(code, reason));
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
                    subscriber.onError(e);
                }
            }
        })
                .retryWhen(repeatDuration(3, TimeUnit.SECONDS))
                .doOnUnsubscribe(new Action0() {
                    @Override
                    public void call() {
                        mConnection.disconnect();
                    }
                });
    }

    private Func1<Observable<? extends Throwable>, Observable<?>> repeatDuration(final long delay,
                                                                                 final TimeUnit timeUnit) {
        return new Func1<Observable<? extends Throwable>, Observable<?>>() {
            @Override
            public Observable<?> call(Observable<? extends Throwable> attemps) {
                return attemps
                        .flatMap(new Func1<Throwable, Observable<?>>() {
                            @Override
                            public Observable<?> call(Throwable aLong) {
                                if (aLong instanceof WebSocketCloseException) {
                                    return Observable.timer(delay, timeUnit, Schedulers.io());
                                }
                                return Observable.error(aLong);
                            }
                        });
            }
        };
    }


    public WebSocketConnection getWebSocketConn() {
        return mConnection;
    }

    public void sendTextMessage(String message) {
        mConnection.sendTextMessage(message);
    }
}
