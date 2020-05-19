package com.example.myapplication.DangKiTOTP;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class ThongTinDangKyTOTP extends AppCompatActivity {

    Button btn_tieptuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtindangky_totp);
//        ApiService  apiService = ConnectApiServer.getClient().create(ApiService.class);
        initView();
    }

    public void initView(){
        btn_tieptuc = findViewById(R.id.btn_tieptuc);
    }
}
