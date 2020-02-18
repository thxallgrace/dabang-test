package com.eunhye.dabang_test

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eunhye.dabang_test.model.Room
import kotlinx.android.synthetic.main.list_item.view.*


class RecyclerAdapter(private val context: Context, private val items : MutableList<Room>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        val listener = View.OnClickListener {it ->
            Toast.makeText(it.context, "Clicked: ${item.desc}", Toast.LENGTH_SHORT).show()
        }
        holder.apply {
            bind(context, listener, item)
            itemView.tag = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(inflatedView)
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v

        fun bind(context: Context, listener : View.OnClickListener, item: Room) {
            item.img_url.let {
                Glide.with(context)
                    .load(it)
                    .into(view.iv_room)
            }
            view.tv_price.text = item.price_title
            view.tv_desc.text = item.desc
            view.tv_room_type.text = item.getRoomTypeName()
            view.setOnClickListener(listener)
        }
    }
}


