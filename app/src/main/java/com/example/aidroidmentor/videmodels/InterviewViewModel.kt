package com.example.aidroidmentor.viewmodels

import androidx.lifecycle.ViewModel
import com.example.aidroidmentor.data.InterviewLevel
import com.example.aidroidmentor.data.InterviewQuestion
import com.example.aidroidmentor.di.InterviewQuestions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class InterviewUiState(
    val selectedLevel: InterviewLevel? = null,
    val questions: List<InterviewQuestion> = emptyList(),
    val currentQuestionIndex: Int = 0,
    val userAnswer: String = "",
    val score: Int = 0,
    val completed: Boolean = false
)

@HiltViewModel
class InterviewViewModel @Inject constructor() : ViewModel() {

    private val _uiState =
        MutableStateFlow(InterviewUiState())

    val uiState: StateFlow<InterviewUiState> =
        _uiState.asStateFlow()

    fun startInterview(level: InterviewLevel) {

        val questions =
            InterviewQuestions.questions.filter {
                it.level == level
            }

        _uiState.value = InterviewUiState(
            selectedLevel = level,
            questions = questions
        )
    }

    fun updateAnswer(answer: String) {

        _uiState.value =
            _uiState.value.copy(
                userAnswer = answer
            )
    }

    fun submitAnswer() {

        val state = _uiState.value

        if (state.userAnswer.isBlank()) {
            return
        }

        // Temporary scoring.
        // Later Gemini can evaluate the answer.
        val newScore =
            if (state.userAnswer.length >= 50) {
                state.score + 10
            } else {
                state.score + 5
            }

        val nextIndex =
            state.currentQuestionIndex + 1

        if (nextIndex >= state.questions.size) {

            _uiState.value =
                state.copy(
                    score = newScore,
                    completed = true
                )

        } else {

            _uiState.value =
                state.copy(
                    currentQuestionIndex = nextIndex,
                    userAnswer = "",
                    score = newScore
                )
        }
    }

    fun restartInterview() {

        val level = _uiState.value.selectedLevel

        if (level != null) {
            startInterview(level)
        }
    }
}