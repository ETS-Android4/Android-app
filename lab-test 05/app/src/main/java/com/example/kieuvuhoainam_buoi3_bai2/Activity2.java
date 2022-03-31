package com.example.kieuvuhoainam_buoi3_bai2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        final EditText receiveValueEdit = (EditText) findViewById(R.id.value_receive);
        final Button callReceiverButton = (Button) findViewById(R.id.call_button);
        Bundle receiveBundle = this.getIntent().getExtras();
        final long receiveValue = receiveBundle.getLong("value");
//Hiển thị giá trị lấy về trên EdiText
        receiveValueEdit.setText(String.valueOf(receiveValue));
// Gởi giá trị đến BroadCastReceiver
        callReceiverButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
//Khởi tạo 1 Intent để gửi tới BroadCast Receiver
//Gắn giá trị vào Intent, lần này không cần Bundle nữa (dùng hàm putExtra
                Intent i = new Intent(Activity2.this, Receiver.class);
                i.putExtra("new value", receiveValue - 10);
                sendBroadcast(i);
            }
        });
    }
}