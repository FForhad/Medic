package com.example.medic

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class AccountRecoverActivity : AppCompatActivity() {

    /**lateinit var mAuth: FirebaseAuth
    var databaseReference :  DatabaseReference? = null
    var database: FirebaseDatabase? = null*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_recover)

/**
        mAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("profile")
        val emailAddress = findViewById<EditText>(R.id.editText3)
        val pass = findViewById<TextView>(R.id.textView5)
        val user = mAuth.currentUser
        val userreference = databaseReference?.child(user?.uid!!)
        val recoverpass = findViewById<Button>(R.id.recpass)


        recoverpass.setOnClickListener {
            mAuth.addOnCompleteListener {
                    if (it.isSuccessful) {
                        userreference?.addValueEventListener(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {

                                //firstnameText.text = snapshot.child("firstname").value.toString()
                                pass.text = snapshot.child("Password").value.toString()
                            }

                            override fun onCancelled(error: DatabaseError) {
                                TODO("Not yet implemented")
                            }
                        })
                    }
                }
        }*/




    }
}


