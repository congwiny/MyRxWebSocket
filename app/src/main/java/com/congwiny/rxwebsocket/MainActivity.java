package com.congwiny.rxwebsocket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.congwiny.rxwebsocket.service.MessageService;

public class MainActivity extends AppCompatActivity {

    private Button mSendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent();
        intent.setClass(this, MessageService.class);
        startService(intent);

        initView();
    }

    private void initView() {
        mSendBtn = (Button) findViewById(R.id.btn_send);
        mSendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessageService.ACTION_SEND_MESSAGE);
                intent.setClass(MainActivity.this, MessageService.class);
                startService(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent();
        intent.setClass(this, MessageService.class);

        stopService(intent);
    }
}
