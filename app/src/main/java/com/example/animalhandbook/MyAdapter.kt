package com.example.animalhandbook

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView



class MyAdapter (listArray: ArrayList<ListItem>, context: Context) : RecyclerView.Adapter<MyAdapter.ViewHolder>(){

    var listArrayAB: ArrayList<ListItem> = listArray
    var contextAB: Context = context

    class ViewHolder (view: View)  : RecyclerView.ViewHolder(view)  {


    val tvTitle = view.findViewById<TextView>(R.id.tv_title)
    val tvContent = view.findViewById<TextView>(R.id.tv_content)
    val im = view.findViewById<ImageView>(R.id.imageView2)

    fun bind(listItem: ListItem, context: Context){
        tvTitle.text = listItem.titleText
        val textCon = listItem.contentText.substring(0,70) + "..."
        tvContent.text = textCon
        im.setImageResource(listItem.imageID)

       itemView.setOnClickListener(){

            val i = Intent(context, TextContentActivity::class.java).apply {
                putExtra("title", tvTitle.text.toString())
                putExtra("content", listItem.contentText)
                putExtra("image", listItem.imageID )
            }
         context.startActivity(i)
        }
    }

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextAB).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(inflater)
    }


    override fun getItemCount(): Int {
      return  listArrayAB.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = listArrayAB[position]
        holder.bind(listItem, contextAB)
    }

    fun updateAdapter(newListArray: List<ListItem>){
        listArrayAB.clear()
        listArrayAB.addAll(newListArray)
        notifyDataSetChanged()
    }
}