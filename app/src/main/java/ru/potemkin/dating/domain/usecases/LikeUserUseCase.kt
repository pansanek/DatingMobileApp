package ru.potemkin.dating.domain.usecases

import ru.potemkin.dating.domain.entities.UserFilters
import ru.potemkin.dating.domain.repository.DatingRepository
import javax.inject.Inject

class LikeUserUseCase @Inject constructor(
    private val repository: DatingRepository
) {
    suspend operator fun invoke(
        currentUserId: String,
        userIdToLike: String
    ) = repository.likeUser(currentUserId,userIdToLike)
}