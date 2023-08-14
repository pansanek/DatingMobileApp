package ru.potemkin.dating.presentation.viewmodels

import androidx.lifecycle.ViewModel
import ru.potemkin.dating.data.DatingRepositoryImpl
import ru.potemkin.dating.domain.usecases.*

class SwipeViewModel : ViewModel() {

    private val repository = DatingRepositoryImpl

    private val getUserListUseCase = GetUserListUseCase(repository)
    private val likeUserUseCase = LikeUserUseCase(repository)
    private val rejectUserUseCase = RejectUserUseCase(repository)


    val userList = getUserListUseCase.invoke()
}