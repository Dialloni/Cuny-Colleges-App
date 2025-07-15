package com.example.cunymapapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cunymapapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ✅ This line crashes if ViewBinding is broken or XML file is wrong
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Optional default fragment on start
        supportFragmentManager.beginTransaction()
            .add(R.id.frameLayout, CollegeListFragment()) // or MapFragment()
            .commit()

        // Button: Show Map
        binding.button.setOnClickListener {
            val address = binding.editText.text.toString()
            val mapFragment = MapFragment().apply {
                arguments = Bundle().apply {
                    putString("address", address)
                }
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, mapFragment)
                .commit()
        }

        // Button: Show CUNY College List
        binding.buttonGetList.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, CollegeListFragment())
                .commit()
        }
    }
}
