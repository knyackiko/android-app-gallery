package com.github.knyackiko.hellocomposeui.ui.composables

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DefaultTopBar(
    title: String,
    onNavigationIconClicked: (() -> Unit)? = null,
) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = {
            if (onNavigationIconClicked != null) {
                IconButton(onClick = onNavigationIconClicked) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }
    )
}

@Preview
@Composable
fun PreviewDefaultTopBar() {
    DefaultTopBar(
        title = "タイトル",
        onNavigationIconClicked = {},
    )
}
