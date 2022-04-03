package com.example.medic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class SeatAdminActivity : AppCompatActivity() {
    /** database access */
    lateinit var mAuth: FirebaseAuth
    var databaseReference :  DatabaseReference? = null
    var database: FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_admin)

        mAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("avseat")

        val display = findViewById<TextView>(R.id.textView11)

        var getdata = object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {

                var sb = StringBuilder()
                for (i in snapshot.children){
                    var one = i.child("Name").getValue()
                    var two = i.child("seat").getValue()
                    sb.append("\n\t$one ->> \t$two\n\n")
                }
                display.setText(sb)
            }
        }
        databaseReference!!.addValueEventListener(getdata)
        databaseReference!!.addListenerForSingleValueEvent(getdata)
    }
}