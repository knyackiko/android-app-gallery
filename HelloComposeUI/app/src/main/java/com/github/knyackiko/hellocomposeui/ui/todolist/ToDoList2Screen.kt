package com.github.knyackiko.hellocomposeui.ui.todolist

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.knyackiko.hellocomposeui.ui.composables.DefaultTopBar
import com.github.knyackiko.hellocomposeui.ui.theme.Typography
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * アイテムの追加・削除にかかるアニメーション：AnimatedVisibilityを使用
 * ShrinkVerticallyとExpandVerticallyを使って、アイテムの移動のアニメーションを表現
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ToDoList2Screen(
    toDoListItems: List<ToDoListItem>,
    goBack: () -> Unit,
) {
    var allItems by remember {
        mutableStateOf(toDoListItems)
    }
    // 完了済みにされた項目は更新された順で表示するため、別で保持しておく
    var doneItems by remember {
        mutableStateOf(toDoListItems.filter { it.isDone })
    }
    // 追加のアニメーションを利かせるため、状態の変化があった項目を保持しておく
    var changedItems by remember {
        mutableStateOf(ToDoListItem(id = 0, text = "", isDone = false))
    }
    val scope = rememberCoroutineScope()

    fun update(item: ToDoListItem) {
        val newItem = item.copy(
            isDone = item.isDone.not()
        )
        changedItems = newItem
        allItems = allItems.map {
            if (it.id == newItem.id) newItem else it
        }
        val isDoneItem = doneItems.any { it.id == newItem.id }
        doneItems =
            if (isDoneItem) doneItems.filterNot { it.id == newItem.id } else listOf(newItem) + doneItems
    }

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "ToDoList Sample 2",
                onNavigationIconClicked = goBack,
            )
        },
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            contentPadding = PaddingValues(
                horizontal = 10.dp,
            )
        ) {
            items(
                items = allItems.filter { it.isDone.not() },
                key = { it.id },
            ) {
                var checked by remember {
                    mutableStateOf(it.isDone)
                }
                var isVisible by remember {
                    mutableStateOf(it.id != changedItems.id)
                }

                // 追加された項目を非表示→表示に変化させることでアニメーションをかける
                LaunchedEffect(key1 = true) {
                    if (it.id == changedItems.id) {
                        isVisible = isVisible.not()
                    }
                }
                AnimatedVisibilityItem(
                    isVisible = isVisible,
                ) {
                    ToDoListItemRow(
                        item = it,
                        checked = checked,
                        onCheckedChange = { _ ->
                            scope.launch {
                                checked = checked.not()
                                // チェックボックスがチェック済みになるのを見せるためのdelay
                                delay(300)
                                isVisible = isVisible.not()
                                // exitのアニメーションを見せるためのdelay
                                delay(300)
                                update(it)
                            }
                        },
                    )
                }
            }
            item(
                key = "divider"
            ) {
                Divider(
                    modifier = Modifier
                        .padding(
                            vertical = 10.dp
                        )
                )
            }
            item(
                key = "doneItemsHeader"
            ) {
                Text(
                    "完了済みの項目",
                    style = Typography.subtitle1,
                )
            }
            items(
                items = doneItems,
                key = { "doneItems ${it.id}" },
            ) {
                var checked by remember {
                    mutableStateOf(it.isDone)
                }
                var isVisible by remember {
                    mutableStateOf(it.id != changedItems.id)
                }

                LaunchedEffect(key1 = true) {
                    if (it.id == changedItems.id) {
                        isVisible = isVisible.not()
                    }
                }

                AnimatedVisibilityItem(
                    isVisible = isVisible,
                ) {
                    ToDoListItemRow(
                        item = it,
                        checked = checked,
                        onCheckedChange = { _ ->
                            scope.launch {
                                checked = checked.not()
                                delay(300)
                                isVisible = isVisible.not()
                                delay(300)
                                update(it)
                            }
                        },
                    )
                }

            }
        }
    }
}

@Composable
fun AnimatedVisibilityItem(
    isVisible: Boolean,
    content: @Composable AnimatedVisibilityScope.() -> Unit,
) {
    AnimatedVisibility(
        visible = isVisible,
        exit = fadeOut(
            animationSpec = tween(
                durationMillis = 200
            )
        ) + shrinkVertically(
            animationSpec = tween(
                delayMillis = 100,
                durationMillis = 200,
            )
        ),
        enter = fadeIn(
            animationSpec = tween(
                delayMillis = 100,
            )
        ) + expandVertically(
            animationSpec = tween(
                durationMillis = 300,
            )
        ),
    ) {
        content()
    }
}

@Preview
@Composable
fun PreviewToDoList2Screen() {
    ToDoList2Screen(
        toDoListItems = (1..20).map {
            ToDoListItem(
                id = it,
                text = "サンプル $it",
                isDone = it % 4 == 0,
            )
        },
        goBack = {},
    )
}
