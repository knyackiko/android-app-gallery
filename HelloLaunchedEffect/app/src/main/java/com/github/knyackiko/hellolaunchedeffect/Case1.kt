package com.github.knyackiko.hellolaunchedeffect

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Case1() {
    LaunchedEffect(key1 = true) {
        Log.i("Case1", "LaunchedEffect")
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.verticalScroll(
            state = rememberScrollState(),
        )
    ) {
        for (i in 1..30) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(
                    vertical = 10.dp,
                )
            ) {
                Log.i("Case1", "Box $i")
                LaunchedEffect(key1 = i) {
                    Log.i("Case1", "LaunchedEffect in Box $i")
                }
                Text(
                    text = "Text $i"
                )
            }
        }
    }
}

@Composable
fun PreviewCase1() {
    Case1()
}