package com.example.callbacks

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val context: Context) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    lateinit var callback: ActivityInterface
    private var mList: List<Data> = mutableListOf()

    fun setList(list: List<Data>) {
        mList = list
        println(mList)
    }

    fun setCallback(mCallback: MainActivity) {
        this.callback = mCallback
    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val data = mList[position]

        // sets the image to the imageview from our itemHolder class
        //holder.imageView.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.textView1.text = data.time
        holder.textView2.text = data.clicked.toString()

        holder.textView1.setOnClickListener {
            callback.click(position)
        }

        holder.itemLine.setBackgroundColor(
            when (data.period) {
                Daytime.MORNING -> context.resources.getColor(R.color.Morning)
                Daytime.DAY -> context.resources.getColor(R.color.Day)
                Daytime.EVENING -> context.resources.getColor(R.color.Evening)
                Daytime.NIGHT -> context.resources.getColor(R.color.Night)
            }
        )
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView1: TextView = itemView.findViewById(R.id.textView1)
        val textView2: TextView = itemView.findViewById(R.id.textCount)
        val itemLine: LinearLayout = itemView.findViewById(R.id.itemLine)
    }
}