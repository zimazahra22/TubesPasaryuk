package com.example.loginregister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.loginregister.databinding.ActivityMenuBinding

class Menu : AppCompatActivity() {
    private lateinit var binding : ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragmen(Product())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.product -> replaceFragmen(Product())
                R.id.location -> replaceFragmen(Location())
                R.id.profile -> replaceFragmen(Profile())

                else ->{
                }
            }
            true

        }
    }
    private fun replaceFragmen(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.flmenu,fragment)
        fragmentTransaction.commit()
    }
}