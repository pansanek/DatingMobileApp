package ru.potemkin.dating.domain.usecases

import ru.potemkin.dating.domain.repository.DatingRepository

class GetUserProfileUseCase (
    private val repository: DatingRepository
) {
    suspend operator fun invoke(
        currentUserId: String,
        profileUserId: String
    ) = repository.getUserProfile(currentUserId,profileUserId)
}