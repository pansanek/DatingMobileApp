package ru.potemkin.dating.domain.usecases

import ru.potemkin.dating.domain.entities.Location
import ru.potemkin.dating.domain.repository.DatingRepository
import javax.inject.Inject

class UpdateUserLocationUseCase @Inject constructor(
    private val repository: DatingRepository
) {
    suspend operator fun invoke(
        currentUserId: String,
        newLocation: Location
    ) = repository.updateUserLocation(currentUserId, newLocation)
}