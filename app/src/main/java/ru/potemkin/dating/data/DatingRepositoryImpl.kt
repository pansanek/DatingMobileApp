package ru.potemkin.dating.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.potemkin.dating.R
import ru.potemkin.dating.domain.entities.*
import ru.potemkin.dating.domain.repository.DatingRepository
import kotlin.random.Random

object DatingRepositoryImpl: DatingRepository {
    private val userListLiveData = MutableLiveData<List<User>>()
    private val userList= mutableListOf<User>()

    private var autoIncrementId =0
    init{
        val interestsNastya = listOf(
            Interest("Путешествия"),
            Interest("Фотография"),
            Interest("Чтение")
        )
        val interestsArina = listOf(
            Interest("Искусство"),
            Interest("Музыка"),
            Interest("Садоводство")
        )
        val interestsLiza = listOf(
            Interest("Плавание"),
            Interest("Танцы"),
            Interest("Шопинг")
        )
        val interestsLera = listOf(
            Interest("Фитнес"),
            Interest("Кулинария"),
            Interest("Горные лыжи")
        )

        addUser(User("Настя", 21, Gender.FEMALE, "Привет! Люблю путешествовать и фотографировать. Также увлекаюсь чтением.", R.drawable.sample1, "Москва", interestsNastya))
        addUser(User("Арина", 86, Gender.FEMALE, "Привет! Я художник и музыкант. Также люблю заниматься садоводством.", R.drawable.sample2, "Санкт-Петербург", interestsArina))
        addUser(User("Лиза", 21, Gender.FEMALE, "Привет! Обожаю плавать и танцевать. Также у меня слабость к шопингу.", R.drawable.sample3, "Москва", interestsLiza))
        addUser(User("Лера", 30, Gender.FEMALE, "Привет! Я фитнес-инструктор и люблю готовить. В зимнее время предпочитаю горные лыжи.", R.drawable.sample4, "Минск", interestsLera))

    }
    override fun addUser(user:User) {
        if(user.id == User.UNDEFINED_ID) {
            user.id = autoIncrementId++
        }
        userList.add(user)
        updateList()
    }
    override suspend fun likeUser(
        currentUserId: String,
        userIdToLike: String
    ): LiveData<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun rejectUser(
        currentUserId: String,
        userIdToReject: String
    ): LiveData<Boolean> {
        TODO("Not yet implemented")
    }

    override fun getUser(currentUserId: Int): User {
        return userList.find {
            it.id == currentUserId
        } ?: throw java.lang.RuntimeException("Element with id $currentUserId not found")
    }
    override fun getUserList(): LiveData<List<User>> {
        return userListLiveData
    }

    override suspend fun getMatches(currentUserId: String): LiveData<List<User>> {
        TODO("Not yet implemented")
    }

    override suspend fun getUserProfile(
        currentUserId: String,
        profileUserId: String
    ): LiveData<Profile> {
        TODO("Not yet implemented")
    }

    override suspend fun updateUserProfile(
        currentUserId: String,
        updatedProfile: Profile
    ): LiveData<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun sendMessage(
        senderUserId: String,
        receiverUserId: String,
        message: String
    ): LiveData<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun getMessages(
        currentUserId: String,
        otherUserId: String
    ): LiveData<List<Message>> {
        TODO("Not yet implemented")
    }

    override suspend fun updateUserLocation(
        currentUserId: String,
        newLocation: Location
    ): LiveData<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun getUsersNearby(
        currentUserId: String,
        radius: Double
    ): LiveData<List<User>> {
        TODO("Not yet implemented")
    }
    override fun deleteMatch(user: User) {
        userList.remove(user)
        updateList()
    }
    private fun updateList(){
        userListLiveData.value = userList.toList()
    }
}