package org.example.project.UI.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import employeeapp.composeapp.generated.resources.Res
import employeeapp.composeapp.generated.resources.empicon
import employeeapp.composeapp.generated.resources.fedexicon
import org.example.project.models.Employee
import org.example.project.viewmodels.AuthViewModel
import org.example.project.viewmodels.HomeViewModel
import org.jetbrains.compose.resources.painterResource

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = HomeViewModel(),authViewModel: AuthViewModel=AuthViewModel()) {
    val employees by viewModel.employees.collectAsState()
    LaunchedEffect(Unit) { viewModel.loadEmployees() }
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Employee List", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.navigate("task/new") }) {
            Text("Create Task")
        }
        Button(onClick={
            authViewModel.logout()
            navController.navigate("login")
        }){
            Text("Logout")
        }
        LazyColumn {
            items(employees) { employee ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navController.navigate("task/${employee.id}") }
                        .padding(8.dp)
                ) {
                    Text(employee.name)
                    Spacer(modifier = Modifier.weight(1f))
                    Text(employee.position)
                }
            }
        }
    }
}
