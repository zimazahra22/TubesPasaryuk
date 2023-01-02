package com.example.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tempe.*

class TempeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tempe)
        btnBackTempeListener()
    }
    private fun btnBackTempeListener(){
        back.setOnClickListener{
            startActivity(Intent(this,ProteinActivity::class.java))
        }
    }
}