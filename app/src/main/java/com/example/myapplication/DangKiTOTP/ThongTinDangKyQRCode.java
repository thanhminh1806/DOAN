package com.example.myapplication.DangKiTOTP;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.ApiService;
import com.example.myapplication.ConnectApiServer;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class ThongTinDangKyQRCode extends AppCompatActivity {
    Button btn_tieptuc;
    ImageView img_backmain, img_qrcode;
    TextView tv_secretkey;
    String ImageBase64, secretKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtindangky_qrcode);
//        ApiService apiService = ConnectApiServer.getClient().create(ApiService.class);
        ImageBase64 = getIntent().getStringExtra("ImageBase64");
        secretKey = getIntent().getStringExtra("secretKey");
        Log.d("secretKey", "onCreate: "+secretKey);
        initView();
        initListener();
        byte[] imageBytes = Base64.decode(ImageBase64, Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        img_qrcode.setImageBitmap(decodedImage);

        SpannableString spanString = new SpannableString(secretKey);
        spanString.setSpan(new UnderlineSpan(), 0, spanString.length(), 0);
        tv_secretkey.setText(spanString);
    }

    public void initView(){
        btn_tieptuc = findViewById(R.id.btn_tieptuc);
        img_backmain = findViewById(R.id.img_backmain);
        tv_secretkey = findViewById(R.id.tv_secretkey);
        img_qrcode = findViewById(R.id.img_qrcode);
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
