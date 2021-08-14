package com.example.data.Network

import android.accounts.NetworkErrorException
import android.util.Log
//import com.example.data.BuildConfig.BASE_URL
import com.example.data.cache.AppPref
import com.example.data.cache.AppPref.businessId
import com.example.data.cache.AppPref.token
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
//import com.jakewharton.rxbinding.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Nosa Belvi on 6/23/18.
 * @ApiClient is a singleton class implementation for performing retrofit request
 * @apiClient for making request from any class
 * @provideHttpClient is base httpclient for request
 */

object ApiClient {

    private const val API_BASE_URL = "https://tractionapp-stage.herokuapp.com/"


    val retrofit = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(signedClient())
            .build()



    /* private fun signedClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val OkHttp =  OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .addInterceptor(interceptor)
                .build()
        return OkHttp

        }
    }*/


    private fun signedClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .addInterceptor(interceptor)
                .addInterceptor { chain ->
                    val newRequest = chain.request().newBuilder()
                            .addHeader("Authorization", "Bearer $token")
                            .build()

                    when {
                        !AppPref.isOnline -> {
                           // throw NetworkErrorException("Unable to connect, check your network")
                            chain.proceed(newRequest)
                        }
                        else -> {
                            throw NetworkErrorException("Unable to connect, check your network")
                            //chain.proceed(newRequest)
                        }
                    }
                }.build()

    }
}






