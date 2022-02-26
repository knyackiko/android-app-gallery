package com.github.knyackiko.hellocomposeui.ui.composables.button

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.knyackiko.hellocomposeui.ui.theme.Teal200

@Composable
fun OutlinedButton1() {
    OutlinedButton(
        onClick = { Log.d("OutlinedButton1", "clicked!") },
    ) {
        Text(
            text = "Outlined Button1",
        )
    }
}

@Preview
@Composable
fun PreviewOutlinedButton1() {
    OutlinedButton1()
}

@Composable
fun OutlinedButton2() {
    OutlinedButton(
        onClick = { Log.d("OutlinedButton2", "clicked!") },
        shape = CircleShape,
        contentPadding = PaddingValues(
            horizontal = 30.dp,
            vertical = 10.dp,
        ),
        border = BorderStroke(
            width = 1.dp,
            color = Teal200,
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = Teal200.copy(0.1f),
            contentColor = Teal200,
        ),
    ) {
        Text(text = "Outlined Button2")
    }
}

@Preview
@Composable
fun PreviewOutlinedButton2() {
    OutlinedButton2()
}

/**
 * リップルの色を変更
 */
@Composable
fun OutlinedButton3() {
    CompositionLocalProvider(
        LocalRippleTheme provides object : RippleTheme {
            @Composable
            override fun defaultColor() =
                RippleTheme.defaultRippleColor(
                    contentColor = Color.Red,
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
            onClick = { Log.d("OutlinedButton3", "clicked!") },
            border = BorderStroke(
                1.5.dp,
                Color.Black,
            ),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.Black,
            ),
            shape = RectangleShape,
        ) {
            Text(text = "Outlined Button3")
        }
    }

}

@Preview
@Composable
fun PreviewOutlinedButton3() {
    OutlinedButton3()
}