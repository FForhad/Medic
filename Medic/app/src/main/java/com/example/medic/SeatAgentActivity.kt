package com.example.medic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SeatAgentActivity : AppCompatActivity() {
    /** database access */
    lateinit var mAuth: FirebaseAuth
    var databaseReference :  DatabaseReference? = null
    var database: FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_agent)

        mAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("avseat")

        val update = findViewById<Button>(R.id.button12)
        val id = findViewById<EditText>(R.id.editTextTextPersonName3)
        val seat = findViewById<EditText>(R.id.editTextTextPersonName4)

        /** pushing all the data required in avseat database */
        update.setOnClickListener{

                        val currentUser = mAuth.currentUser
                        val currentUSerDb = databaseReference?.child((currentUser?.uid!!))
                        currentUSerDb?.child("Name")?.setValue(id.text.toString())
                        currentUSerDb?.child("seat")?.setValue(seat.text.toString())

                        Toast.makeText(this, "Update Success. ", Toast.LENGTH_LONG).show()
                        finish()

                    }
                }
        }
