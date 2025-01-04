package com.example.dyp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dyp.databinding.ActivityLabsBinding

class Labs : AppCompatActivity() {

    private val binding: ActivityLabsBinding by lazy{
        ActivityLabsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.CSE.setOnClickListener {
            val intent = Intent(this, CSE_lab::class.java)
            startActivity(intent)
        }

        binding.Electrical.setOnClickListener {
            val intent = Intent(this, ElectricalLab::class.java)
            startActivity(intent)
        }

    }
}

