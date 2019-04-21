package com.example.loginapp.Fragments;

import com.example.loginapp.Notifications.MyResponse;
import com.example.loginapp.Notifications.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key = AAAA_gge86A:APA91bHxNJJuA5KheTvD3g4OooywWlAlmgkBoBpp1f57xMV5t1cFV-hh8yaoFv1hZ7EMADRTFagu8OampWy4zVj-cb19XfWg_W6lYDX5lIUPc6wyVo2wnOpzq0bolg-3JBkms4bJ080g"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
