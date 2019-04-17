package com.example.loginapp.Retrofit;

import com.example.loginapp.Model.UserDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserAPI {
    @GET("/admin/user/list")
    Call<List<UserDto>> getUserList();
}
