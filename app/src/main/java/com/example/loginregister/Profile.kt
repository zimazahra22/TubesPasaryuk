package com.example.loginregister

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loginregister.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth

class Profile : Fragment() {
    private var _binding: FragmentProfileBinding? = null

    lateinit var auth: FirebaseAuth

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        if (user != null){
            binding.kUser.setText(user.email)
        }

        binding.cPass.setOnClickListener {
            val intent = Intent(activity, ChangePassword::class.java)
            startActivity(intent)
        }

        binding.logout.setOnClickListener{
            tombolkeluar()
        }
    }

    private fun tombolkeluar(){
        auth = FirebaseAuth.getInstance()
        auth.signOut()
        val i = Intent(context, MainActivity::class.java)
        startActivity(i)
        activity?.finish()
    }
}