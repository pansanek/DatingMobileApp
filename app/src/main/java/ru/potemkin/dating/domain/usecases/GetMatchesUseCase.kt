package ru.potemkin.dating.domain.usecases

import ru.potemkin.dating.domain.repository.DatingRepository
import javax.inject.Inject

class GetMatchesUseCase @Inject constructor(
    private val repository: DatingRepository
) {
    suspend operator fun invoke(currentUserId: String) = repository.getMatches(currentUserId)
}