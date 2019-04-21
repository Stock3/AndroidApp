package com.example.loginapp.Retrofit;

import com.example.loginapp.Model.AuthenticationTokenDto;
import com.example.loginapp.Model.UserAuthorizationDto;
import com.example.loginapp.Model.UserDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserAPI {
    @GET("/admin/user/list")
    Call<List<UserDto>> getUserList();

    @POST("/authorization/login")
    Call<AuthenticationTokenDto> loginUser(@Body UserAuthorizationDto userAuthorizationDto);
}
