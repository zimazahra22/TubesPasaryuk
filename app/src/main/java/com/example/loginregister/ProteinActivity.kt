package com.example.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginregister.databinding.FragmentProductBinding
import kotlinx.android.synthetic.main.activity_nanas.*
import kotlinx.android.synthetic.main.activity_nanas.back
import kotlinx.android.synthetic.main.activity_protein.*

class ProteinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_protein)
        btnBackProteinListener()
        btnTelurListener()
        btnTempeListener()
    }
    private fun btnBackProteinListener(){
        back.setOnClickListener{
            startActivity(Intent(this, FragmentProductBinding::class.java))
        }
    }
    private fun btnTelurListener(){
        img_telur.setOnClickListener {
            startActivity(Intent(this,TelurActivity::class.java))
        }
    }
    private fun btnTempeListener(){
        img_tempe.setOnClickListener {
            startActivity(Intent(this,TempeActivity::class.java))
        }
    }
}