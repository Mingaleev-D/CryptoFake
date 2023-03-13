package com.example.cryptofake.data.remote

import com.example.cryptofake.data.common.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtilies {

  fun getInstance(): Retrofit {
     return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
  }
}