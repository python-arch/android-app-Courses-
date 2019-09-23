package com.example1.app

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_inflater.view.*

class CustomAdapter(val userList:ArrayList<data>) : RecyclerView.Adapter<CustomAdapter.viewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_inflater , parent , false)
        return viewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
    val data : data = userList[position]
        holder.text_name.text = data.name
        holder.text_age.text = data.pos
        holder.my_image.setImageResource(data.image)
        holder.data2 = data
    }

    class viewHolder(itemView : View , var data2: data?=null):RecyclerView.ViewHolder(itemView){
//        init{
////            itemView.setOnClickListener {
////               var int = Intent(itemView.context , ::class.java)
////                int.putExtra("name" , data2?.name)
////                itemView.context.startActivity(int)
////            }
//        }
        val text_name = itemView.name as TextView
        val text_age = itemView.age as TextView
        val my_image = itemView.image as ImageView

    }

}