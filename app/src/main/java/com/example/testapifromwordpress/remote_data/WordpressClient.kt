package com.example.testapifromwordpress.remote_data

import android.util.Log
import com.example.testapifromwordpress.pojo.Products
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WordpressClient {
    private val apiURL = "https://muradyusri.com/vkingplus01/wc-api/v3/"
    var retrofit: WordpressApiInterface = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(apiURL)
        .build()
        .create(WordpressApiInterface::class.java)

    suspend fun getProductsData(filter:Int,basicAuth:String): Products {
        Log.d("WordpressClient","processRender: Idle ")
        return retrofit.getProductData(
            filter = filter,
            basicAuth = basicAuth
        )
    }

}