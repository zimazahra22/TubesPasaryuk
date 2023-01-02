package com.example.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_telur.*

class UdangActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_udang)
        btnBackUdangListener()
    }
    private fun btnBackUdangListener(){
        back.setOnClickListener{
            startActivity(Intent(this,IkanActivity::class.java))
        }
    }
}