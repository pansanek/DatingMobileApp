package ru.potemkin.dating.presentation

import androidx.recyclerview.widget.DiffUtil
import ru.potemkin.dating.domain.entities.User

class UserDiffCallback(): DiffUtil.ItemCallback<User>() {

    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem==newItem
    }
}