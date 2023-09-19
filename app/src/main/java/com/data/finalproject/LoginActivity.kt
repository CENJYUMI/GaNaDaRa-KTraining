package com.data.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.data.finalproject.databinding.ActivityLoginBinding

import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.txtSignUP.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.signInBtn.setOnClickListener {

            val email = binding.etEmailL.text.toString()
            val pass = binding.etPasswordL.text.toString()

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this@LoginActivity, "Enter email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(pass)) {
                Toast.makeText(this@LoginActivity, "Enter password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

//            binding.progressBar.visibility = View.VISIBLE


            firebaseAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener {
//                    binding.progressBar.visibility = View.INVISIBLE
                    if (it.isSuccessful) {
                        Toast.makeText(this@LoginActivity, "Login Successful", Toast.LENGTH_SHORT)
                            .show()
                        val intent = Intent(this, WelcomeActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(
                            this@LoginActivity,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
//                        binding.progressBar.visibility = View.INVISIBLE
                    }
                }


        }
    }

    override fun onStart(){
        super.onStart()

        val currentUser = firebaseAuth.currentUser
        if(currentUser != null){
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

}