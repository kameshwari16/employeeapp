package org.example.project.repositories

import org.example.project.models.Task
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore
import dev.gitlive.firebase.firestore.where

class TaskRepository {
    private val db = Firebase.firestore
//    private val taskCollection = db.collection("tasks")

    // Add or update a task with userId
    suspend fun addOrUpdateTask(task: Task, userId: String) {
//        val taskWithUser = task.copy(userId = userId) // Ensure userId is stored
//        val documentId=task.id.ifEmpty{taskCollection.document.id}
//        taskCollection.document(documentId)
//            .set(taskWithUser)
        val taskCollection=db.collection("employees").document(userId).collection("tasks")
//        val documentId=task.id.ifEmpty { taskCollection.document.id }
//        val =task.id
        val documentId = task.id.ifEmpty { taskCollection.document.id }
        taskCollection.document(documentId).set(task)
    }

    // Fetch tasks only for the logged-in user
    suspend fun getUserTasks(userId: String): List<Task> {
        return try {
            val taskCollection = db.collection("employees").document(userId).collection("tasks")
            val snapshot = taskCollection.get()
            snapshot.documents.mapNotNull { it.data(Task.serializer()) }
//            val snapshot = taskCollection
//                .where { "userId" equalTo userId }
//                .get()
//            snapshot.documents.mapNotNull { it.data(Task.serializer()) }
        } catch (e: Exception) {
            emptyList()
        }
    }
}