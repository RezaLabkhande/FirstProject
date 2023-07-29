package com.example.myapplication

import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface Api_Service {
    // http://1.1.1.1
    // https://www.google.com


    @POST("Api/Atiran/activation/activation")
    @Multipart
    fun activation(@Part("active")modeAction: active)
            :retrofit2.Call<model_activation>








}