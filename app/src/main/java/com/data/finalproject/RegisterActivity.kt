package com.data.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.data.finalproject.databinding.ActivityMainBinding
import com.data.finalproject.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.txtSignIN.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.signUpBtn.setOnClickListener {
            val email = binding.etEmailS.text.toString()
            val pass = binding.etPasswordS.text.toString()
            val name = binding.etNameS.text.toString()
            val username = binding.etUsernameS.text.toString()

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this@RegisterActivity, "Enter email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(pass)) {
                Toast.makeText(this@RegisterActivity, "Enter password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(name)) {
                Toast.makeText(this@RegisterActivity, "Enter your name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(username)) {
                Toast.makeText(this@RegisterActivity, "Enter your username", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            binding.progressBar2.visibility = View.VISIBLE

            firebaseAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener {
                    binding.progressBar2.visibility = View.INVISIBLE
                    if (it.isSuccessful) {
                        Toast.makeText(
                            this@RegisterActivity,
                            "Account created.",
                            Toast.LENGTH_SHORT
                        ).show()
                        val intent = Intent(applicationContext, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(
                            this@RegisterActivity,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }

    }
    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = firebaseAuth.currentUser
        if (currentUser != null) {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}