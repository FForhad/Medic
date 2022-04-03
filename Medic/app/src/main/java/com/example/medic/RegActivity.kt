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
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class RegActivity : AppCompatActivity() {
    /** database access init */
    lateinit var mAuth: FirebaseAuth
    var databaseReference :  DatabaseReference? = null
    var database: FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)


        mAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("profile")


        /** registrations */
        val signup = findViewById<Button>(R.id.button3)
        val firstnameInput = findViewById<EditText>(R.id.firstnameInput)
        val lastnameInput = findViewById<EditText>(R.id.lastnameInput)
        val emailInput = findViewById<EditText>(R.id.emailInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val cpasswordInput = findViewById<EditText>(R.id.button14)


        /** if signup btn tap */
        signup.setOnClickListener {

            if(TextUtils.isEmpty(firstnameInput.text.toString())) {
                firstnameInput.setError("Please enter first name ")
                return@setOnClickListener                           /** error shows untill require info gets */
            } else if(TextUtils.isEmpty(lastnameInput.text.toString())) {
                lastnameInput.setError("Please enter last name ")/** error shows untill require info gets */
                return@setOnClickListener
            }else if(TextUtils.isEmpty(emailInput.text.toString())) {
                emailInput.setError("Please enter email ")/** error shows untill require info gets */
                return@setOnClickListener
            }else if(TextUtils.isEmpty(passwordInput.text.toString())) {
                passwordInput.setError("Please enter password ")/** error shows untill require info gets */
                return@setOnClickListener
            }
            else if(TextUtils.isEmpty(cpasswordInput.text.toString())) {
                cpasswordInput.setError("Please enter confirm password ")/** error shows untill require info gets */
                return@setOnClickListener
            }

            /** checks the pass and confirmed pass are same or not */
            if(passwordInput.text.toString()!=cpasswordInput.text.toString()){
                cpasswordInput.setError("Please enter correct password ")
                return@setOnClickListener
            }

            /** create database for new user and stores the data */
            mAuth.createUserWithEmailAndPassword(emailInput.text.toString(), passwordInput.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful) {
                        val currentUser = mAuth.currentUser
                        val currentUSerDb = databaseReference?.child((currentUser?.uid!!))
                        currentUSerDb?.child("firstname")?.setValue(firstnameInput.text.toString())
                        currentUSerDb?.child("lastname")?.setValue(lastnameInput.text.toString())
                        currentUSerDb?.child("email")?.setValue(emailInput.text.toString())
                        currentUSerDb?.child("Password")?.setValue(passwordInput.text.toString())

                        Toast.makeText(this@RegActivity, "Registration Success. ", Toast.LENGTH_LONG).show()
                        finish()

                    } else {
                        Toast.makeText(this@RegActivity, "Registration failed, please try again! ", Toast.LENGTH_LONG).show()
                    }
                }
        }

        /** for login textview tap */
        val login = findViewById<TextView>(R.id.textView10)
        login.setOnClickListener{
            startActivity(Intent(this,LogTypeActivity::class.java))
        }

    }

}