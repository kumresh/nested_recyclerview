package com.kumreshsoy.nestedrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ChildAdapter(private val myChildList:ArrayList<Movie>):RecyclerView.Adapter<ChildAdapter.ChildHolder>() {
    class ChildHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val title:TextView
        val img:ImageView
        init {
            title = itemView.findViewById(R.id.child_title)
            img = itemView.findViewById(R.id.child_img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.child_item, parent, false)
        return ChildHolder(mView)
    }

    override fun onBindViewHolder(holder: ChildHolder, position: Int) {
        holder.title.text = myChildList[position].title

//        if your are using image url(internet) then you need to add internet permission
//         <uses-permission android:name="android.permission.INTERNET"/>
//        loading image from internet by using glide
        Glide.with(holder.itemView.context)
            .load(myChildList[position].img)
            .into(holder.img)
    }

    override fun getItemCount(): Int {
        return myChildList.size
    }

}