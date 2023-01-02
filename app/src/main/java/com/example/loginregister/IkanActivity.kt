package com.example.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginregister.databinding.FragmentProductBinding
import kotlinx.android.synthetic.main.activity_bumbu.*
import kotlinx.android.synthetic.main.activity_bumbu.back
import kotlinx.android.synthetic.main.activity_ikan.*

class IkanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ikan)
        btnBackIkanSeafoodListener()
        btnkembungListener()
        btnUdangListener()
    }
    private fun btnBackIkanSeafoodListener(){
        back.setOnClickListener{
            startActivity(Intent(this,FragmentProductBinding::class.java))
        }
    }
    private fun btnkembungListener(){
        img_kembung.setOnClickListener{
            startActivity(Intent(this,KembungActivity::class.java))
        }
    }
    private fun btnUdangListener(){
        img_udang.setOnClickListener {
            startActivity(Intent(this,UdangActivity::class.java))
        }
    }
}