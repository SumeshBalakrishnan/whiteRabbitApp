package com.whiterabbit.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.whiterabbit.test.model.Response
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(private val users: ArrayList<Response>) :
    RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: Response) {
            itemView.apply {
                textViewUserName.text = user.name
                textViewUserEmail.text = user.email
                Glide.with(this).load(user.profileImage).into(imageViewAvatar)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(users[position])
    }

    fun addUsers(users: List<Response>) {
        this.users.apply {
            clear()
            addAll(users)
        }

    }
}