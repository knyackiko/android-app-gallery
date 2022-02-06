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
fun Case2() {
    LaunchedEffect(key1 = true) {
        Log.i("Case2", "LaunchedEffect")
    }
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        for (i in 1..30) {
            item {
                LaunchedEffect(key1 = i) {
                    Log.i("Case2", "LaunchedEffect in Item $i")
                }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(
                        vertical = 10.dp,
                    )
                ) {
                    Log.i("Case2", "Box $i")
                    LaunchedEffect(key1 = i) {
                        Log.i("Case2", "LaunchedEffect in Box $i")
                    }
                    Text(
                        text = "Text $i"
                    )
                }
            }
        }
    }
}

@Composable
fun PreviewCase2() {
    Case2()
}