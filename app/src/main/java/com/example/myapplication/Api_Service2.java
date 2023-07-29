package com.example.myapplication;

import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Api_Service2 {


    // https://www.google.com/


    @POST("Api/Atiran/activation/activation")
    @Multipart
    retrofit2.Call<model_activation> activation(@Part("active")active a);
}
