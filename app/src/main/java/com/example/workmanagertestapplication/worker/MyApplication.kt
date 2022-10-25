package com.example.workmanagertestapplication.worker

import android.app.Application
import android.util.Log
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

private val coroutineScope = CoroutineScope(Dispatchers.Default)

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        initialiseWorker()
    }

    private fun initialiseWorker() {

        coroutineScope.launch {
            Log.e("testApplication","initialisation starts")

            val constrains = Constraints.Builder()
                .setRequiresBatteryNotLow(true)
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            val repeatingRequest = PeriodicWorkRequestBuilder<CoroutineWorker>(1,TimeUnit.MINUTES)
                .setConstraints(constrains)
                .build()

            WorkManager.getInstance(applicationContext).enqueue(repeatingRequest)



        }
    }

}