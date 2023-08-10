package ru.potemkin.dating.domain.usecases

import ru.potemkin.dating.domain.repository.DatingRepository

class GetUsersNearbyUseCase (
    private val repository: DatingRepository
) {
    suspend operator fun invoke(
        currentUserId: String,
        radius: Double
    ) = repository.getUsersNearby(currentUserId,radius)
}