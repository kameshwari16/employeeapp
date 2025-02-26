package org.example.project.viewmodels

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class AuthViewModel:ViewModel() {
    private val auth = Firebase.auth
    private val scope = CoroutineScope(Dispatchers.Default)
    private val _isAuthenticated = MutableStateFlow(false)
    val isAuthenticated: StateFlow<Boolean> = _isAuthenticated

    fun signUp(email: String, password: String) {
        scope.launch {
            try {
                val result = auth.createUserWithEmailAndPassword(email, password)
                _isAuthenticated.value = result.user != null
//                println("AuthViewModel", "SignUp successful: ${result.user != null}")
                println("AuthviewModel, signup success:${result.user != null}")
            } catch (e: Exception) {
                _isAuthenticated.value = false
                println("AuthviewModel, signup failed $e")
            }
        }
    }
    fun login(email: String, password: String) {
        scope.launch {
            try {
                val result = auth.signInWithEmailAndPassword(email, password)
                _isAuthenticated.value = result.user != null
                println("AuthviewModel, login success:${result.user != null}")
            } catch (e: Exception) {
                _isAuthenticated.value = false
                println("AuthviewModel,login failed $e")
            }
        }
    }
    fun logout() {
        scope.launch {
            try {
                auth.signOut()
                _isAuthenticated.value = false
            } catch (e: Exception) {
                println("AuthViewModel, logout failed: $e")
            }
        }
    }
    fun getCurrentUserId(): String?{
        return auth.currentUser?.uid
    }
}