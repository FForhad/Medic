package com.example.medic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class AgentActivity : AppCompatActivity() {
    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agent)

        mAuth = FirebaseAuth.getInstance()
        login()/** for login agent */
    }
    private fun login() {
        val loginButton = findViewById<Button>(R.id.button7)
        val emailInput = findViewById<EditText>(R.id.editTextTextPersonName2)
        val passwordInput = findViewById<EditText>(R.id.editTextTextPassword)

        /** checks the required data getting or not while tapping loging button */
        loginButton.setOnClickListener {
            if(TextUtils.isEmpty(emailInput.text.toString())){
                emailInput.setError("Please enter username")
                return@setOnClickListener
            }
            else if(TextUtils.isEmpty(passwordInput.text.toString())){
                emailInput.setError("Please enter password")
                return@setOnClickListener
            }

            /** account details store */
            mAuth.signInWithEmailAndPassword(emailInput.text.toString(), passwordInput.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful) {
                        startActivity(Intent(this, AgentHomeActivity::class.java))

                    } else {
                        Toast.makeText(this, "Login failed, please try again! ", Toast.LENGTH_LONG).show()
                    }
                }

        }
    }
}