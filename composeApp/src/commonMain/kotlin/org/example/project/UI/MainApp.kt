package org.example.project.UI

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import org.example.project.Navigation.AppNavigation
@Composable
fun MainApp(){
    val navController= rememberNavController()
    AppNavigation(navController)
}