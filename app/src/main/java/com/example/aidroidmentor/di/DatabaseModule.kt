package com.example.aidroidmentor.di


import android.content.Context
import androidx.room.Room
import com.example.aidroidmentor.data.local.AIDroidDatabase
import com.example.aidroidmentor.data.local.SavedAnswerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AIDroidDatabase {

        return Room.databaseBuilder(
            context,
            AIDroidDatabase::class.java,
            "ai_droid_mentor.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideSavedAnswerDao(
        database: AIDroidDatabase
    ): SavedAnswerDao {
        return database.savedAnswerDao()
    }
}