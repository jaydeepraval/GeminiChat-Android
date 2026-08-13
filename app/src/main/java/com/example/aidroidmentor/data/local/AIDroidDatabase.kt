package com.example.aidroidmentor.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [SavedAnswer::class],
    version = 1,
    exportSchema = false
)
abstract class AIDroidDatabase : RoomDatabase() {

    abstract fun savedAnswerDao(): SavedAnswerDao
}