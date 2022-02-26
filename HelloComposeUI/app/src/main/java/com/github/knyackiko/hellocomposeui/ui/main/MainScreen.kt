package com.github.knyackiko.hellocomposeui.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.knyackiko.hellocomposeui.ui.composables.*
import com.github.knyackiko.hellocomposeui.ui.composables.button.PreviewOutlinedButton1
import com.github.knyackiko.hellocomposeui.ui.composables.button.PreviewOutlinedButton2
import com.github.knyackiko.hellocomposeui.ui.composables.button.PreviewOutlinedButton3

@Composable
fun MainScreen() {
    Scaffold {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth(),
        ) {
            PreviewGreeting()
            PreviewMarker1()
            PreviewMarker2()
            PreviewMarker3()
            PreviewMarker4()
            PreviewOutlinedButton1()
            PreviewOutlinedButton2()
            PreviewOutlinedButton3()
        }
    }
}

@Preview
@Composable
fun PreviewMainScreen() {
    MainScreen()
}
