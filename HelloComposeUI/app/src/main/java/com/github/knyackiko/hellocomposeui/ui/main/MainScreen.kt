package com.github.knyackiko.hellocomposeui.ui.main

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.knyackiko.hellocomposeui.ui.composables.Greeting
import com.github.knyackiko.hellocomposeui.ui.composables.Marker

@Composable
fun MainScreen() {
    Scaffold {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Greeting(name = "Android")
            Marker(
                color = Color.Blue.copy(0.3f),
                height = 5.dp
            ) {
                Greeting(name = "Android")
            }
            Marker(
                height = 12.dp,
                color = Color.Red.copy(alpha = 0.2f),
                alignment = Alignment.Center,
            ) {
                TextButton(
                    onClick = {
                              Log.d("MainScreen", "Button clicked!")
                    },
                ) {
                    Text(text = "Text Button")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewMainScreen() {
    MainScreen()
}
