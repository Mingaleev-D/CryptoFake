package com.example.cryptofake.data.remote

import com.example.cryptofake.data.model.MarketModel
import retrofit2.Response
import retrofit2.http.GET

/**
 * @author : Mingaleev D
 * @data : 13.03.2023
 */

interface ApiInterface {

   @GET("listing?start=1&limit=500")
   suspend fun getMarketData():Response<MarketModel>
}