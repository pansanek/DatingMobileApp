package ru.potemkin.dating.domain.entities

data class Location(
    val id: String,
    val latitude: Double,
    val longitude: Double,
    val description: String
)