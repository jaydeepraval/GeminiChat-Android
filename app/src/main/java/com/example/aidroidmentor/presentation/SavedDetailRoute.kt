package com.example.aidroidmentor.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.aidroidmentor.data.local.SavedAnswer
import com.example.aidroidmentor.videmodels.SavedViewModel

@Composable
fun SavedDetailRoute(
    answerId: Long,
    onBackClick: () -> Unit,
    viewModel: SavedViewModel = hiltViewModel()
) {

    var answer by remember {
        mutableStateOf<SavedAnswer?>(null)
    }

    LaunchedEffect(answerId) {

        viewModel.getAnswerById(answerId) {
            answer = it
        }
    }

    if (answer != null) {

        SavedDetailScreen(
            answer = answer!!,
            onBackClick = onBackClick
        )

    } else {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Saved answer not found"
            )
        }
    }
}