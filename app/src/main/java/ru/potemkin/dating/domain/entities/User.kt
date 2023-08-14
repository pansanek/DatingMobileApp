package ru.potemkin.dating.domain.entities

data class User(
    val name: String,
    val age: Int,
    val gender: Gender,
//    val bio: String,
//    val photos: List<String>,
//    val location: Location,
//    val interests: List<Interest>,
    var id: Int = UNDEFINED_ID
)

{
    companion object{
        const val UNDEFINED_ID = -1
    }
}
