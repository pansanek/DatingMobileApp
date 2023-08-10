package ru.potemkin.dating.domain.usecases

import ru.potemkin.dating.domain.repository.DatingRepository

class RejectUserUseCase (
    private val repository: DatingRepository
) {
    suspend operator fun invoke(
        currentUserId: String,
        userIdToReject: String
    ) = repository.rejectUser(currentUserId,userIdToReject)
}