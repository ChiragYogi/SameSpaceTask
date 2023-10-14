package com.example.samespacetask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.samespacetask.ui.screen.MainScreen
import com.example.samespacetask.ui.theme.SameSpaceTaskTheme
import com.example.samespacetask.ui.theme.robertoFontFamily
import com.example.samespacetask.ui.theme.textStyleMedium
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SameSpaceTaskTheme {
                // A surface container using the 'background' color from the theme
                MainScreen(Modifier.fillMaxSize().background(color=MaterialTheme.colorScheme.primary))
            }
        }
    }

}


