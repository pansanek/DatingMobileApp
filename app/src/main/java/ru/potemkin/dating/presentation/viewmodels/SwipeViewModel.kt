package ru.potemkin.dating.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import ru.potemkin.dating.data.DatingRepositoryImpl
import ru.potemkin.dating.domain.entities.User
import ru.potemkin.dating.domain.usecases.*

class SwipeViewModel : ViewModel() {

    private val repository = DatingRepositoryImpl

    private val getUserListUseCase = GetUserListUseCase(repository)
    private val likeUserUseCase = LikeUserUseCase(repository)
    private val rejectUserUseCase = RejectUserUseCase(repository)
    private val deleteMatchUseCase = DeleteMatchUseCase(repository)


    val userList = getUserListUseCase.invoke()

    fun deleteMatch(user: User) {
        Log.d("Swipe", "Deleted $user");
        deleteMatchUseCase.invoke(user)
    }
}