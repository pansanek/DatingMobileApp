package ru.potemkin.dating.domain.usecases

import ru.potemkin.dating.domain.repository.DatingRepository

class GetUserListUseCase (
    private val repository: DatingRepository
) {
    operator fun invoke() = repository.getUserList()
}