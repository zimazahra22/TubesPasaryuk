package com.example.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.loginregister.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
        
        lateinit var binding: ActivityLoginBinding
        lateinit var firebaseAuth: FirebaseAuth

        fun LoginFirebase(email: String, password: String) {
            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Selamat datang $email", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, Menu::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        fun btnBackListener() {
            l_pnh.setOnClickListener {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            binding = ActivityLoginBinding.inflate(layoutInflater)
            super.onCreate(savedInstanceState)
            setContentView(binding.root)

            firebaseAuth = FirebaseAuth.getInstance()

            binding.lLogin.setOnClickListener {
                val intent = Intent(this, Register::class.java)
                startActivity(intent)
            }

            binding.fPw.setOnClickListener {
                val intent = Intent(this, ResetPassword::class.java)
                startActivity(intent)
            }

            binding.lBtn.setOnClickListener {
                val email = binding.lkEmail.text.toString()
                val password = binding.lkPw.text.toString()

                //Validasi email
                if (email.isEmpty()) {
                    binding.lkEmail.error = "Email Harus Diisi"
                    binding.lkEmail.requestFocus()
                    return@setOnClickListener
                }

                //Validasi email tidak sesuai
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    binding.lkPw.error = "Email Tidak Valid"
                    binding.lkPw.requestFocus()
                    return@setOnClickListener
                }

                //Validasi password
                if (password.isEmpty()) {
                    binding.lkPw.error = "Password Harus Diisi"
                    binding.lkPw.requestFocus()
                    return@setOnClickListener
                }

                LoginFirebase(email, password)
            }
            btnBackListener()
        }

    }