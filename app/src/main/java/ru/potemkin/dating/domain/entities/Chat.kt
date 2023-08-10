package ru.potemkin.dating.domain.entities

data class Chat(
    val id: String,
    val user1: User,
    val user2: User,
    val lastReadMessageIndex: Int,
    val messages: List<Message>
)