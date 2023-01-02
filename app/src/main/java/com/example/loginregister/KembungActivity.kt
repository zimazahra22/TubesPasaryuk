package com.example.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_kayumanis.*

class KembungActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kembung)
        btnBackKembungListener()
    }
    private fun btnBackKembungListener(){
        back.setOnClickListener{
            startActivity(Intent(this,IkanActivity::class.java))
        }
    }
}