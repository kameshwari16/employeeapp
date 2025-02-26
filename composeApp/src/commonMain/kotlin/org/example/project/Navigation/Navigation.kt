package org.example.project.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.project.UI.screens.AuthScreen
import org.example.project.UI.screens.HomeScreen
import org.example.project.UI.screens.LoginScreen
import org.example.project.UI.screens.TaskScreen
import org.example.project.UI.screens.MainScreen
import org.example.project.UI.screens.SignUpScreen
import org.example.project.repositories.TaskRepository
import org.example.project.viewmodels.TaskViewModel

@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {
    val taskRepository=TaskRepository()
    val taskViewModel=TaskViewModel(taskRepository)
    NavHost(navController = navController, startDestination = "main") {
        composable("main"){
            MainScreen(navController)
        }
        composable("signup"){ SignUpScreen(navController) }
        composable("auth") { AuthScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("task/{employeeId}") { backStackEntry ->
            val employeeId = backStackEntry.arguments?.getString("employeeId")
            TaskScreen(navController, taskViewModel)
        }
    }
}
