package com.example.testapifromwordpress.remote_data

import com.example.testapifromwordpress.pojo.Products
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface WordpressApiInterface {
    @GET("products")
    suspend fun getProductData(
        @Query("filter[limit]") filter:Int,
        @Header("Authorization") basicAuth:String
    ): Products

}