package com.github.knyackiko.hellocomposeui.ui.todolist

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ToDoListItemRow(
    item: ToDoListItem,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 20.dp,
            )
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
        )
        Text(item.text)
    }
}

@Preview
@Composable
fun PreviewToDoListItemRow() {
    ToDoListItemRow(
        item = ToDoListItem(
            id = 0,
            text = "サンプル 1",
            isDone = false,
        ),
        checked = false,
        onCheckedChange = {},
    )
}

data class ToDoListItem(
    val id: Int,
    val text: String,
    val isDone: Boolean,
)
