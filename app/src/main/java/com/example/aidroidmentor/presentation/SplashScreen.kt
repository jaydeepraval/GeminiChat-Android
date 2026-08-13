package com.example.aidroidmentor.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun SplashScreen(
    onNavigate: () -> Unit
) {

    LaunchedEffect(Unit) {

        delay(2000.milliseconds)

        onNavigate()

    }


    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Text(
                text = "🤖 AI Assistant",
                style = MaterialTheme.typography.headlineMedium
            )


            Spacer(
                modifier = Modifier.height(16.dp)
            )


            CircularProgressIndicator()

        }

    }

}