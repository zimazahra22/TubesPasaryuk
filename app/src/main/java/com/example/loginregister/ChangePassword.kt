package com.example.loginregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.loginregister.databinding.ActivityChangePasswordBinding
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import kotlinx.android.synthetic.main.activity_change_password.*

class ChangePassword : AppCompatActivity() {

    private lateinit var binding: ActivityChangePasswordBinding
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        binding.cdvLpass.visibility = View.VISIBLE
        binding.cdvBpass.visibility = View.GONE

        binding.glPass.setOnClickListener {

            val oldPassword = binding.passLama.text.toString()

            if (oldPassword.isEmpty()) {
                binding.passLama.error = "Password Tidak Boleh Kosong"
                binding.passLama.requestFocus()
                return@setOnClickListener
            }

            user.let {

                val userCredential = EmailAuthProvider.getCredential(it?.email!!, oldPassword)
                it.reauthenticate(userCredential).addOnCompleteListener { Task ->
                    when {
                        Task.isSuccessful -> {
                            binding.cdvLpass.visibility = View.GONE
                            binding.cdvBpass.visibility = View.VISIBLE
                        }
                        Task.exception is FirebaseAuthInvalidCredentialsException -> {
                            binding.passLama.error = "Password Salah"
                            binding.passLama.requestFocus()
                        }
                        else -> {
                            Toast.makeText(this, "${Task.exception?.message}", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }
        }

        binding.gbPass.setOnClickListener newPassword@{
            val newPassword = binding.passBaru.text.toString()
            val confirmPassword = binding.passBaru2.text.toString()

            if (newPassword.isEmpty()) {
                binding.passBaru.error = "Password Tidak Boleh Kosong"
                binding.passBaru.requestFocus()
                return@newPassword
            }
            if (newPassword.isEmpty()) {
                binding.passBaru2.error = "Password Confirm Tidak Boleh Kosong"
                binding.passBaru2.requestFocus()
                return@newPassword
            }
            if (newPassword != confirmPassword) {
                binding.passBaru2.error = "Password Tidak Sama"
                binding.passBaru2.requestFocus()
                return@newPassword
            }
            if (newPassword.length < 6) {
                binding.passBaru.error = "Minimal Password 6 Karakter"
                binding.passBaru.requestFocus()
                return@newPassword
            }
            if (confirmPassword.length < 6) {
                binding.passBaru2.error = "Minimal Password 6 Karakter"
                binding.passBaru2.requestFocus()
                return@newPassword
            }

            user.let {
                it?.updatePassword(newPassword)?.addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(this,"Password Berhasil Diubah Silahkan Login Kembali", Toast.LENGTH_SHORT).show()
                    logout()
                    }
                }
            }
        }
    }

    private fun logout(){
        auth = FirebaseAuth.getInstance()
        auth.signOut()
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
}