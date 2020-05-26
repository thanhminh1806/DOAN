package com.example.myapplication.HuyDangKyTOTP;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
                showDialog(HuyDangKyTOTP.this, getString(R.string.notification), getString(R.string.huy_dich_vu_xac_thuc));
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

    public void showDialog(Context context, String title, String message) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setTitle(title);
        builder1.setMessage(message);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                getString(R.string.DongY),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        launchActivity();
                    }
                });

        builder1.setNegativeButton(
                getString(R.string.Huy),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        backMainMenu();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}
