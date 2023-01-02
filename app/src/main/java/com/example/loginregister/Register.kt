package com.example.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.loginregister.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*


class Register : AppCompatActivity() {

        private lateinit var binding: ActivityRegisterBinding
        private lateinit var firebaseAuth: FirebaseAuth

        fun RegistFirebase(email: String, password: String) {
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Register Berhasil", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, Login::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        fun btnBackListener() {
            r_pnh.setOnClickListener {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            binding = ActivityRegisterBinding.inflate(layoutInflater)
            super.onCreate(savedInstanceState)
            setContentView(binding.root)

            firebaseAuth = FirebaseAuth.getInstance()

            binding.rSign.setOnClickListener {
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
            }

            binding.rBtn.setOnClickListener{
                val name = binding.rkName.text.toString()
                val email = binding.rkEmail.text.toString()
                val password = binding.rkPw.text.toString()
                val password2 = binding.rkPw2.text.toString()

                //Validasi nama lengkap
                if (name.isEmpty()) {
                    binding.rkName.error = "Nama Harus Diisi"
                    binding.rkName.requestFocus()
                    return@setOnClickListener
                }

                //Validasi email
                if (email.isEmpty()) {
                    binding.rkEmail.error = "Email Harus Diisi"
                    binding.rkEmail.requestFocus()
                    return@setOnClickListener
                }

                //Validasi email tidak sesuai
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    binding.rkEmail.error = "Email Tidak Valid"
                    binding.rkEmail.requestFocus()
                    return@setOnClickListener
                }

                //Validasi password
                if (password.isEmpty()) {
                    binding.rkPw.error = "Password Harus Diisi"
                    binding.rkPw.requestFocus()
                    return@setOnClickListener
                }

                //Validasi password2
                if (password.isEmpty()) {
                    binding.rkPw2.error = "Konfirmasi Ulang Password"
                    binding.rkPw2.requestFocus()
                    return@setOnClickListener
                }

                if (!password.equals(password2)) {
                    binding.rkPw2.error = "Password Tidak Sesuai!!!"
                    binding.rkPw2.requestFocus()
                    return@setOnClickListener
                }

                RegistFirebase(email,password)
            }

            btnBackListener()
        }
}

