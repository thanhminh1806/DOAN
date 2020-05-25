package com.example.myapplication.DangKiTOTP;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.ApiService;
import com.example.myapplication.ChuyenTien.XacThucChuyenTien;
import com.example.myapplication.ConnectApiServer;
import com.example.myapplication.CustomDialog;
import com.example.myapplication.GlobalObject;
import com.example.myapplication.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThongTinDangKyTOTP extends AppCompatActivity {

    Button btn_tieptuc;
    ApiService apiService;

    String ImageBase64;
    String secretKey;

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
                        , "register", new ThongtindangkyOTPmodelTruyenVao.Detail("register", GlobalObject.REGISTER_ID, "Van98"));
                Call<ThongtindangkyOTPmodelTruyenRa> call = apiService.apiDangKyOTP(thongtindangkyOTPmodelTruyenVao);
                call.enqueue(new Callback<ThongtindangkyOTPmodelTruyenRa>() {
                    public void onResponse(Call<ThongtindangkyOTPmodelTruyenRa> call, Response<ThongtindangkyOTPmodelTruyenRa> response) {
                        Log.d("responseCode", "responseCode: " + response.code());

                        if(response.body() != null && response.body().getDetail()!=null) {
                            if ("0".equals(response.body().getEc().toString())) {
                                Log.d("onResponse", "onResponse: " + response.toString());
                                ImageBase64 = response.body().getDetail().getImageBase64();
                                secretKey = response.body().getDetail().getSecretKey();
                                openThongTinDangKyQRCode(ImageBase64, secretKey);
                            }
                        }else {
                            CustomDialog.showDialog(ThongTinDangKyTOTP.this, getString(R.string.notification), getString(R.string.TKDaDangKyTOTP));
                        }
                    }

                    public void onFailure(Call<ThongtindangkyOTPmodelTruyenRa> call, Throwable t) {
                        Log.d("onResponse", "onResponse: " + t.toString());
                    }
                });
            }
        });
    }

    private void openThongTinDangKyQRCode(String ImageBase64, String secretKey) {
        Intent intent = new Intent(this, ThongTinDangKyQRCode.class);
        intent.putExtra("ImageBase64", ImageBase64);
        intent.putExtra("secretKey", secretKey);
        startActivity(intent);
    }
}
