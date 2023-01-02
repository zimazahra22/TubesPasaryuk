package com.example.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginregister.databinding.FragmentProductBinding
import kotlinx.android.synthetic.main.activity_kembung.*

class NanasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nanas)
        btnBackNanasListener()
    }
    private fun btnBackNanasListener(){
        back.setOnClickListener{
            startActivity(Intent(this, FragmentProductBinding::class.java))
        }
    }
}