package ru.potemkin.dating.domain.entities

data class UserFilters(
    val gender: Gender,
    val minAge: Int,
    val maxAge: Int
)