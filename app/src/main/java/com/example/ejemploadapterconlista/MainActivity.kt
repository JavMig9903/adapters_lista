package com.example.ejemploadapterconlista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejemploadapterconlista.databinding.ActivityMainBinding
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter : StringAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createRecyclerView()
    }

    private fun createRecyclerView() {
        val laListadelLoro = mutableListOf<String>()
        var random = Random
        var inicio= random.nextInt(5..10)
        for (i in 0..inicio){
            laListadelLoro.add("PC-${i}")
        }

        adapter = StringAdapter(laListadelLoro.toMutableList())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

}