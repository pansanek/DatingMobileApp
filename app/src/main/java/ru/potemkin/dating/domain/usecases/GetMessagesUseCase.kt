package ru.potemkin.dating.domain.usecases

import ru.potemkin.dating.domain.repository.DatingRepository
import javax.inject.Inject

class GetMessagesUseCase @Inject constructor(
    private val repository: DatingRepository
) {
    suspend operator fun invoke(
        currentUserId: String,
        otherUserId: String
    ) = repository.getMessages(currentUserId,otherUserId)
}