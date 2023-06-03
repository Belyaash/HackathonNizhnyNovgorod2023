package com.example.novgorod

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.novgorod.databinding.FirstLoginGreetingBinding
import com.example.novgorod.databinding.MeroprDetailActivityBinding
import com.example.novgorod.databinding.RegistrationBinding
import kotlin.random.Random

class AuthActivity: AppCompatActivity() {
    private lateinit var binding: FirstLoginGreetingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FirstLoginGreetingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btn = findViewById<Button>(R.id.enter_button)
        btn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val txt: TextView = findViewById(R.id.textView5)
        txt.setOnClickListener{
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }

    }
}
