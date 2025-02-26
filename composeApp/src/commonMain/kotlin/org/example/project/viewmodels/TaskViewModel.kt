//package com.example.composeApp.viewmodels
//
//import com.example.composeApp.models.Task
//import dev.gitlive.firebase.Firebase
//import dev.gitlive.firebase.firestore.firestore
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//import kotlinx.serialization.Serializable
//import kotlinx.serialization.json.Json
//class TaskViewModel(private val employeeId: String) {
//    private val firestore = Firebase.firestore
//    private val scope = CoroutineScope(Dispatchers.Default)
//    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
//    val tasks: StateFlow<List<Task>> get() = _tasks
//    fun loadTasks() {
//        scope.launch {
//            try {
//                val result = firestore.collection("employees")
//                    .document(employeeId)
//                    .collection("tasks")
//                    .get()
//                val list = result.documents.mapNotNull { it.data(Task.serializer()) }
//                _tasks.value = list
//            } catch (e: Exception) {
//                // Optionally handle the error.
//                println("Error loading tasks: ${e.message}")
//            }
//        }
//    }
//
//    fun addTask(title: String, description: String) {
//        scope.launch {
//            try {
//                val newTask = Task(title = title, description = description)
//                firestore.collection("employees")
//                    .document(employeeId)
//                    .collection("tasks")
//                    .add(newTask)
//                // Refresh the list after adding a task.
//                loadTasks()
//            } catch (e: Exception) {
//                // Optionally handle the error.
//                println("Error adding task: ${e.message}")
//            }
//        }
//    }
//}

package org.example.project.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.models.Task
import org.example.project.repositories.TaskRepository
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import dev.gitlive.firebase.firestore.firestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
class TaskViewModel(private val repository: TaskRepository):ViewModel() {
//    private val firestore = Firebase.firestore
//    private val scope = CoroutineScope(Dispatchers.Default)
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> get() = _tasks
    private val auth = Firebase.auth
    val userId:String? get()=auth.currentUser?.uid
    fun loadTasks() {
        viewModelScope.launch {
            userId?.let{
                _tasks.value=repository.getUserTasks(it)
            }
        }
    }

    fun saveTask(task:Task){
        viewModelScope.launch{
            userId?.let {
                repository.addOrUpdateTask(task, it)
                loadTasks()
            }
        }
    }
}
//package org.example.project.viewmodels
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import org.example.project.models.Task
//import org.example.project.repositories.TaskRepository
//import dev.gitlive.firebase.Firebase
//import dev.gitlive.firebase.auth.auth
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//
//class TaskViewModel(private val repository: TaskRepository) : ViewModel() {
//    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
//    val tasks: StateFlow<List<Task>> get() = _tasks
//    private val auth = Firebase.auth
//    val userId: String? get() = auth.currentUser?.uid
//
//    fun loadTasks() {
//        viewModelScope.launch {
//            userId?.let {
//                _tasks.value = repository.getUserTasks(it)
//            }
//        }
//    }
//
//    fun saveTask(task: Task) {
//        viewModelScope.launch {
//            userId?.let {
//                repository.addOrUpdateTask(task, it)
//                loadTasks()
//            }
//        }
//    }
//
//    fun searchTasks(query: String, date: Long?) {
//        viewModelScope.launch {
//            userId?.let {
//                val allTasks = repository.getUserTasks(it)
//                _tasks.value = allTasks.filter { task ->
//                    (query.isBlank() || task.name.contains(query, ignoreCase = true)) &&
//                            (date == null || task.date == date)
//                }
//            }
//        }
//    }
//
//    fun updateTask(task: Task) {
//        saveTask(task)
//    }
//}