package com.example.myapplication.DangKiTOTP;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.ApiService;
import com.example.myapplication.ConnectApiServer;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class ThongTinDangKyQRCode extends AppCompatActivity {
    Button btn_tieptuc;
    ImageView img_backmain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtindangky_qrcode);
//        ApiService apiService = ConnectApiServer.getClient().create(ApiService.class);
        initView();
        initListener();
    }

    public void initView(){
        btn_tieptuc = findViewById(R.id.btn_tieptuc);
        img_backmain = findViewById(R.id.img_backmain);
    }

    private void initListener() {
        btn_tieptuc.setOnClickListener(new View.OnClickListener() {
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
        Intent intent = new Intent(this, XacThucDangKyTOTP.class);
        startActivity(intent);
    }

    private void backMainMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
