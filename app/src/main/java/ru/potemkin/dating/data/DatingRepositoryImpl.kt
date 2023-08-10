package ru.potemkin.dating.data

import androidx.lifecycle.LiveData
import ru.potemkin.dating.domain.entities.*
import ru.potemkin.dating.domain.repository.DatingRepository

class DatingRepositoryImpl(

): DatingRepository {
    override suspend fun likeUser(
        currentUserId: String,
        userIdToLike: String
    ): LiveData<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun rejectUser(
        currentUserId: String,
        userIdToReject: String
    ): LiveData<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun getUsers(
        currentUserId: String,
        filters: UserFilters
    ): LiveData<List<User>> {
        TODO("Not yet implemented")
    }

    override suspend fun getMatches(currentUserId: String): LiveData<List<User>> {
        TODO("Not yet implemented")
    }

    override suspend fun getUserProfile(
        currentUserId: String,
        profileUserId: String
    ): LiveData<Profile> {
        TODO("Not yet implemented")
    }

    override suspend fun updateUserProfile(
        currentUserId: String,
        updatedProfile: Profile
    ): LiveData<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun sendMessage(
        senderUserId: String,
        receiverUserId: String,
        message: String
    ): LiveData<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun getMessages(
        currentUserId: String,
        otherUserId: String
    ): LiveData<List<Message>> {
        TODO("Not yet implemented")
    }

    override suspend fun updateUserLocation(
        currentUserId: String,
        newLocation: Location
    ): LiveData<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun getUsersNearby(
        currentUserId: String,
        radius: Double
    ): LiveData<List<User>> {
        TODO("Not yet implemented")
    }

}