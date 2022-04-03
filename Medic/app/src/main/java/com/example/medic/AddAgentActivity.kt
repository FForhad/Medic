package com.example.medic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddAgentActivity : AppCompatActivity() {
    /** database access */
    lateinit var mAuth: FirebaseAuth
    var databaseReference :  DatabaseReference? = null
    var database: FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_agent)

        mAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("agentprofile")

        /** initing variables */
        val addagent = findViewById<Button>(R.id.button3)
        val firstnameInput = findViewById<EditText>(R.id.firstnameInput)
        val emailInput = findViewById<EditText>(R.id.emailInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val cpasswordInput = findViewById<EditText>(R.id.button14)

        /** add agent details checks */
        addagent.setOnClickListener{
            if(TextUtils.isEmpty(firstnameInput.text.toString())) {
                firstnameInput.setError("Please enter first name ")
                return@setOnClickListener
            }else if(TextUtils.isEmpty(emailInput.text.toString())) {
                emailInput.setError("Please enter email ")
                return@setOnClickListener
            }else if(TextUtils.isEmpty(passwordInput.text.toString())) {
                passwordInput.setError("Please enter password ")
                return@setOnClickListener
            }
            else if(TextUtils.isEmpty(cpasswordInput.text.toString())) {
                cpasswordInput.setError("Please enter confirm password ")
                return@setOnClickListener
            }
            if(passwordInput.text.toString()!=cpasswordInput.text.toString()){
                cpasswordInput.setError("Please enter correct password ")
                return@setOnClickListener
            }
            /** storing info for agents */
            mAuth.createUserWithEmailAndPassword(emailInput.text.toString(), passwordInput.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful) {
                        val currentUser = mAuth.currentUser
                        val currentUSerDb = databaseReference?.child((currentUser?.uid!!))
                        currentUSerDb?.child("firstname")?.setValue(firstnameInput.text.toString())
                        currentUSerDb?.child("email")?.setValue(emailInput.text.toString())
                        currentUSerDb?.child("Password")?.setValue(passwordInput.text.toString())

                        Toast.makeText(this, "Agent Added Success. ", Toast.LENGTH_LONG).show()
                        finish()

                    } else {
                        Toast.makeText(this, "Registration failed, please try again! ", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}