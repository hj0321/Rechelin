package com.example.rechelin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rechelin.databinding.ActivityListBinding
import com.example.rechelin.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding : ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}