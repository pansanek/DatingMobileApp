package ru.potemkin.dating.domain.entities

data class Interest(
    val id: String,
    val name: String,
    val users: List<User>
)