package com.saotome.applicationworkapi.api

import com.saotome.applicationworkapi.model.Product
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

// Retrofit é um frakework desenvolvido pela Square que facilita a conexão com uma API de HTTP
class MyRetrofit {

    private val retrofit: Retrofit

    fun productApi(): ProductApi {
        return retrofit.create(ProductApi::class.java)
    }

    companion object {
        private const val BASE_URL =
            "https://uniqueandrocode.000webhostapp.com/hiren/androidtutorial/mycart/"

        var myRetrofit: MyRetrofit? = null

        @get:Synchronized
        val instance: MyRetrofit?
            get() {
                if (myRetrofit == null) {
                    myRetrofit = MyRetrofit()
                }
                return myRetrofit
            }
    }

    init {
        retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

}