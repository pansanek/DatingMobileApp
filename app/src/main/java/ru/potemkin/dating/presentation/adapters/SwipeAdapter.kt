package ru.potemkin.dating.presentation.adapters

import ru.potemkin.dating.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.potemkin.dating.domain.entities.User


class SwipeAdapter(items: List<User>) :
    RecyclerView.Adapter<SwipeAdapter.ViewHolder>() {

    private var items: List<User>

    init {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.item_user_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = items[position].name
        holder.age.text = items[position].age.toString()
        Picasso.get().load(items[position].image).fit().centerCrop().into(holder.image);
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //var image: ImageView
        var name: TextView
        var age: TextView
        var image: ImageView
        //var kota: TextView

        init {
            name = itemView.findViewById(R.id.name_tv)
            age = itemView.findViewById(R.id.age_tv)
            image = itemView.findViewById(R.id.item_image)
            //kota = itemView.findViewById(R.id.item_city)
        }


    }


}