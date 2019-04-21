package com.example.loginapp.Retrofit;

import com.example.loginapp.Model.MessageResponseDto;
import com.example.loginapp.Model.RegistrationFormDto;
import com.example.loginapp.Model.UserRegistrationDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RegistrationAPI {
    @GET("/admin/register/user")
    Call<RegistrationFormDto> getRegistrationFormDto();

    @POST("/admin/register/user")
    Call<MessageResponseDto> registerUser(@Body UserRegistrationDto userRegistrationDto);
}
