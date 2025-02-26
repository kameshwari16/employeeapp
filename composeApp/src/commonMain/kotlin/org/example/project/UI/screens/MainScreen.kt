//package org.example.project.UI.screens
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.Button
//import androidx.compose.material.Card
//import androidx.compose.material.Surface
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.onSizeChanged
//import androidx.compose.ui.platform.LocalDensity
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import org.example.project.viewmodels.AuthViewModel
//import kotlinx.coroutines.delay
//import org.jetbrains.compose.resources.painterResource
//import employeeapp.composeapp.generated.resources.Res
//import employeeapp.composeapp.generated.resources.empicon
//import employeeapp.composeapp.generated.resources.fedexicon
//import employeeapp.composeapp.generated.resources.img
//@Composable
//fun MainScreen(navController: NavController,authViewModel: AuthViewModel = AuthViewModel()) {
//    Surface(color = Color.White, modifier = Modifier.padding(top = 24.dp)) {
//        Column {
//            Row {
//                Image(
//                    painter = painterResource(Res.drawable.empicon),
//                    contentDescription = "icon",
//                    modifier = Modifier.width(55.dp)
//                )
//                Column {
//                    Text(
//                        text = "EMPLOYEE",
//                        fontSize = 25.sp,
//                        color = Color.Black,
//                        fontWeight = FontWeight.Medium,
//                        modifier = Modifier.padding(top = 1.5.dp)
//                    )
//                    Text(
//                        text = "ENGAGEMENT",
//                        fontSize = 25.sp,
//                        color = Color.Black,
//                        fontWeight = FontWeight.Medium,
//                        modifier = Modifier.padding(top = 1.5.dp)
//                    )
//                }
//                Image(
//                    painter = painterResource(Res.drawable.fedexicon),
//                    contentDescription = "icon2",
//                    modifier = Modifier
//                        .width(185.dp)
//                        .padding(start = 100.dp, end = 0.dp, top = 5.dp)
//                )
//            }
//            var offset by remember { mutableStateOf(0f) }
//            var textWidth by remember { mutableStateOf(0f) }
//            Column(modifier=Modifier
//                .fillMaxSize()
//                .background(color = Color.White)
//                .fillMaxWidth(),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ){
//                Card(modifier = Modifier.padding(top = 15.dp)) { Row( modifier =
//                Modifier.padding(top = 5.5.dp, bottom = 5.5.dp, start = 5.5.dp, end = 5.5.dp)
//                    , horizontalArrangement = Arrangement.spacedBy(15.dp)) {
//                    Button(onClick={navController.navigate("signup")}){
//                        Text("Login")
//                    }
//
//                    Button(onClick={navController.navigate("signup")}){
//                        Text("Tasks")
//                    }
//                } }
//                Image(painter=painterResource(Res.drawable.img), contentDescription = "icon", modifier = Modifier.align(Alignment.CenterHorizontally))
//            }
//            Spacer(modifier=Modifier.height(10.dp))
//            Box(
//                modifier=Modifier
//                    .border(1.dp, Color.Gray)
//                    .padding(8.dp)
//                    .fillMaxWidth()
//            ){
//                LaunchedEffect(Unit)
//                {
//                    while(true){
//                        delay(50)
//                        offset -= 2f
//                        if(offset <-textWidth){
//                            offset=0f
//                        }
//                    }
//                }
//                Row(modifier=Modifier
//                    .offset(x=with(LocalDensity.current){
//                        offset.toDp()})
//                    .onSizeChanged{
//                        textWidth=it.width.toFloat()
//                    }){
//                    Spacer(modifier=Modifier.width(20.dp))
//                    Text("Complete your task for today",color=Color.Red, fontSize = 13.sp,
//                        modifier=Modifier.clickable { navController.navigate("taskList") })
//                    Spacer(modifier=Modifier.width(12.dp))
//                    Text("11-02-2025 standup link",color=Color.Red,fontSize = 13.sp)
//                }
//
//
//            }
//        }
//
//    }
//
//}
package org.example.project.UI.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.example.project.viewmodels.AuthViewModel
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import employeeapp.composeapp.generated.resources.Res
import employeeapp.composeapp.generated.resources.empicon
import employeeapp.composeapp.generated.resources.fedexicon
import employeeapp.composeapp.generated.resources.img

@Composable
fun MainScreen(navController: NavController, authViewModel: AuthViewModel = AuthViewModel()) {
    Surface(color = Color.White, modifier = Modifier.padding(top = 24.dp)) {
        Column {
            Row {
                Image(
                    painter = painterResource(Res.drawable.empicon),
                    contentDescription = "icon",
                    modifier = Modifier.width(55.dp)
                )
                Column {
                    Text(
                        text = "EMPLOYEE",
                        fontSize = 25.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(top = 1.5.dp)
                    )
                    Text(
                        text = "ENGAGEMENT",
                        fontSize = 25.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(top = 1.5.dp)
                    )
                }
                Image(
                    painter = painterResource(Res.drawable.fedexicon),
                    contentDescription = "icon2",
                    modifier = Modifier
                        .width(185.dp)
                        .padding(start = 100.dp, end = 0.dp, top = 5.dp)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(modifier = Modifier.padding(top = 15.dp)) {
                    Row(
                        modifier = Modifier.padding(
                            top = 5.5.dp,
                            bottom = 5.5.dp,
                            start = 5.5.dp,
                            end = 5.5.dp
                        ),
                        horizontalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        Button(onClick = { navController.navigate("signup") }) {
                            Text("Login")
                        }

                        Button(onClick = { navController.navigate("signup") }) {
                            Text("Tasks")
                        }
                        Button(onClick = {  }) {
                            Text("Home")
                        }

                        Button(onClick = {  }) {
                            Text("About")
                        }
                    }
                }
                Image(
                    painter = painterResource(Res.drawable.img),
                    contentDescription = "icon",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier
                        .border(1.dp, Color.Gray)
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    var offset by remember { mutableStateOf(0f) }
                    var textWidth by remember { mutableStateOf(0f) }
                    LaunchedEffect(Unit) {
                        while (true) {
                            delay(50)
                            offset -= 2f
                            if (offset < -textWidth) {
                                offset = 0f
                            }
                        }
                    }
                    Row(
                        modifier = Modifier
                            .offset(x = with(LocalDensity.current) { offset.toDp() })
                            .onSizeChanged {
                                textWidth = it.width.toFloat()
                            }
                    ) {
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(
                            "Complete your task for today",
                            color = Color.Red,
                            fontSize = 13.sp,
                            modifier = Modifier.clickable { navController.navigate("taskList") }
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text("11-02-2025 standup link", color = Color.Red, fontSize = 13.sp)
                    }
                }
            }
        }
    }
}