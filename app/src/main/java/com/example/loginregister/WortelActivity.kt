package com.example.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tempe.*

class WortelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wortel)
        btnBackWortelListener()
    }
    private fun btnBackWortelListener(){
        back.setOnClickListener{
            startActivity(Intent(this,SayuranActivity::class.java))
        }
    }
}