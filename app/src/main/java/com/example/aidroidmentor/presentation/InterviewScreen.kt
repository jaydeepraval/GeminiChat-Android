package com.example.aidroidmentor.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.aidroidmentor.data.InterviewLevel
import com.example.aidroidmentor.viewmodels.InterviewViewModel

@Composable
fun InterviewScreen(
    onBackClick: () -> Unit,
    viewModel: InterviewViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when {

        uiState.selectedLevel == null -> {

            InterviewLevelScreen(
                onBackClick = onBackClick,
                onLevelSelected = {
                    viewModel.startInterview(it)
                }
            )
        }

        uiState.completed -> {

            InterviewResultScreen(
                score = uiState.score,
                totalQuestions = uiState.questions.size,
                onRestart = {
                    viewModel.restartInterview()
                },
                onBackClick = onBackClick
            )
        }

        else -> {

            val question =
                uiState.questions[uiState.currentQuestionIndex]

            InterviewQuestionScreen(
                question = question.question,
                questionNumber =
                    uiState.currentQuestionIndex + 1,
                totalQuestions =
                    uiState.questions.size,
                answer = uiState.userAnswer,
                onAnswerChange = {
                    viewModel.updateAnswer(it)
                },
                onSubmit = {
                    viewModel.submitAnswer()
                },
                onBackClick = onBackClick
            )
        }
    }
}

@Composable
private fun InterviewLevelScreen(
    onBackClick: () -> Unit,
    onLevelSelected: (InterviewLevel) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Interview Practice",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Select your experience level"
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        InterviewLevel.entries.forEach { level ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                onClick = {
                    onLevelSelected(level)
                }
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = level.title,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    Text(
                        text = level.description
                    )
                }
            }
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Button(
            onClick = onBackClick
        ) {
            Text("Back")
        }
    }
}

@Composable
private fun InterviewQuestionScreen(
    question: String,
    questionNumber: Int,
    totalQuestions: Int,
    answer: String,
    onAnswerChange: (String) -> Unit,
    onSubmit: () -> Unit,
    onBackClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Question $questionNumber / $totalQuestions",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = question,
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        OutlinedTextField(
            value = answer,
            onValueChange = onAnswerChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
            placeholder = {
                Text("Type your answer...")
            }
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Button(
                onClick = onBackClick
            ) {
                Text("Back")
            }

            Button(
                enabled = answer.isNotBlank(),
                onClick = onSubmit
            ) {
                Text("Submit")
            }
        }
    }
}

@Composable
private fun InterviewResultScreen(
    score: Int,
    totalQuestions: Int,
    onRestart: () -> Unit,
    onBackClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Interview Completed 🎉",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text(
            text = "Score: $score / ${totalQuestions * 10}",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onRestart
        ) {
            Text("Try Again")
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onBackClick
        ) {
            Text("Back to Home")
        }
    }
}