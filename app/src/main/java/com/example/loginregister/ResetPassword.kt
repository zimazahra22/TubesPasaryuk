package com.example.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.loginregister.databinding.ActivityResetPasswordBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_reset_password.*

class ResetPassword : AppCompatActivity() {
    lateinit var binding: ActivityResetPasswordBinding
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityResetPasswordBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        rstbtn.setOnClickListener {
            val email = binding.inemail.text.toString()

            if (email.isEmpty()) {
                binding.inemail.error = "Email Harus Diisi"
                binding.inemail.requestFocus()
                return@setOnClickListener
            }

            //Validasi email tidak sesuai
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.inemail.error = "Email Tidak Valid"
                binding.inemail.requestFocus()
                return@setOnClickListener
            }

            firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(this,"Cek Email untuk Reset Password", Toast.LENGTH_SHORT).show()
                    Intent(this@ResetPassword, Login::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                    }
                }else{
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btnBackListener()
    }
    private fun btnBackListener() {
        rpnh.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }
    }
}