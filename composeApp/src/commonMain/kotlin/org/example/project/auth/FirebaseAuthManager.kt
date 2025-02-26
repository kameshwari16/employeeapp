package org.example.project.auth
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.AuthResult
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.auth

object FirebaseAuthManager {
    private val auth = Firebase.auth
    suspend fun signUp(email: String, password: String): AuthResult? {
        return try {
            auth.createUserWithEmailAndPassword(email, password)
        } catch (e: Exception) {
            null
        }
    }
    suspend fun signIn(email: String, password: String): AuthResult? {
        return try {
            auth.signInWithEmailAndPassword(email, password)
        } catch (e: Exception) {
            null
        }
    }
    suspend fun getCurrentUser(): String? {
        return auth.currentUser?.uid
    }

    suspend fun getCurrentUserEmail(): String? {
        return auth.currentUser?.email
    }
}
