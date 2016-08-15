package com.congwiny.rxwebsocket;

import com.congwiny.rxwebsocket.event.ConnEvent;
import com.congwiny.rxwebsocket.event.MessageTextEvent;
import com.congwiny.rxwebsocket.message.response.BaseRespMessage;
import com.congwiny.rxwebsocket.utils.RespMsgMaker;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by congwiny on 2016/8/15.
 */
public class RxRespWebSocket {

    private final RxWebSocket mRxWebSocket;

    public RxRespWebSocket(RxWebSocket rxWebSocket) {
        this.mRxWebSocket = rxWebSocket;
    }

    public Observable<BaseRespMessage> webSocketObservable() {
        return mRxWebSocket.webSocketObserable()
                .lift(new Observable.Operator<BaseRespMessage, ConnEvent>() {
                    @Override
                    public Subscriber<? super ConnEvent> call(final Subscriber<? super BaseRespMessage> subscriber) {
                        return new Subscriber<ConnEvent>(subscriber) {
                            @Override
                            public void onCompleted() {
                                subscriber.onCompleted();
                            }

                            @Override
                            public void onError(Throwable e) {
                                subscriber.onError(e);
                            }

                            @Override
                            public void onNext(ConnEvent connEvent) {
                                switch (connEvent.getEventType()) {
                                    case ConnEvent.CONN_OPEN_EVENT:

                                        String message = "{\n" +
                                                "    \"type\": 7,\n" +
                                                "    \"user_id\": 100015\n" +
                                                "}";

                                        mRxWebSocket.sendTextMessage(message);
                                        break;
                                    case ConnEvent.CONN_CLOSE_EVENT:
                                        break;
                                    case ConnEvent.MESSAGE_BINARY_EVENT:
                                        break;
                                    case ConnEvent.MESSAGE_RAW_EVENT:
                                        break;
                                    case ConnEvent.MESSAGE_TEXT_EVENT:
                                        //parse message
                                        MessageTextEvent messageTextEvent = (MessageTextEvent) connEvent;
                                        subscriber.onNext(parseMessage(messageTextEvent.payload));
                                        break;
                                    default:
                                        throw new RuntimeException("Unknown message type");
                                }
                            }

                            private BaseRespMessage parseMessage(String message) {
                                try {
                                    return RespMsgMaker.fromJson(message);
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            }

                        };
                    }
                });
    }

}
