package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class your_house : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_your_house)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_room)
        recyclerView.layoutManager = LinearLayoutManager(this)
      //  recyclerView.adapter = CustomRecyclerAdapter()
//
//        val arrayT: ArrayList<TestData> = ArrayList()
//        Log.e("!!","2")
    }
}
//data class TestData(val text: String  )