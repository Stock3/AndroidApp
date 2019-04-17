package com.example.loginapp.Retrofit;

import com.example.loginapp.Model.CategoryDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CategoryAPI {
    @GET("/category/all")
    Call<List<CategoryDto>> getCategoryList();

    @POST("/category/create")
    Call<List<CategoryDto>> addCategory(@Body CategoryDto categoryDto);

    @DELETE("/category/delete/{id}")
    Call<List<CategoryDto>> deleteCategory(@Path("id") Long id);
}
