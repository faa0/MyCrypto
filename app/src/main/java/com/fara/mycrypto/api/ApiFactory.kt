package com.fara.mycrypto.api

import com.fara.mycrypto.utils.AppConstants
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(AppConstants.BASE_URL)
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}