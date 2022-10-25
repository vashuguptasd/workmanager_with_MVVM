package com.example.workmanagertestapplication.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class QuoteTable(

    @PrimaryKey
    val key : Int = 1,

    val quote : String
)

