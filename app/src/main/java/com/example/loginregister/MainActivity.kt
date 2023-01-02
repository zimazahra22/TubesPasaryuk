package com.example.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_mainactivity.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainactivity)
        supportActionBar?.hide()

        btnLoginListener()
        btnRegisterListener()
    }

    private fun btnLoginListener(){
        btn.setOnClickListener{
            startActivity(Intent(this, Login::class.java))
        }
    }
    private fun btnRegisterListener(){
        btn2.setOnClickListener{
            startActivity(Intent(this, Register::class.java))
        }
    }
}