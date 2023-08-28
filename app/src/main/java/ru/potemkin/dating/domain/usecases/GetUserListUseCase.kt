package ru.potemkin.dating.domain.usecases

import ru.potemkin.dating.domain.repository.DatingRepository
import javax.inject.Inject

class GetUserListUseCase @Inject constructor(
    private val repository: DatingRepository
) {
    operator fun invoke() = repository.getUserList()
}