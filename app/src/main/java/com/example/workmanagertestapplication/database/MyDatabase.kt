package com.example.workmanagertestapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [QuoteTable::class], version = 1)

abstract class MyDatabase : RoomDatabase(){

    abstract fun dao() : Dao

    companion object{

        private var INSTANCE : MyDatabase? = null

        fun gerInstance (context: Context) : MyDatabase {

            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context,MyDatabase::class.java,"myDb").build()
            }
            return INSTANCE!!
        }
    }

}