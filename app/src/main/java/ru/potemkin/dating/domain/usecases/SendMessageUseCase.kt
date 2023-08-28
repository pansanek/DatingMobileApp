package ru.potemkin.dating.domain.usecases

import ru.potemkin.dating.domain.repository.DatingRepository
import javax.inject.Inject

class SendMessageUseCase @Inject constructor(
    private val repository: DatingRepository
) {
    suspend operator fun invoke(
        senderUserId: String,
        receiverUserId: String,
        message: String
    ) = repository.sendMessage(senderUserId, receiverUserId, message)
}