package ru.potemkin.dating.domain.repository

import androidx.lifecycle.LiveData
import ru.potemkin.dating.domain.entities.*

interface DatingRepository {
    fun addUser(user: User)

    suspend fun likeUser(
        currentUserId: String,
        userIdToLike: String
    ): LiveData<Boolean>

    suspend fun rejectUser(
        currentUserId: String,
        userIdToReject: String
    ): LiveData<Boolean>

    fun getUser(
        currentUserId: Int,
        //filters: UserFilters
    ): User

    fun getUserList(): LiveData<List<User>>

    suspend fun getMatches(
        currentUserId: String
    ): LiveData<List<User>>

    suspend fun getUserProfile(
        currentUserId: String,
        profileUserId: String
    ): LiveData<Profile>

    suspend fun updateUserProfile(
        currentUserId: String,
        updatedProfile: Profile
    ): LiveData<Boolean>

    suspend fun sendMessage(
        senderUserId: String,
        receiverUserId: String,
        message: String
    ): LiveData<Boolean>

    suspend fun getMessages(
        currentUserId: String,
        otherUserId: String
    ): LiveData<List<Message>>

    suspend fun updateUserLocation(
        currentUserId: String,
        newLocation: Location
    ): LiveData<Boolean>

    suspend fun getUsersNearby(
        currentUserId: String,
        radius: Double
    ): LiveData<List<User>>
}