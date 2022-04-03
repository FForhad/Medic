package com.example.medic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ReportActivity : AppCompatActivity() {
    /** database access */
    lateinit var mAuth: FirebaseAuth
    var databaseReference :  DatabaseReference? = null
    var database: FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        mAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("report")


        val box = findViewById<EditText>(R.id.editTextTextPersonName)
        val push = findViewById<Button>(R.id.button5)

        push.setOnClickListener{

            val currentUser = mAuth.currentUser
            val currentUSerDb = databaseReference?.child((currentUser?.uid!!))
            currentUSerDb?.child("comp")?.setValue(box.text.toString())

            Toast.makeText(this, "report submitted. ", Toast.LENGTH_LONG).show()
            finish()

        }

    }
}