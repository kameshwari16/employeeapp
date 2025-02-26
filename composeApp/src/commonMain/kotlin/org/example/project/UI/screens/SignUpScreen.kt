//package org.example.project.UI.screens
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import org.example.project.viewmodels.AuthViewModel
//import kotlinx.coroutines.launch
//
//@Composable
//fun SignUpScreen(navController: NavController, viewModel: AuthViewModel = AuthViewModel()) {
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    val isAuthenticated by viewModel.isAuthenticated.collectAsState()
//    val scope = rememberCoroutineScope()
//    LaunchedEffect(Unit) {
//        snapshotFlow { isAuthenticated }.collect { authenticated ->
//            println("sign up screen is authenticated $authenticated")
//            if (authenticated) {
//                navController.navigate("login")
//            }
//        }
//    }
//
//    Column(modifier = Modifier
//        .fillMaxSize()
//        .padding(16.dp)) {
//        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
//        Spacer(modifier = Modifier.height(8.dp))
//        TextField(
//            value = password,
//            onValueChange = { password = it },
//            label = { Text("Password") },
//            visualTransformation = PasswordVisualTransformation()
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        Button(onClick = {
//            scope.launch {
//                viewModel.signUp(email, password)
//            }
//        }) {
//            Text("Sign Up")
//        }
//        Spacer(modifier = Modifier.height(8.dp))
//        TextButton(onClick = { navController.navigate("login") }) {
//            Text("Already have an account? Login")
//        }
//    }
//}
//package org.example.project.UI.screens
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import androidx.compose.ui.Alignment
//import kotlinx.coroutines.launch
//import org.example.project.viewmodels.AuthViewModel
//@Composable
//fun SignUpScreen(navController: NavController,viewModel: AuthViewModel = AuthViewModel()) {
//    var username by remember { mutableStateOf("") }
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    val isAuthenticated by viewModel.isAuthenticated.collectAsState()
//    val scope = rememberCoroutineScope()
//    LaunchedEffect(Unit) {
//        snapshotFlow { isAuthenticated }.collect { authenticated ->
//            println("sign up screen is authenticated $authenticated")
//            if (authenticated) {
//                navController.navigate("login")
//            }
//        }
//    }
//    Surface(color = Color(0xFFF0F0F0), modifier = Modifier.fillMaxSize()) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text("Sign Up", fontSize = 32.sp, color = Color.Black)
//            Spacer(modifier = Modifier.height(16.dp))
//            TextField(
//                value = username,
//                onValueChange = { username = it },
//                label = { Text("Username") },
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            TextField(
//                value = email,
//                onValueChange = { email = it },
//                label = { Text("Email") },
//                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            TextField(
//                value = password,
//                onValueChange = { password = it },
//                label = { Text("Password") },
//                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(16.dp))
//            Button(
//                onClick = {scope.launch {
//                    viewModel.signUp(email, password)
//                }},
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                Text("Sign Up")
//            }
//            Spacer(modifier = Modifier.height(8.dp))
//            TextButton(onClick = { navController.navigate("login") }) {
//                Text("Already have an account? Log In")
//            }
//        }
//    }
//}
package org.example.project.UI.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.Alignment
import kotlinx.coroutines.launch
import org.example.project.viewmodels.AuthViewModel

@Composable
fun SignUpScreen(navController: NavController, viewModel: AuthViewModel = AuthViewModel()) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val isAuthenticated by viewModel.isAuthenticated.collectAsState()
    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        snapshotFlow { isAuthenticated }.collect { authenticated ->
            println("sign up screen is authenticated $authenticated")
            if (authenticated) {
                navController.navigate("login")
            }
        }
    }
    Surface(color = Color(0xFF80CBC4), modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                elevation = 8.dp
            ) {
                Column(
                    modifier = Modifier
                        .background(Color(0xFFB2DFDB))
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Sign Up", fontSize = 32.sp, color = Color.Black)
                    Spacer(modifier = Modifier.height(16.dp))
                    TextField(
                        value = username,
                        onValueChange = { username = it },
                        label = { Text("Username") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = { scope.launch { viewModel.signUp(email, password) } },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Sign Up")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    TextButton(onClick = { navController.navigate("login") }) {
                        Text("Already have an account? Log In")
                    }
                }
            }
        }
    }
}