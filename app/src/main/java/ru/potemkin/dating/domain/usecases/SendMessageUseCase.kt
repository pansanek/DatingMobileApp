package ru.potemkin.dating.domain.usecases

import ru.potemkin.dating.domain.repository.DatingRepository

class SendMessageUseCase (
    private val repository: DatingRepository
) {
    suspend operator fun invoke(
        senderUserId: String,
        receiverUserId: String,
        message: String
    ) = repository.sendMessage(senderUserId, receiverUserId, message)
}