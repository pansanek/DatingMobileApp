package ru.potemkin.dating.domain.usecases

import ru.potemkin.dating.domain.entities.Location
import ru.potemkin.dating.domain.entities.Profile
import ru.potemkin.dating.domain.repository.DatingRepository

class UpdateUserProfileUseCase (
    private val repository: DatingRepository
) {
    suspend operator fun invoke(
        currentUserId: String,
        updatedProfile: Profile
    ) = repository.updateUserProfile(currentUserId, updatedProfile)
}