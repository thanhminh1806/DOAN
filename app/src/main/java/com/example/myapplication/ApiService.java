package com.example.myapplication;

import com.example.myapplication.DangKiTOTP.ThongtindangkyOTPmodelTruyenRa;
import com.example.myapplication.DangKiTOTP.ThongtindangkyOTPmodelTruyenVao;
import com.example.myapplication.DangKiTOTP.XacThucOTPTruyenra_Model;
import com.example.myapplication.DangKiTOTP.XacThucOTPTruyenvao_Model;
import com.example.myapplication.HuyDangKyTOTP.XacThucHuyOTPTruyenra_Model;
import com.example.myapplication.HuyDangKyTOTP.XacThucHuyOTPTruyenvao_Model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @POST("/totp")
    Call<ThongtindangkyOTPmodelTruyenRa> apiDangKyOTP(
        @Body ThongtindangkyOTPmodelTruyenVao obj
    );

    @POST("/totp")
    Call<XacThucOTPTruyenra_Model> apiXacThucDangKyOTP(
            @Body XacThucOTPTruyenvao_Model obj
    );

    @POST("/totp")
    Call<XacThucHuyOTPTruyenra_Model> apiHuyDangKyOTP(
            @Body XacThucHuyOTPTruyenvao_Model obj
    );
}
