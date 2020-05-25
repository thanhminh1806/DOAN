package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.HuyDangKyTOTP.HuyDangKyTOTP;

public class LoginActivity extends AppCompatActivity {
    EditText txtUsername, txtPassword;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
//        ApiService  apiService = ConnectApiServer.getClient().create(ApiService.class);
        initView();
        initListener();
    }

    public void initView() {
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        btn_login = findViewById(R.id.btn_login);
    }

    public void initListener() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtUsername.getText().toString().isEmpty() || txtPassword.getText().toString().isEmpty()){
                    CustomDialog.showDialog(LoginActivity.this, getString(R.string.notification), getString(R.string.empty_username_password));
                }else{
                    openMainActivity();
                }

            }
        });
    }

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
