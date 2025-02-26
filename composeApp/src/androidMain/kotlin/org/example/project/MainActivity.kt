//package org.example.project
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import com.google.firebase.FirebaseApp
//import org.example.project.UI.MainApp
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        FirebaseApp.initializeApp(this)  // Initialize Firebase
//        setContent {
//            MainApp()
//        }
//    }
//}
package org.example.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import dev.gitlive.firebase.firestore.firestore
import dev.gitlive.firebase.initialize
import org.example.project.UI.MainApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Firebase
        Firebase.initialize(context = this)

        // Access Firebase Auth and Firestore
        val auth = Firebase.auth
        val firestore = Firebase.firestore

        setContent {
            MainApp()
        }
    }
}