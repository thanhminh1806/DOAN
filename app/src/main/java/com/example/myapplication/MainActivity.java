package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.myapplication.ChuyenTien.ChuyenTien;
import com.example.myapplication.DangKiTOTP.ThongTinDangKyTOTP;
import com.example.myapplication.HuyDangKyTOTP.HuyDangKyTOTP;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout_chuyentien, layout_dangkiTOTP, layout_huydangkiTOTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ApiService  apiService = ConnectApiServer.getClient().create(ApiService.class);
        initView();
        initListener();
    }

    public void initView(){
        layout_chuyentien = findViewById(R.id.layout_chuyentien);
        layout_dangkiTOTP = findViewById(R.id.layout_dangkiTOTP);
        layout_huydangkiTOTP = findViewById(R.id.layout_huydangkiTOTP);
    }

    public void initListener(){
        layout_chuyentien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChuyenTien();
            }
        });

        layout_dangkiTOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDangKyTOTP();
            }
        });

        layout_huydangkiTOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHuyDangKyTOTP();
            }
        });
    }

    private void openDangKyTOTP() {
        Intent intent = new Intent(this, ThongTinDangKyTOTP.class);
        startActivity(intent);
    }

    private void openHuyDangKyTOTP() {
        Intent intent = new Intent(this, HuyDangKyTOTP.class);
        startActivity(intent);
    }

    private void openChuyenTien() {
        Intent intent = new Intent(this, ChuyenTien.class);
        startActivity(intent);
    }
}
