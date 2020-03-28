package com.techcafe.todone.notifications.model

data class Notification(
    val taskName: String,
    val description: String,
    val createdDate: String
)

// 仮のJson作って色々やろうとしたけど断念した
//@JsonClass(generateAdapter = true)
//data class Notification(
//    val success: Boolean,
//    val response: Response
//) {
//    @JsonClass(generateAdapter = true)
//    data class Response(
//        val todoNotifications: List<TodoNotifications>
//    ) {
//        @JsonClass(generateAdapter = true)
//        data class TodoNotifications(
//            val date: String,
//            val body: List<Body>
//        ) {
//            @JsonClass(generateAdapter = true)
//            data class Body(
//                val taskName: String,
//                val description: String,
//                val createdDate: String
//            )
//        }
//    }
//}