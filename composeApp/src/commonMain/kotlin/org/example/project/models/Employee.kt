package org.example.project.models

import kotlinx.serialization.Serializable
@Serializable
data class Employee(
    val id: String = "",
    val name: String = "",
    val position: String = ""
)
