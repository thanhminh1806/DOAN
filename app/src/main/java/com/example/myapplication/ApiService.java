package com.example.myapplication;

import com.example.myapplication.DangKiTOTP.ThongtindangkyOTPmodelTruyenRa;
import com.example.myapplication.DangKiTOTP.ThongtindangkyOTPmodelTruyenVao;

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
}
