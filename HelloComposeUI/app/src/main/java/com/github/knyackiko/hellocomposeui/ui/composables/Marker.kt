package com.github.knyackiko.hellocomposeui.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Marker(
    color: Color,
    height: Dp? = null,
    alignment: Alignment = Alignment.BottomCenter,
    content: @Composable BoxScope.() -> Unit
) {
    val heightModifier =
        if (height == null) Modifier.fillMaxHeight() else Modifier.height(height)

    Box {
        Box(
            modifier = Modifier.matchParentSize(),
            contentAlignment = alignment,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .then(heightModifier)
                    .background(color),
            ) {}
        }
        content()
    }

}

@Preview
@Composable
fun PreviewMarker1() {
    Marker(
        color = Color.Green.copy(alpha = 0.5f),
        height = 6.dp,
    ) {
        Text(text = "Marked Text 1")
    }
}

@Preview
@Composable
fun PreviewMarker2() {
    Marker(
        color = Color.Yellow,
    ) {
        Text(
            text = "Marked Text 2",
            modifier = Modifier.padding(
                horizontal = 2.dp
            ),
        )
    }
}

@Preview
@Composable
fun PreviewMarker3() {
    Marker(
        color = Color.Red.copy(alpha = 0.2f),
        height = 12.dp,
        alignment = Alignment.Center,
    ) {
        Text(text = "Marked Text 3")
    }
}

@Preview
@Composable
fun PreviewMarker4() {
    Marker(
        color = Color.Magenta.copy(0.2f),
        height = 12.dp,
        alignment = Alignment.Center,
    ) {
        TextButton(
            onClick = {},
        ) {
            Text(text = "Text Button")
        }
    }
}
