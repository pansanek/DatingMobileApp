package ru.potemkin.dating.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation
import ru.potemkin.dating.R
import ru.potemkin.dating.databinding.ActivityMatchesBinding
import ru.potemkin.dating.domain.entities.User
import ru.potemkin.dating.presentation.UserDiffCallback
import ru.potemkin.dating.presentation.UserViewHolder
import ru.potemkin.dating.databinding.ItemMatchBinding
import ru.potemkin.dating.databinding.ItemMessageBinding

class MatchesAdapter : ListAdapter<User, UserViewHolder>(UserDiffCallback()) {

    //    var onShopItemLongClickListener: ((User) -> Unit)? = null
    var onItemClickListener: ((User) -> Unit)? = null
    var type: Boolean = true

    val transformation: Transformation = RoundedCornersTransformation(CORNER_RADIUS, 0)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layout = when (viewType) {
            VIEW_TYPE_MATCHES -> R.layout.item_match
            VIEW_TYPE_MESSAGE -> R.layout.item_message
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            layout,
            parent,
            false
        )
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: UserViewHolder, position: Int) {
        val user = getItem(position)
        val binding = viewHolder.binding
//        binding.root.setOnLongClickListener {
//            onShopItemLongClickListener?.invoke(user)
//            true
//        }
        binding.root.setOnClickListener {
            onItemClickListener?.invoke(user)
        }
        when (binding) {
            is ItemMatchBinding -> {
                binding.user = user
                Picasso.get().load(user.image).transform(transformation).fit().centerCrop().into(binding.userPicture);
            }
            is ItemMessageBinding -> {
                binding.user = user
                Picasso.get().load(user.image).transform(transformation).fit().centerCrop().into(binding.userPicture);
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (type) {
            VIEW_TYPE_MATCHES
        } else {
            VIEW_TYPE_MESSAGE
        }
    }

    fun changeType(){
        type = !type
    }

    companion object {

        const val VIEW_TYPE_MATCHES = 100
        const val VIEW_TYPE_MESSAGE = 101

        const val MAX_POOL_SIZE = 30
        const val CORNER_RADIUS = 128
    }
}