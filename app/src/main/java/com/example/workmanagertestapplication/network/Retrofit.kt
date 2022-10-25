package com.example.workmanagertestapplication.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://quotable.io/"

interface RetrofitInterface {
    @GET("random")
    suspend fun getProperties() : Response<Quote>
}

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

object RetrofitInstance {
    val retrofitService : RetrofitInterface by lazy {
        retrofit.create(RetrofitInterface::class.java)
    }
}

