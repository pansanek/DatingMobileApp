package ru.potemkin.dating.domain.usecases

import ru.potemkin.dating.domain.entities.User
import ru.potemkin.dating.domain.repository.DatingRepository
import javax.inject.Inject

class DeleteMatchUseCase @Inject constructor(
    private val repository: DatingRepository
) {
    operator fun invoke(user: User) = repository.deleteMatch(user)
}