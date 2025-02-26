package org.example.project.models

import kotlinx.serialization.Serializable

@Serializable
data class Task(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val completed: Boolean = false,
//    val name: String,
//    val description: String,
//    val date: Long,
//    val isCompleted: Boolean = false,
    val userId:String=""
)
