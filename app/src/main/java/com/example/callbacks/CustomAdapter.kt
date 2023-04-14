package com.example.callbacks

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.callbacks.databinding.CardViewDesignBinding
import com.example.callbacks.databinding.CardViewDesignDayBinding
import com.example.callbacks.databinding.CardViewDesignEveningBinding
import com.example.callbacks.databinding.CardViewDesignNightBinding

class CustomAdapter(val context: Context) : RecyclerView.Adapter<ViewHolder>(){
    lateinit var callback: ActivityInterface
    private var mList: List<Data> = mutableListOf()
    private lateinit var bindingM: CardViewDesignBinding
    private lateinit var bindingD: CardViewDesignDayBinding
    private lateinit var bindingE: CardViewDesignEveningBinding
    private lateinit var bindingN: CardViewDesignNightBinding


    fun setList(list: List<Data>) {
        mList = list
        println(mList)
    }

    fun setCallback(mCallback: MainActivity) {
        this.callback = mCallback
    }

    override fun getItemViewType(position: Int): Int {
        val data = mList[position]
        return when (data.period) {

            Daytime.MORNING -> {
                Daytime.MORNING.value
            }
            Daytime.DAY -> {
                Daytime.DAY.value
            }
            Daytime.EVENING -> {
                Daytime.EVENING.value
            }
            Daytime.NIGHT -> {
                Daytime.NIGHT.value
            }
        }
        //return super.getItemViewType(position)
    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            Daytime.MORNING.value -> {
                bindingM = CardViewDesignBinding.inflate(
                    LayoutInflater.from(parent.context),parent,false)
                MorningViewHolder(bindingM)
            }
            Daytime.DAY.value -> {
                bindingD = CardViewDesignDayBinding.inflate(
                    LayoutInflater.from(parent.context),parent, false)
                DayViewHolder(bindingD)
            }
            Daytime.EVENING.value -> {
                bindingE = CardViewDesignEveningBinding.inflate(
                    LayoutInflater.from(parent.context),parent, false)
                EveningViewHolder(bindingE)
            }
            Daytime.NIGHT.value -> {
                bindingN = CardViewDesignNightBinding.inflate(
                    LayoutInflater.from(parent.context),parent, false)
                NightViewHolder(bindingN)
            }
            else -> throw IllegalArgumentException("Invalid view type")

                //val view = LayoutInflater.from(parent.context)
                  //  .inflate(R.layout.card_view_design, parent, false)
                //MorningViewHolder(view)
            //}
        }
    }

        // inflates the card_view_design view
        // that is used to hold list item
        //val view = LayoutInflater.from(parent.context)
        //  .inflate(R.layout.card_view_design, parent, false)

        //return ViewHolder(view)

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val data = mList[position]

        when (holder){
            is MorningViewHolder -> holder.bind(data)
            is DayViewHolder -> holder.bind(data)
            is EveningViewHolder -> holder.bind(data)
            is NightViewHolder -> holder.bind(data)

        }


        // sets the image to the imageview from our itemHolder class
        //holder.imageView.setImageResource(ItemsViewModel.image)
        val textCount = holder.itemView.findViewById<TextView>(R.id.textCount)
        val textView = holder.itemView.findViewById<TextView>(R.id.textView)
        textView.text = data.time
        textCount.text = data.clicked.toString()
        textView.setOnClickListener(){
            callback.click(position)
        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    class MorningViewHolder(binding: CardViewDesignBinding):
        ViewHolder(binding.root) {
        fun bind(data: Data) {
        }
    }

    class DayViewHolder(binding: CardViewDesignDayBinding):
        ViewHolder(binding.root) {
        fun bind(data: Data) {
        }
    }

    class EveningViewHolder(binding: CardViewDesignEveningBinding):
        ViewHolder(binding.root) {
        fun bind(data: Data) {
        }
    }

    class NightViewHolder(binding: CardViewDesignNightBinding):
        ViewHolder(binding.root) {
        fun bind(data: Data) {
        }
    }
/*
    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView1: TextView = itemView.findViewById(R.id.textView1)
        val textView2: TextView = itemView.findViewById(R.id.textCount)
        val itemLine: LinearLayout = itemView.findViewById(R.id.itemLine)
    }
*/
}