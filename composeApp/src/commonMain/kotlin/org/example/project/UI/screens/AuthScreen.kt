package org.example.project.UI.screens
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.example.project.viewmodels.AuthViewModel
import kotlinx.coroutines.launch

@Composable
fun AuthScreen(navController: NavController, viewModel: AuthViewModel = AuthViewModel()) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isSignUp by remember { mutableStateOf(true) }
    val isAuthenticated by viewModel.isAuthenticated.collectAsState()
    val scope = rememberCoroutineScope()

    LaunchedEffect(isAuthenticated) {
        if (isAuthenticated) navController.navigate("home")
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            scope.launch {
                if (isSignUp) {
                    viewModel.signUp(email, password)
                } else {
                    viewModel.login(email, password)
                }
            }
        }) {
            Text(if (isSignUp) "Sign Up" else "Login")
        }
        Spacer(modifier = Modifier.height(8.dp))
        TextButton(onClick = { isSignUp = !isSignUp }) {
            Text(if (isSignUp) "Already have an account? Login" else "New here? Sign Up")
        }
    }
}


