package com.example.aidroidmentor.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_answers")
data class SavedAnswer( @PrimaryKey(autoGenerate = true)
                        val id: Long = 0,

                        val title: String,

                        val question: String,

                        val answer: String,

                        val category: String = "AI Chat",

                        val createdAt: Long = System.currentTimeMillis())
