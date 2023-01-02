package com.example.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginregister.databinding.FragmentProductBinding
import kotlinx.android.synthetic.main.activity_kayumanis.*
import kotlinx.android.synthetic.main.activity_kayumanis.back
import kotlinx.android.synthetic.main.activity_sayuran.*

class SayuranActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sayuran)
        btnBackSayuranListener()
        btnKolListener()
        btnWortelListener()
    }
    private fun btnBackSayuranListener(){
        back.setOnClickListener{
            startActivity(Intent(this, FragmentProductBinding::class.java))
        }
    }
    private fun btnKolListener(){
        img_kol.setOnClickListener {
            startActivity(Intent(this,KolActivity::class.java))
        }
    }
    private fun btnWortelListener(){
        img_wortel.setOnClickListener {
            startActivity(Intent(this,WortelActivity::class.java))
        }
    }
}