package com.example.myapplication.HuyDangKyTOTP;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.DangKiTOTP.ThongTinDangKyQRCode;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class HuyDangKyTOTP extends AppCompatActivity {
    Button btn_tatdangkytotp;
    ImageView img_backmain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.huydangky_totp);
//        ApiService  apiService = ConnectApiServer.getClient().create(ApiService.class);
        initView();
        initListener();
    }

    public void initView() {
        btn_tatdangkytotp = findViewById(R.id.btn_tatdangkytotp);
        img_backmain = findViewById(R.id.img_backmain);
    }

    private void initListener() {
        btn_tatdangkytotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity();
            }
        });

        img_backmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backMainMenu();
            }
        });
    }

    private void launchActivity() {
        Intent intent = new Intent(this, XacThucHuyDangKyTOTP.class);
        startActivity(intent);
    }

    private void backMainMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
