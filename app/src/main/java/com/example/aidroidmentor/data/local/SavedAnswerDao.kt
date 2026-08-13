package com.example.aidroidmentor.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SavedAnswerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(savedAnswer: SavedAnswer)

    @Delete
    suspend fun delete(savedAnswer: SavedAnswer)

    @Query("SELECT * FROM saved_answers ORDER BY createdAt DESC")
    fun getAllSavedAnswers(): Flow<List<SavedAnswer>>

    @Query("DELETE FROM saved_answers")
    suspend fun deleteAll()

    @Query(
        "SELECT * FROM saved_answers WHERE id = :id LIMIT 1"
    )
    suspend fun getById(id: Long): SavedAnswer?
}