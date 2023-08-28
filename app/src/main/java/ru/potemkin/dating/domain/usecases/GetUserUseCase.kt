package ru.potemkin.dating.domain.usecases

import ru.potemkin.dating.data.DatingRepositoryImpl
import ru.potemkin.dating.domain.entities.User
import ru.potemkin.dating.domain.repository.DatingRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val datingRepository: DatingRepository)
{
    fun getUser(UserId: Int): User {
        return datingRepository.getUser(UserId)
    }
}