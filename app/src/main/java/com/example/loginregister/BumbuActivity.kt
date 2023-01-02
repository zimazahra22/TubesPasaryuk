package com.example.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginregister.databinding.FragmentProductBinding
import kotlinx.android.synthetic.main.activity_bumbu.*

class BumbuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bumbu)
        btnBackBumbuListener()
        btnKayuManisListener()
        btnMericaListener()
    }
    private fun btnKayuManisListener() {
        img_kayumanis.setOnClickListener {
            startActivity(Intent(this, KayumanisActivity::class.java))
        }
    }
    private fun btnMericaListener(){
        img_merica.setOnClickListener {
            startActivity(Intent(this,MericaActivity::class.java))
        }
    }
    private fun btnBackBumbuListener(){
        back.setOnClickListener{
            startActivity(Intent(this,FragmentProductBinding::class.java))
        }
    }
}