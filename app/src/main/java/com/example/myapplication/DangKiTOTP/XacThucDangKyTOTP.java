package com.example.myapplication.DangKiTOTP;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.ApiService;
import com.example.myapplication.ConnectApiServer;
import com.example.myapplication.CustomDialog;
import com.example.myapplication.GlobalObject;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.ThanhCongActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class XacThucDangKyTOTP extends AppCompatActivity {
    Button btn_tieptuc;
    ImageView img_backmain;
    ApiService apiService;
    EditText edt_nhapma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xacthucdangky_totp);
        apiService = ConnectApiServer.getClient().create(ApiService.class);
        initView();
        initListener();
    }

    public void initView() {
        btn_tieptuc = findViewById(R.id.btn_tieptuc);
        img_backmain = findViewById(R.id.img_backmain);
        edt_nhapma = findViewById(R.id.edt_nhapma);
    }

    private void initListener() {
        btn_tieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_nhapma.getText().toString().isEmpty()){
                    CustomDialog.showDialog(XacThucDangKyTOTP.this, getString(R.string.notification), getString(R.string.NhapMaXacThuc));
                }else {
                    XacThucOTPTruyenvao_Model xacThucOTPTruyenvao_model = new XacThucOTPTruyenvao_Model("12345"
                            , "auth", new XacThucOTPTruyenvao_Model.Detail("auth", GlobalObject.REGISTER_ID, edt_nhapma.getText().toString()));
                    Call<XacThucOTPTruyenra_Model> call = apiService.apiXacThucDangKyOTP(xacThucOTPTruyenvao_model);
                    call.enqueue(new Callback<XacThucOTPTruyenra_Model>() {
                        public void onResponse(Call<XacThucOTPTruyenra_Model> call, Response<XacThucOTPTruyenra_Model> response) {
                            Log.d("onResponse", "onResponse: " + response.toString());
                            if(response.body() != null && response.body().getDetail()!=null) {
                                if ("0".equals(response.body().getEc().toString())) {
                                    openHuyThanhCongActivity("2");
                                } else {

                                }
                            }else{
                                CustomDialog.showDialog(XacThucDangKyTOTP.this, getString(R.string.notification), getString(R.string.SaiMaXacThuc));
                            }
                        }

                        public void onFailure(Call<XacThucOTPTruyenra_Model> call, Throwable t) {
                            Log.d("onResponse", "onResponse: " + t.toString());
                        }
                    });
                }
            }
        });

        img_backmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backMainMenu();
            }
        });
    }

    private void backMainMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void openHuyThanhCongActivity(String type) {
        Intent intent = new Intent(this, ThanhCongActivity.class);
        intent.putExtra("type", type);
        startActivity(intent);
    }
}
