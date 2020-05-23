package com.example.myapplication.DangKiTOTP;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.ApiService;
import com.example.myapplication.ConnectApiServer;
import com.example.myapplication.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThongTinDangKyTOTP extends AppCompatActivity {

    Button btn_tieptuc;
    ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtindangky_totp);
        apiService = ConnectApiServer.getClient().create(ApiService.class);
        initView();
        initListener();
    }

    public void initView() {
        btn_tieptuc = findViewById(R.id.btn_tieptuc);
    }

    private void initListener() {
        btn_tieptuc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ThongtindangkyOTPmodelTruyenVao thongtindangkyOTPmodelTruyenVao = new ThongtindangkyOTPmodelTruyenVao("12345"
                        , "register", new ThongtindangkyOTPmodelTruyenVao.Detail("register", "quang1234123111142", "Quang"));
                Call<ThongtindangkyOTPmodelTruyenRa> call = apiService.apiDangKyOTP(thongtindangkyOTPmodelTruyenVao);
                call.enqueue(new Callback<ThongtindangkyOTPmodelTruyenRa>() {
                    public void onResponse(Call<ThongtindangkyOTPmodelTruyenRa> call, Response<ThongtindangkyOTPmodelTruyenRa> response) {
                        Log.d("onResponse", "onResponse: " +response.toString());
                    }

                    public void onFailure(Call<ThongtindangkyOTPmodelTruyenRa> call, Throwable t) {
                        Log.d("onResponse", "onResponse: " +t.toString());
                    }
                });
                launchActivity();
            }
        });
    }

    private void launchActivity() {
        Intent intent = new Intent(this, ThongTinDangKyQRCode.class);
        startActivity(intent);
    }
}
