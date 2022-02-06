package com.github.knyackiko.hellolaunchedeffect

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Case3() {
    LaunchedEffect(key1 = true) {
        Log.i("Case3", "LaunchedEffect")
    }
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        for (i in 1..30) {
            item(key = i) {
                Case3Item(position = i)
            }
        }
    }
}

@Composable
fun Case3Item(position: Int) {
    LaunchedEffect(key1 = position) {
        Log.i("Case3", "LaunchedEffect in Item $position")
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.padding(
            vertical = 10.dp,
        )
    ) {
        Log.i("Case3", "Box $position")
        LaunchedEffect(key1 = position) {
            Log.i("Case3", "LaunchedEffect in Box $position")
        }
        Text(
            text = "Text $position"
        )
    }
}

@Composable
fun PreviewCase3() {
    Case3()
}