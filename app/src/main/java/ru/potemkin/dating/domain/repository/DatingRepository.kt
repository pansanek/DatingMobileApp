package ru.potemkin.dating.domain.repository

import ru.potemkin.dating.domain.entities.*

interface DatingRepository {
    suspend fun likeUser(
        currentUserId: String,
        userIdToLike: String
    ): Result<Boolean>

    suspend fun rejectUser(
        currentUserId: String,
        userIdToReject: String
    ): Result<Boolean>

    suspend fun getUsers(
        currentUserId: String,
        filters: UserFilters
    ): Result<List<User>>

    suspend fun getMatches(
        currentUserId: String
    ): Result<List<User>>

    suspend fun getUserProfile(
        currentUserId: String,
        profileUserId: String
    ): Result<Profile>

    suspend fun updateUserProfile(
        currentUserId: String,
        updatedProfile: Profile
    ): Result<Boolean>

    suspend fun sendMessage(
        senderUserId: String,
        receiverUserId: String,
        message: String
    ): Result<Boolean>

    suspend fun getMessages(
        currentUserId: String,
        otherUserId: String
    ): Result<List<Message>>

    suspend fun updateUserLocation(
        currentUserId: String,
        newLocation: Location
    ): Result<Boolean>

    suspend fun getUsersNearby(
        currentUserId: String,
        radius: Double
    ): Result<List<User>>
}