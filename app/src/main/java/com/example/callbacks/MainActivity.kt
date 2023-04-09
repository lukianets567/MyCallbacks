package com.example.callbacks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.callbacks.databinding.ActivityMainBinding
import com.example.callbacks.databinding.CardViewDesignBinding

class MainActivity : AppCompatActivity(), ActivityInterface {
    private lateinit var binding: ActivityMainBinding
    lateinit var data: List<Data>
    lateinit var adapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // this creates a vertical layout Manager
        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
//        val data = ArrayList<Data>()

        // This loop will create 20 Views containing
        // the image with the count of view
//        for (i in 1..12) {
//            data.add(Data(R.array.time_list.toString(),R.array.period_list1._, 0))
//        }
        data = mutableListOf<Data>(
            Data("16:20", Daytime.DAY, 1),
            Data("7:20", Daytime.MORNING, 0),
            Data("10:01", Daytime.MORNING, 2),
            Data("12:05", Daytime.NIGHT, 4),
            Data("3:27", Daytime.EVENING, 3),
        )

        // This will pass the ArrayList to our Adapter
        adapter = CustomAdapter(this)
        adapter.setCallback(this)
        adapter.setList(data)

        // Setting the Adapter with the recyclerview
        binding.recyclerview.adapter = adapter
    }

    override fun click(position: Int) {
        data[position].clicked++
        adapter.setList(data)
        adapter.notifyItemChanged(position)
    }
}