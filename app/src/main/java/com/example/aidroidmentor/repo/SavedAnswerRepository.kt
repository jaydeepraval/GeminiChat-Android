package com.example.aidroidmentor.repo


import com.example.aidroidmentor.data.local.SavedAnswer
import com.example.aidroidmentor.data.local.SavedAnswerDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SavedAnswerRepository @Inject constructor(
    private val dao: SavedAnswerDao
) {

    fun getSavedAnswers(): Flow<List<SavedAnswer>> {
        return dao.getAllSavedAnswers()
    }

    suspend fun saveAnswer(
        title: String,
        question: String,
        answer: String,
        category: String = "AI Chat"
    ) {

        dao.insert(
            SavedAnswer(
                title = title,
                question = question,
                answer = answer,
                category = category
            )
        )
    }

    suspend fun deleteAnswer(
        answer: SavedAnswer
    ) {
        dao.delete(answer)
    }

    suspend fun getAnswerById(
        id: Long
    ): SavedAnswer? {

        return dao.getById(id)
    }
}