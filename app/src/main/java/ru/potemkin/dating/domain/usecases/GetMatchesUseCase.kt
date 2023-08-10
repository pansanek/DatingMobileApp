package ru.potemkin.dating.domain.usecases

import ru.potemkin.dating.domain.repository.DatingRepository

class GetMatchesUseCase(
    private val repository: DatingRepository
) {
    suspend operator fun invoke(currentUserId: String) = repository.getMatches(currentUserId)
}