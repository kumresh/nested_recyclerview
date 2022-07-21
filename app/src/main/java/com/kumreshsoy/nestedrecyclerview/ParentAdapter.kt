package com.kumreshsoy.nestedrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ParentAdapter(private val context: Context, var parentList:ArrayList<Parent>):RecyclerView.Adapter<ParentAdapter.ParentHolder>() {
    private lateinit var childAdapter:ChildAdapter

    class ParentHolder(itemView:View):RecyclerView.ViewHolder(itemView){
      val title:TextView
      val mRecyclerView:RecyclerView
      init {
          title = itemView.findViewById(R.id.parent_title)
          mRecyclerView = itemView.findViewById(R.id.child_recyclerview)
      }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.parent_item, parent, false)
        return ParentHolder(mView)
    }

    override fun onBindViewHolder(holder: ParentHolder, position: Int) {
        holder.title.text = parentList[position].title

//        passing all movies list to the childadapter class
        childAdapter = ChildAdapter(parentList[position].movieList)
//        set layout to horizontal
        holder.mRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        holder.mRecyclerView.adapter = childAdapter
    }

    override fun getItemCount(): Int {
        return parentList.size
    }

}