package ru.potemkin.dating.presentation.viewmodels

import androidx.lifecycle.ViewModel
import ru.potemkin.dating.data.DatingRepositoryImpl
import ru.potemkin.dating.domain.entities.User
import ru.potemkin.dating.domain.usecases.DeleteMatchUseCase
import ru.potemkin.dating.domain.usecases.GetUserListUseCase
import ru.potemkin.dating.domain.usecases.LikeUserUseCase
import ru.potemkin.dating.domain.usecases.RejectUserUseCase
import javax.inject.Inject

class MatchesViewModel @Inject constructor(
    private val getUserListUseCase: GetUserListUseCase,
    private val deleteMatchUseCase: DeleteMatchUseCase
) : ViewModel() {



    val userList = getUserListUseCase.invoke()

    fun deleteMatch(user: User) {
        deleteMatchUseCase.invoke(user)
    }
}