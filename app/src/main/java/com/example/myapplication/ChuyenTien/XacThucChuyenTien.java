package com.example.myapplication.ChuyenTien;

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
import com.example.myapplication.DangKiTOTP.XacThucOTPTruyenra_Model;
import com.example.myapplication.DangKiTOTP.XacThucOTPTruyenvao_Model;
import com.example.myapplication.GlobalObject;
import com.example.myapplication.HuyDangKyTOTP.XacThucHuyDangKyTOTP;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class XacThucChuyenTien extends AppCompatActivity {
    Button btn_tieptuc;
    EditText edt_nhapma;
    ImageView img_backmain;
    ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xacthucchuyentien);
        apiService = ConnectApiServer.getClient().create(ApiService.class);
        initView();
        initListener();
    }

    private void initView() {
        btn_tieptuc = findViewById(R.id.btn_tieptuc);
        img_backmain = findViewById(R.id.img_backmain);
        edt_nhapma = findViewById(R.id.edt_nhapma);
    }

    private void initListener() {
        btn_tieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_nhapma.getText().toString().isEmpty()){
                    Toast.makeText(XacThucChuyenTien.this, "Vui lòng nhập mã xác thực", Toast.LENGTH_SHORT).show();
                }else {
                    XacThucOTPTruyenvao_Model xacThucOTPTruyenvao_model = new XacThucOTPTruyenvao_Model("12345"
                            , "auth", new XacThucOTPTruyenvao_Model.Detail("auth", GlobalObject.REGISTER_ID, edt_nhapma.getText().toString()));
                    Call<XacThucOTPTruyenra_Model> call = apiService.apiXacThucDangKyOTP(xacThucOTPTruyenvao_model);
                    call.enqueue(new Callback<XacThucOTPTruyenra_Model>() {
                        public void onResponse(Call<XacThucOTPTruyenra_Model> call, Response<XacThucOTPTruyenra_Model> response) {
                            Log.d("onResponse", "onResponse: " + response.toString());
                            if(response.body() != null && response.body().getDetail()!=null) {
                                if ("0".equals(response.body().getEc().toString())) {
                                    backMainMenu();
                                } else {

                                }
                            }else{
                                Toast.makeText(XacThucChuyenTien.this, "Sai mã xác thực", Toast.LENGTH_SHORT).show();
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
}
