package ru.potemkin.dating.presentation.adapters

import ru.potemkin.dating.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation
import ru.potemkin.dating.databinding.ItemUserBackLayoutBinding
import ru.potemkin.dating.databinding.ItemUserLayoutBinding
import ru.potemkin.dating.domain.entities.User
import ru.potemkin.dating.presentation.UserDiffCallback
import ru.potemkin.dating.presentation.UserViewHolder


class SwipeAdapter:
    ListAdapter<User,UserViewHolder>(UserDiffCallback()) {

    var onItemClickListener: ((User) -> Unit)? = null
    var type: Boolean = true

    val transformation: Transformation = RoundedCornersTransformation(CORNER_RADIUS, 0)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layout = when (viewType) {
            VIEW_TYPE_FRONT -> R.layout.item_user_layout
            VIEW_TYPE_BACK -> R.layout.item_user_back_layout
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

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        val binding = holder.binding
        binding.root.setOnClickListener {
            onItemClickListener?.invoke(user)
        }
        when (binding) {
            is ItemUserLayoutBinding -> {
                binding.user = user
                Picasso.get().load(user.image).transform(transformation).fit().centerCrop().into(binding.itemImage);
            }
            is ItemUserBackLayoutBinding -> {
                binding.user = user
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (type) {
           VIEW_TYPE_FRONT
        } else {
            VIEW_TYPE_BACK
        }
    }

    fun changeType(){
        type = !type
    }

    companion object {

        const val VIEW_TYPE_FRONT = 100
        const val VIEW_TYPE_BACK = 101

        const val CORNER_RADIUS = 80
    }

}