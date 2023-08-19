package ru.potemkin.dating.presentation.viewmodels

import androidx.lifecycle.ViewModel
import ru.potemkin.dating.data.DatingRepositoryImpl
import ru.potemkin.dating.domain.entities.User
import ru.potemkin.dating.domain.usecases.DeleteMatchUseCase
import ru.potemkin.dating.domain.usecases.GetUserListUseCase
import ru.potemkin.dating.domain.usecases.LikeUserUseCase
import ru.potemkin.dating.domain.usecases.RejectUserUseCase

class MatchesViewModel : ViewModel() {
    private val repository = DatingRepositoryImpl

    private val getUserListUseCase = GetUserListUseCase(repository)
    private val deleteMatchUseCase = DeleteMatchUseCase(repository)


    val userList = getUserListUseCase.invoke()

    fun deleteMatch(user: User) {
        deleteMatchUseCase.invoke(user)
    }
}