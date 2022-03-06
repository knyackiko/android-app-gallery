package com.github.knyackiko.hellocomposeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.knyackiko.hellocomposeui.ui.main.MainScreen
import com.github.knyackiko.hellocomposeui.ui.todolist.ToDoList1Screen
import com.github.knyackiko.hellocomposeui.ui.todolist.ToDoList2Screen
import com.github.knyackiko.hellocomposeui.ui.todolist.ToDoListItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppRoutes.MainScreen.route) {
        composable(AppRoutes.MainScreen.route) {
            MainScreen(
                goToToDoList1Screen = {
                    navController.navigate(AppRoutes.ToDoList1Screen.route)
                },
                goToToDoList2Screen = {
                    navController.navigate(AppRoutes.ToDoList2Screen.route)
                }
            )
        }
        composable(AppRoutes.ToDoList1Screen.route) {
            ToDoList1Screen(
                toDoListItems = (1..20).map {
                    ToDoListItem(
                        id = it,
                        text = "サンプル $it",
                        isDone = it % 4 == 0,
                    )
                },
                goBack = {
                    navController.popBackStack()
                },
            )
        }
        composable(AppRoutes.ToDoList2Screen.route) {
            ToDoList2Screen(
                toDoListItems = (1..20).map {
                    ToDoListItem(
                        id = it,
                        text = "サンプル $it",
                        isDone = it % 4 == 0,
                    )
                },
                goBack = {
                    navController.popBackStack()
                },
            )
        }
    }
}

enum class AppRoutes(val route: String) {
    MainScreen("/"),
    ToDoList1Screen("/todo-list/1"),
    ToDoList2Screen("/todo-list/2"),
}
