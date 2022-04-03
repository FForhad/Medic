package com.example.medic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class AdminReportActivity : AppCompatActivity() {
    /** database access */
    lateinit var mAuth: FirebaseAuth
    var databaseReference :  DatabaseReference? = null
    var database: FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_report)

        mAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("report")

        val box2 = findViewById<EditText>(R.id.editTextTextPersonName5)

        var getdata = object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {

                /** calling all the data from available agents and print them together */
                var sb = StringBuilder()
                for (i in snapshot.children){
                    var one = i.child("comp").getValue()
                    sb.append("\n\t$one\n\n")
                }
                box2.setText(sb)
            }
        }
        databaseReference!!.addValueEventListener(getdata)
        databaseReference!!.addListenerForSingleValueEvent(getdata)
    }
    }
