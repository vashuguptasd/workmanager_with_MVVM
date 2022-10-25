package com.example.workmanagertestapplication.worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.workmanagertestapplication.database.MyDatabase
import com.example.workmanagertestapplication.database.MyRepo
import com.example.workmanagertestapplication.network.RetrofitInstance

class CoroutineWorker (context : Context, params :WorkerParameters) : CoroutineWorker(context,params){

    override suspend fun doWork(): Result {
        return try {
            val retrofit = RetrofitInstance
            val database = MyDatabase.gerInstance(applicationContext)
            val repo = MyRepo(database,retrofit)

            repo.refreshQuote()
            Result.success()
        } catch (exception : Exception){
            Log.e("testApplication",exception.toString())
            Result.retry()
        }
    }

}