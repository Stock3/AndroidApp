package com.example.loginapp.Retrofit;

import com.example.loginapp.Model.RegistrationFormDto;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RegistrationAPI {
    @GET("/admin/register/user")
    Call<RegistrationFormDto> getRegistrationFormDto();
}
