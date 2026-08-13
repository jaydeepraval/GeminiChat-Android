package com.example.aidroidmentor

import com.example.aidroidmentor.navigation.AIChatNavigation
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.aidroidmentor.ui.theme.AIDroidMentorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AIDroidMentorTheme {
                AIChatNavigation()
            }
        }
    }
}
