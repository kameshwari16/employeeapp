////package com.example.composeApp.UI.screens
////
////import androidx.compose.foundation.layout.*
////import androidx.compose.foundation.text.BasicTextField
////import androidx.compose.material.*
////import androidx.compose.runtime.*
////import androidx.compose.ui.Modifier
////import androidx.compose.ui.unit.dp
////import androidx.navigation.NavController
////import com.example.composeApp.viewmodels.TaskViewModel
////import kotlinx.coroutines.launch
////@Composable
////fun TaskScreen(navController: NavController, employeeId: String?) {
////    if (employeeId == null) {
////        Text("Employee ID not found")
////        return
////    }
////    val viewModel = remember { TaskViewModel(employeeId) }
////    val tasks by viewModel.tasks.collectAsState()
////    var title by remember { mutableStateOf("") }
////    var description by remember { mutableStateOf("") }
////    val scope = rememberCoroutineScope()
////    LaunchedEffect(employeeId) { viewModel.loadTasks() }
////    Column(modifier = Modifier.padding(16.dp)) {
////        Text("Your Tasks", style = MaterialTheme.typography.h5)
////        tasks.forEach { task ->
////            Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
////                Text(task.title)
////            }
////        }
////        Spacer(modifier = Modifier.height(16.dp))
////        Text("Add Task", style = MaterialTheme.typography.h6)
////        BasicTextField(value = title, onValueChange = { title = it }, modifier = Modifier.fillMaxWidth())
////        Spacer(modifier = Modifier.height(8.dp))
////        BasicTextField(value = description, onValueChange = { description = it }, modifier = Modifier.fillMaxWidth())
////        Spacer(modifier = Modifier.height(8.dp))
////        Button(onClick = {
////            scope.launch {
////                viewModel.addTask(title, description)
////            }
////        }) {
////            Text("Save Task")
////        }
////    }
////}
package org.example.project.UI.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.example.project.viewmodels.TaskViewModel
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import org.example.project.models.Task

@Composable
fun TaskScreen(navController: NavController, viewModel: TaskViewModel) {
    val tasks by viewModel.tasks.collectAsState()
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        snapshotFlow { viewModel }
        viewModel.loadTasks() // Load user-specific tasks
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Your Tasks", style = MaterialTheme.typography.h5)

        tasks.forEach { task ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
            ) {
                Text(task.title)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("Add Task", style = MaterialTheme.typography.h6)
        BasicTextField(
            value = title,
            onValueChange = { title = it },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        BasicTextField(
            value = description,
            onValueChange = { description = it },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            scope.launch {
                viewModel.saveTask(Task(title = title, description = description))
                title = ""
                description = ""
            }
        }) {
            Text("Save Task")
        }
    }
}
//package com.example.composeApp.UI.screens
//
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Add
//import androidx.compose.material3.*
//import androidx.compose.material.Surface
//import androidx.compose.material.Text
//import androidx.compose.material.TextField
//import androidx.compose.material.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import kotlinx.datetime.*
//import kotlinx.datetime.TimeZone
//import kotlinx.datetime.toLocalDateTime
//import org.example.project.viewmodels.TaskViewModel
//
//@Composable
//fun TaskScreen(navController: NavController, viewModel: TaskViewModel) {
//    var searchQuery by remember { mutableStateOf("") }
//    var searchDate by remember { mutableStateOf("") }
//    val tasks by viewModel.tasks.collectAsState()
//
//    Surface(color = Color(0xFF80CBC4), modifier = Modifier.fillMaxSize()) {
//        Column(modifier = Modifier.padding(16.dp)) {
//            Text(
//                "Employee Task",
//                fontSize = 35.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color.White,
//                textAlign = TextAlign.Center,
//                modifier = Modifier.fillMaxWidth()
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            // Search by Task Name
//            TextField(
//                value = searchQuery,
//                onValueChange = { searchQuery = it },
//                label = { Text("Search Task by Name", fontWeight = FontWeight.Bold) },
//                modifier = Modifier.fillMaxWidth()
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            // Search by Date
//            TextField(
//                value = searchDate,
//                onValueChange = { searchDate = it },
//                label = { Text("Search by Date (yyyy-MM-dd)", fontWeight = FontWeight.Bold) },
//                modifier = Modifier.fillMaxWidth()
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            // Search Button
//            Button(
//                onClick = {
//                    val dateLong = if (searchDate.isNotBlank()) parseDate(searchDate) else null
//                    viewModel.searchTasks(searchQuery, dateLong)
//                },
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                Text("Search", fontWeight = FontWeight.Bold)
//            }
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            // Display tasks sorted by date
//            LazyColumn(modifier = Modifier.weight(1f)) {
//                tasks.groupBy { formatDate(it.date) }
//                    .toSortedMap()
//                    .forEach { (date, tasksForDay) ->
//                        item {
//                            Text(
//                                text = date,
//                                style = MaterialTheme.typography.titleMedium,
//                                modifier = Modifier.padding(start = 20.dp),
//                                fontWeight = FontWeight.ExtraBold,
//                                fontSize = 24.sp,
//                                color = Color.White
//                            )
//                        }
//
//                        items(tasksForDay) { task ->
//                            Row(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .clickable { navController.navigate("addEditTask/${task.id}") }
//                                    .padding(vertical = 8.dp)
//                            ) {
//                                Card(
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .padding(horizontal = 8.dp)
//                                ) {
//                                    Row(verticalAlignment = Alignment.CenterVertically) {
//                                        Checkbox(
//                                            checked = task.isCompleted,
//                                            onCheckedChange = {
//                                                viewModel.updateTask(task.copy(isCompleted = it))
//                                            }
//                                        )
//                                        Text(
//                                            task.name,
//                                            modifier = Modifier.padding(start = 8.dp),
//                                            fontSize = 20.sp,
//                                            fontWeight = FontWeight.Bold,
//                                            color = Color.Black
//                                        )
//                                    }
//                                }
//                            }
//                        }
//                    }
//            }
//
//            Box(modifier = Modifier.fillMaxSize()) {
//                FloatingActionButton(
//                    onClick = { navController.navigate("addEditTask/-1") },
//                    modifier = Modifier
//                        .padding(16.dp)
//                        .align(Alignment.BottomEnd)
//                ) {
//                    Icon(imageVector = Icons.Filled.Add, contentDescription = "Add Task")
//                }
//            }
//        }
//    }
//}
//
//fun formatDate(dateMillis: Long): String {
//    val instant = Instant.fromEpochMilliseconds(dateMillis)
//    val dateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
//    return "${dateTime.year}-${dateTime.monthNumber}-${dateTime.dayOfMonth}"
//}
//
//// Utility to parse date string to timestamp
//fun parseDate(dateStr: String): Long? {
//    return try {
//        val dateTime = LocalDateTime.parse(dateStr)
//        val instant = dateTime.toInstant(TimeZone.currentSystemDefault())
//        instant.toEpochMilliseconds()
//    } catch (e: Exception) {
//        null
//    }
//}