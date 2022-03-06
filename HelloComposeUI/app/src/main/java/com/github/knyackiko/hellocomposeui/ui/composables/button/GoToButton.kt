package com.github.knyackiko.hellocomposeui.ui.composables.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.knyackiko.hellocomposeui.ui.theme.Purple200
import com.github.knyackiko.hellocomposeui.ui.theme.Purple500

@Composable
fun GoToButton(
    text: String,
    onClick: () -> Unit,
) {
    CompositionLocalProvider(
        LocalRippleTheme provides object : RippleTheme {
            @Composable
            override fun defaultColor() =
                RippleTheme.defaultRippleColor(
                    contentColor = Purple500,
                    lightTheme = true,
                )

            @Composable
            override fun rippleAlpha(): RippleAlpha =
                RippleTheme.defaultRippleAlpha(
                    contentColor = LocalContentColor.current,
                    lightTheme = MaterialTheme.colors.isLight,
                )
        },
    ) {
        OutlinedButton(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth(),
            shape = CircleShape,
            contentPadding = PaddingValues(
                vertical = 12.dp,
            ),
            border = BorderStroke(
                width = 1.dp,
                color = Purple500,
            ),
            colors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = Purple200.copy(0.1f),
                contentColor = Purple500,
            ),
        ) {
            Text(text = text)
        }
    }
}

@Preview
@Composable
fun PreviewGoToButton() {
    GoToButton(
        text = "サンプルレイアウトをみる",
        onClick = {},
    )
}
