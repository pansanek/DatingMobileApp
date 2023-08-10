package ru.potemkin.dating.domain.entities

data class Match(
    val id: String,
    val user1: User,
    val user2: User,
    val timestamp: Long
)