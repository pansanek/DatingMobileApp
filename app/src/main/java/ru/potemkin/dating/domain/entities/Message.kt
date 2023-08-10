package ru.potemkin.dating.domain.entities

data class Message(
    val id: String,
    val senderUser: User,
    val receiverUser: User,
    val text: String,
    val timestamp: Long
)