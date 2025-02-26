////package org.example.project.news
////import io.ktor.client.*
////import io.ktor.client.request.*
////import io.ktor.client.statement.*
////import io.ktor.http.*
////import kotlinx.coroutines.runBlocking
////import kotlinx.serialization.encodeToString
////import kotlinx.serialization.json.Json
////import okio.FileSystem
////import okio.Path.Companion.toPath
////import okio.buffer
////import okio.source
////import kotlin.io.encoding.Base64
////import kotlin.io.encoding.ExperimentalEncodingApi
////
////@OptIn(ExperimentalEncodingApi::class)
////fun main() = runBlocking {
////    val httpClient = HttpClient()
////    val firestoreUrl = "https://firestore.googleapis.com/v1/projects/YOUR_PROJECT_ID/databases/(default)/documents/news"
////
////    val newsList = listOf(
////        NewsItem("Market Hits Record High!", "Stock markets reached an all-time high.", "path_to_your_image_1.png"),
////        NewsItem("Team X Wins Championship!", "Team X secured a thrilling victory in the finals.", "path_to_your_image_2.png"),
////        NewsItem("New AI Model Released!", "A revolutionary AI model has been introduced.", "path_to_your_image_3.png")
////    )
////
////    for (news in newsList) {
////        val imageBytes = File(news.imagePath).readBytes()
////        val imageBase64 = Base64.encode(imageBytes)
////
////        val newsData = mapOf(
////            "fields" to mapOf(
////                "image" to mapOf("stringValue" to imageBase64),
////                "headline" to mapOf("stringValue" to news.headline),
////                "fullNews" to mapOf("stringValue" to news.fullNews)
////            )
////        )
////
////        try {
////            val response: HttpResponse = httpClient.post(firestoreUrl) {
////                contentType(ContentType.Application.Json)
////                setBody(Json.encodeToString(newsData))
////            }
////            println("Uploaded: ${news.headline} | Status: ${response.status}")
////        } catch (e: Exception) {
////            e.printStackTrace()
////        }
////    }
////}
////
////data class NewsItem(val headline: String, val fullNews: String, val imagePath: String)
////
//
//package org.example.project.news
//
//import io.ktor.client.*
//import io.ktor.client.request.*
//import io.ktor.client.statement.*
//import io.ktor.http.*
//import kotlinx.coroutines.runBlocking
//import kotlinx.serialization.encodeToString
//import kotlinx.serialization.json.Json
//import okio.FileSystem
//import okio.Path.Companion.toPath
//import kotlin.io.encoding.Base64
//import kotlin.io.encoding.ExperimentalEncodingApi
//
//@OptIn(ExperimentalEncodingApi::class)
//fun main() = runBlocking {
//    val httpClient = HttpClient()
//    val firestoreUrl = "https://firestore.googleapis.com/v1/projects/YOUR_PROJECT_ID/databases/(default)/documents/news"
//
//    val newsList = listOf(
//        NewsItem("Market Hits Record High!", "Stock markets reached an all-time high.", "path_to_your_image_1.png"),
//        NewsItem("Team X Wins Championship!", "Team X secured a thrilling victory in the finals.", "path_to_your_image_2.png"),
//        NewsItem("New AI Model Released!", "A revolutionary AI model has been introduced.", "path_to_your_image_3.png")
//    )
//
//    for (news in newsList) {
//        val path = news.imagePath.toPath()
//        val imageBytes = FileSystem.SYSTEM.read(path) {
//            readByteArray()
//        }
//        val imageBase64 = Base64.encode(imageBytes)
//
//        val newsData = mapOf(
//            "fields" to mapOf(
//                "image" to mapOf("stringValue" to imageBase64),
//                "headline" to mapOf("stringValue" to news.headline),
//                "fullNews" to mapOf("stringValue" to news.fullNews)
//            )
//        )
//
//        try {
//            val response: HttpResponse = httpClient.post(firestoreUrl) {
//                contentType(ContentType.Application.Json)
//                setBody(Json.encodeToString(newsData))
//            }
//            println("Uploaded: ${news.headline} | Status: ${response.status}")
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }
//}
//
//data class NewsItem(val headline: String, val fullNews: String, val imagePath: String)