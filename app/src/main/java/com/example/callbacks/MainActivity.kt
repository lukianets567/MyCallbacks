package com.example.callbacks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.callbacks.databinding.ActivityMainBinding
import com.example.callbacks.databinding.CardViewDesignBinding

class MainActivity : AppCompatActivity(), ActivityToastInterface {
    private lateinit var binding: ActivityMainBinding
    private lateinit var binding1: CardViewDesignBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val binding1 = CardViewDesignBinding.inflate(layoutInflater)




        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<Data>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..12) {
            data.add(Data(R.array.time_list.toString(),R.array.period_list1._, 0))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)
        adapter.setCallback(this)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter


    }

    override fun click(clicked: Int) {
        clicked.plus(1)
    }
}