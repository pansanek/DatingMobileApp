package ru.potemkin.dating.domain.entities

data class Like(
    val id: String,
    val senderUser: User,
    val receiverUser: User,
    val timestamp: Long
)