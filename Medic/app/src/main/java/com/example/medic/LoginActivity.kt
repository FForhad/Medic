package com.example.medic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var mAuth: FirebaseAuth/** init the database */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        /** if already signed in */
        val currentuser = mAuth.currentUser
        if(currentuser != null) {
            startActivity(Intent(this@LoginActivity, DashActivity::class.java))
            finish()
        }

        /** login function */
        login()


        /** for unregistered user create account portal */
        val registerbtn = findViewById<Button>(R.id.button4)
        registerbtn.setOnClickListener{
            startActivity(Intent(this@LoginActivity, RegActivity::class.java))
        }

        /** for password recovery */
        val repass = findViewById<TextView>(R.id.textView3)
        repass.setOnClickListener{
            startActivity(Intent(this@LoginActivity, AccountRecoverActivity::class.java))
        }
    }
    private fun login() {
        val loginButton = findViewById<Button>(R.id.button3)
        val emailInput = findViewById<EditText>(R.id.editText)
        val passwordInput = findViewById<EditText>(R.id.editText2)

        /** if login btn tap */
        loginButton.setOnClickListener {
            if(TextUtils.isEmpty(emailInput.text.toString())){
                emailInput.setError("Please enter username")
                return@setOnClickListener
            }
            else if(TextUtils.isEmpty(passwordInput.text.toString())){
                emailInput.setError("Please enter password")
                return@setOnClickListener
            }
            /** access to database for matching user details */
            mAuth.signInWithEmailAndPassword(emailInput.text.toString(), passwordInput.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful) {
                        startActivity(Intent(this@LoginActivity, DashActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this@LoginActivity, "Login failed, please try again! ", Toast.LENGTH_LONG).show()
                    }
                }

        }
    }

}
