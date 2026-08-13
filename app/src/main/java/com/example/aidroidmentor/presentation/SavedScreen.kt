package com.example.aidroidmentor.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.aidroidmentor.data.SavedItem
import com.example.aidroidmentor.data.local.SavedAnswer
import com.example.aidroidmentor.videmodels.SavedViewModel


@Composable
fun SavedScreen(
    onAnswerClick: (Long) -> Unit,
    viewModel: SavedViewModel = hiltViewModel()
) {

    val savedAnswers by viewModel.savedAnswers.collectAsStateWithLifecycle()

    if (savedAnswers.isEmpty()) {

        EmptySavedScreen()

    } else {

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            item {

                Text(
                    text = "Saved Answers",
                    style = MaterialTheme.typography.headlineMedium
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "Your saved AI explanations",
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )
            }

            items(
                items = savedAnswers,
                key = { it.id }
            ) { answer ->

               /* SavedAnswerCard(
                    answer = answer,
                    onDelete = {
                        viewModel.deleteAnswer(answer)
                    }
                )*/

                SavedAnswerCard(
                    answer = answer,
                    onClick = {
                        onAnswerClick(answer.id)
                    },
                    onDelete = {
                        viewModel.deleteAnswer(answer)
                    }
                )
            }
        }
    }
}

@Composable
private fun EmptySavedScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Icon(
            imageVector = Icons.Default.Bookmark,
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text(
            text = "No Saved Answers",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Save useful AI answers to access them later.",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
private fun SavedAnswerCard(
    answer: SavedAnswer,
    onClick: () -> Unit,
    onDelete: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Default.Bookmark,
                contentDescription = "Saved",
                modifier = Modifier.size(32.dp)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 12.dp)
            ) {

                Text(
                    text = answer.title,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = answer.category,
                    style = MaterialTheme.typography.labelMedium
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = answer.answer,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 2
                )
            }

            IconButton(
                onClick = onDelete
            ) {

                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete"
                )
            }
        }
    }
}
