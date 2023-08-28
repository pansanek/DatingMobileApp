package ru.potemkin.dating.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import ru.potemkin.dating.data.DatingRepositoryImpl
import ru.potemkin.dating.domain.entities.User
import ru.potemkin.dating.domain.usecases.*
import javax.inject.Inject

class SwipeViewModel @Inject constructor(
    private val getUserListUseCase: GetUserListUseCase,
//    private val likeUserUseCase: LikeUserUseCase,
//    private val rejectUserUseCase: RejectUserUseCase,
    private val deleteMatchUseCase: DeleteMatchUseCase
) : ViewModel() {


    val userList = getUserListUseCase.invoke()

    fun deleteMatch(user: User) {
        Log.d("Swipe", "Deleted $user");
        deleteMatchUseCase.invoke(user)
    }
}