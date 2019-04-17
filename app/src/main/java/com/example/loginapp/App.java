package com.example.loginapp;


import com.example.loginapp.Retrofit.CategoryAPI;
import com.example.loginapp.Retrofit.RegistrationAPI;
import com.example.loginapp.Retrofit.UserAPI;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class App {
    private static Retrofit retrofit;
    private static RegistrationAPI registrationAPI;
    private static UserAPI userAPI;
    private static CategoryAPI categoryAPI;


    static {
        retrofit = new Retrofit.Builder()//
                .baseUrl("http://192.168.3.105:8081") //Базова частина адреси
                .addConverterFactory(JacksonConverterFactory.create()) //Конвертер, необхідний для перетворення JSON'а в объекты
                .build();
        registrationAPI = retrofit.create(RegistrationAPI.class);
        userAPI = retrofit.create(UserAPI.class);
        categoryAPI = retrofit.create(CategoryAPI.class);
    }
    public static RegistrationAPI getRegistrationAPI() {
        return registrationAPI;
    }

    public static UserAPI getUserAPI() {
        return userAPI;
    }

    public static CategoryAPI getCategoryAPI(){ return categoryAPI;}
}
