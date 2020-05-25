package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThanhCongActivity extends AppCompatActivity {
    TextView tv_message;
    Button btn_tieptuc;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thanhcong);
        //type 1: Chuyen tien, type 2: dang ky, type 3: huy dang ky
        type = getIntent().getStringExtra("type");
        initView();
        initListener();
        if(type.equals("1")){
            tv_message.setText(getString(R.string.success_chuyentien));
        }else if(type.equals("2")){
            tv_message.setText(getString(R.string.success_dangky));
        }else{
            tv_message.setText(getString(R.string.success_huydangky));
        }
    }

    private void initView() {
        tv_message = findViewById(R.id.tv_message);
        btn_tieptuc = findViewById(R.id.btn_tieptuc);
    }


    private void initListener() {
        btn_tieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });
    }


    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
