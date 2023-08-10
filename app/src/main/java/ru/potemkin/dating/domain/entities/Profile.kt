package ru.potemkin.dating.domain.entities

data class Profile(
    val id: String,
    val user: User,
    val description: String,
    val photos: List<String>
)
