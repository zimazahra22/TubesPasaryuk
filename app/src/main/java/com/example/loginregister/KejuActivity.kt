package com.example.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_kayumanis.*

class KejuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keju)
        btnBackKejuListener()
    }
    private fun btnBackKejuListener(){
        back.setOnClickListener{
            startActivity(Intent(this,SusuOlahanActivity::class.java))
        }
    }
}