package ru.potemkin.dating.domain.usecases

import ru.potemkin.dating.domain.repository.DatingRepository

class GetMessagesUseCase(
    private val repository: DatingRepository
) {
    suspend operator fun invoke(
        currentUserId: String,
        otherUserId: String
    ) = repository.getMessages(currentUserId,otherUserId)
}