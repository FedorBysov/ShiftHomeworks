package com.example.shifthomeworks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.shifthomeworks.adapter.CardAdapter
import com.example.shifthomeworks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        adapter = CardAdapter()

        binding.rv.adapter = adapter

        binding.rv.recycledViewPool.setMaxRecycledViews(
            CardAdapter.ENABLED_VIEW,
            CardAdapter.POOL_VIEW_ACTIV
        )

        adapter.onClickItem= {
            Toast.makeText(applicationContext, "clicked on $it", Toast.LENGTH_SHORT).show()

        }

    }
}