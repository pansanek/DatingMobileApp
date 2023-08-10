package ru.potemkin.dating.domain.usecases

import ru.potemkin.dating.domain.entities.Location
import ru.potemkin.dating.domain.repository.DatingRepository

class UpdateUserLocationUseCase (
    private val repository: DatingRepository
) {
    suspend operator fun invoke(
        currentUserId: String,
        newLocation: Location
    ) = repository.updateUserLocation(currentUserId, newLocation)
}