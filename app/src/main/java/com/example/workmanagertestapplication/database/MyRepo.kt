package com.example.workmanagertestapplication.database

import android.util.Log
import com.example.workmanagertestapplication.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class MyRepo(private val database: MyDatabase, private val retrofit: RetrofitInstance) {

    suspend fun refreshQuote() {
        try{
            val quote = retrofit.retrofitService.getProperties().body()?.content
            Log.e("testApplication",quote.toString())

            withContext(Dispatchers.IO){
                database.dao().insertIntoDatabase(QuoteTable(quote = quote.toString()))
            }
        }

        catch (exception : Exception){
            Log.e("testApplication",exception.toString())
        }
    }


}
