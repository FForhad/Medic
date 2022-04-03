package com.example.medic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class SeatActivity : AppCompatActivity() {
    /** database access */
    lateinit var mAuth: FirebaseAuth
    var databaseReference :  DatabaseReference? = null
    var database: FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat)

        mAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("avseat")/** creating available seat database */

        /** init hospital view list */
        val display = findViewById<TextView>(R.id.textView11)

            var getdata = object :ValueEventListener{
                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

                override fun onDataChange(snapshot: DataSnapshot) {

                    /** calling all the data from available agents and print them together */
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