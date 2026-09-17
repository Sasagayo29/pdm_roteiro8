package com.example.pdm_roteiro8

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pdm_roteiro8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null //[cite: 3]
    private val binding get() = _binding!! //[cite: 3]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() //[cite: 3]

        _binding = ActivityMainBinding.inflate(layoutInflater) //[cite: 3]
        setContentView(binding.root) //[cite: 3]

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets -> //[cite: 3]
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars()) //[cite: 3]
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom) //[cite: 3]
            insets //[cite: 3]
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
