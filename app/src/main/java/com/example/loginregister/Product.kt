package com.example.loginregister

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.loginregister.databinding.FragmentProductBinding
import kotlinx.android.synthetic.main.fragment_product.*

 class Product : Fragment() {

        private var _binding: FragmentProductBinding? = null

        private val binding get() = _binding!!


        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            _binding = FragmentProductBinding.inflate(inflater, container, false)
            return binding.root
        }
        override fun onDestroy(){
            super.onDestroy()
            _binding = null
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            binding.imgBeras.setOnClickListener {
                val intent = Intent(activity, BerasActivity::class.java)
                startActivity(intent)
            }

            binding.imgIkan.setOnClickListener {
                val intent = Intent(activity, IkanActivity::class.java)
                startActivity(intent)
            }

            binding.imgDaging.setOnClickListener {
                val intent = Intent(activity, DagingActivity::class.java)
                startActivity(intent)
            }

            binding.imgProtein.setOnClickListener {
                val intent = Intent(activity, ProteinActivity::class.java)
                startActivity(intent)
            }

            binding.imgUnggas.setOnClickListener {
                val intent = Intent(activity, AyamActivity::class.java)
                startActivity(intent)
            }

            binding.imgSayuran.setOnClickListener {
                val intent = Intent(activity, SayuranActivity::class.java)
                startActivity(intent)
            }

            binding.imgBuah.setOnClickListener {
                val intent = Intent(activity, NanasActivity::class.java)
                startActivity(intent)
            }

            binding.imgSusu.setOnClickListener {
                val intent = Intent(activity, SusuOlahanActivity::class.java)
                startActivity(intent)
            }

            binding.imgBumbu.setOnClickListener {
                val intent = Intent(activity, BumbuActivity::class.java)
                startActivity(intent)
            }
        }
    }

