package com.example.roomviewlive

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Query
import com.example.roomandrecycleview.db.UserEntity
import com.example.roomandrecycleview.db2.UserEntity2
import kotlinx.android.synthetic.main.recyclerview_row.view.*
import kotlinx.android.synthetic.main.recyclerview_row2.view.*

class RecyclerViewAdapter2(val listener: RowClickListener) :
    RecyclerView.Adapter<RecyclerViewAdapter2.MyViewHolder>() {
    var items = ArrayList<UserEntity2>()


    fun setListData(data: ArrayList<UserEntity2>) {
        this.items = data
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter2.MyViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row2, parent, false)
        return MyViewHolder(inflater, listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter2.MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            listener.onItemClickListener(items[position])
        }
        holder.bind(items[position])
    }


    class MyViewHolder(view: View, val listener: RowClickListener) : RecyclerView.ViewHolder(view) {
        val tvName = view.tvName2
        val tvEmail = view.tvEmail2
        val tvPhone = view.tvPhone2
        val deleteUserID = view.deleteUserID2


        fun bind(data: UserEntity2) {
            tvName.text = data.name
            tvEmail.text = data.email
            tvPhone.text = data.phone.toString()

            // data.phone contains number of hours completed.... convert data.phone to integer and multiply by 15, convert back to string and
            // put value to tvPhone.text
            deleteUserID.setOnClickListener {
                listener.onDeleteUserClickListener(data)
            }

        }
    }

    interface RowClickListener {
        fun onDeleteUserClickListener(user: UserEntity2)
        fun onItemClickListener(user: UserEntity2)
    }
}