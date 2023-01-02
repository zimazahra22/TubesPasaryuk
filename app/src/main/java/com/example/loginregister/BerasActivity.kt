package com.example.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginregister.databinding.FragmentProductBinding
import kotlinx.android.synthetic.main.activity_beras.*

class BerasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beras)
        btnBackBerasListener()
    }
    private fun btnBackBerasListener(){
        back.setOnClickListener{
            startActivity(Intent(this,FragmentProductBinding::class.java))
        }
    }
}