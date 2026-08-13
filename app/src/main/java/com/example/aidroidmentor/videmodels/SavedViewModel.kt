package com.example.aidroidmentor.videmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aidroidmentor.data.local.SavedAnswer
import com.example.aidroidmentor.repo.SavedAnswerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedViewModel @Inject constructor(
    private val repository: SavedAnswerRepository
) : ViewModel() {

    val savedAnswers: StateFlow<List<SavedAnswer>> =
        repository
            .getSavedAnswers()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )

    fun saveAnswer(
        title: String,
        question: String,
        answer: String,
        category: String = "AI Chat"
    ) {

        viewModelScope.launch {

            repository.saveAnswer(
                title = title,
                question = question,
                answer = answer,
                category = category
            )
        }
    }

    fun deleteAnswer(
        answer: SavedAnswer
    ) {

        viewModelScope.launch {
            repository.deleteAnswer(answer)
        }
    }

    fun getAnswerById(
        id: Long,
        onResult: (SavedAnswer?) -> Unit
    ) {

        viewModelScope.launch {

            val answer = repository.getAnswerById(id)

            onResult(answer)
        }
    }
}