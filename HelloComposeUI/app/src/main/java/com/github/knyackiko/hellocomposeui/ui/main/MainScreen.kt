package com.github.knyackiko.hellocomposeui.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.knyackiko.hellocomposeui.ui.composables.*
import com.github.knyackiko.hellocomposeui.ui.composables.button.GoToButton
import com.github.knyackiko.hellocomposeui.ui.composables.button.PreviewOutlinedButton1
import com.github.knyackiko.hellocomposeui.ui.composables.button.PreviewOutlinedButton2
import com.github.knyackiko.hellocomposeui.ui.composables.button.PreviewOutlinedButton3

@Composable
fun MainScreen(
    goToToDoList1Screen: () -> Unit,
    goToToDoList2Screen: () -> Unit,
) {
    Scaffold(
        topBar = {
            DefaultTopBar(title = "サンプルレイアウト一覧")
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 20.dp,
                ),
        ) {
            PreviewGreeting()
            PreviewMarker1()
            PreviewMarker2()
            PreviewMarker3()
            PreviewMarker4()
            PreviewOutlinedButton1()
            PreviewOutlinedButton2()
            PreviewOutlinedButton3()
            GoToButton(
                text = "ToDoリスト1をみる",
                onClick = goToToDoList1Screen,
            )
            GoToButton(
                text = "ToDoリスト2をみる",
                onClick = goToToDoList2Screen,
            )
        }
    }
}

@Preview
@Composable
fun PreviewMainScreen() {
    MainScreen(
        goToToDoList1Screen = {},
        goToToDoList2Screen = {},
    )
}
