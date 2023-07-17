package com.example.myapplication

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class BaseServer {
    private var retrofit: Retrofit? = null
    private var api: Api_Service? = null
    fun getApi(S:String): Api_Service? {
        if (api == null) {
            val interceptor: HttpLoggingInterceptor
            interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY


            val gson = GsonBuilder()
                .setLenient()
                .create()
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()
            api = Retrofit.Builder()
                .baseUrl(S)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()
                .create(Api_Service::class.java)
        }
        return api
    }

}
