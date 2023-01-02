package com.example.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginregister.databinding.FragmentProductBinding
import kotlinx.android.synthetic.main.activity_merica.*
import kotlinx.android.synthetic.main.activity_merica.back
import kotlinx.android.synthetic.main.activity_susu_olahan.*

class SusuOlahanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_susu_olahan)
        btnBackSusuOlahanListener()
        btnKedelaiListener()
        btnKejuListener()
    }
    private fun btnBackSusuOlahanListener(){
        back.setOnClickListener{
            startActivity(Intent(this, FragmentProductBinding::class.java))
        }
    }
    private fun btnKedelaiListener(){
        img_kedelai.setOnClickListener {
            startActivity(Intent(this,KedelaiActivity::class.java))
        }
    }
    private fun btnKejuListener(){
        img_keju.setOnClickListener {
            startActivity(Intent(this,KejuActivity::class.java))
        }
    }
}