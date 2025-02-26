package org.example.project.viewmodels

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.example.project.models.Employee

class HomeViewModel {
    private val firestore = Firebase.firestore
    private val scope = CoroutineScope(Dispatchers.Default)
    private val _employees = MutableStateFlow<List<Employee>>(emptyList())
    val employees: StateFlow<List<Employee>> = _employees

    fun loadEmployees() {
        scope.launch {
            try {
                val result = firestore.collection("employees").get()
                val empList = result.documents.mapNotNull {it->
                    it.data(Employee.serializer()) }
                _employees.update { empList }
            } catch (e: Exception) {
                // Handle the error appropriately
            }
        }
    }
}
