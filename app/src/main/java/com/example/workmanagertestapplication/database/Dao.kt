package com.example.workmanagertestapplication.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIntoDatabase(quoteTable: QuoteTable)

    @Query ("SELECT * FROM quotetable")
    fun getQuoteFromDatabase() : LiveData<QuoteTable>

}