package ru.potemkin.dating.domain.usecases

import ru.potemkin.dating.domain.entities.UserFilters
import ru.potemkin.dating.domain.repository.DatingRepository

class GetUsersUseCase (
    private val repository: DatingRepository
) {
    suspend operator fun invoke(
        currentUserId: String,
        filters: UserFilters
    ) = repository.getUsers(currentUserId,filters)
}