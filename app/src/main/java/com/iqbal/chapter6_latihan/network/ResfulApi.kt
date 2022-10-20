package com.iqbal.chapter6_latihan.network

import com.iqbal.chapter6_latihan.model.GetResspownMakeUpItem
import retrofit2.Call
import retrofit2.http.GET

interface ResfulApi {

    @GET("api/v1/products.json")
    fun getAllProduct() : Call<List<GetResspownMakeUpItem>>
}