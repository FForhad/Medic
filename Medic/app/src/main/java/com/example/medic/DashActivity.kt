package com.example.medic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class DashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash)


        /** for seat tap here */
        val hosseat = findViewById<LinearLayout>(R.id.layoutGoal)
        hosseat.setOnClickListener{
            startActivity(Intent(this,SeatActivity::class.java))
            finish()
        }

        /** to see the doctors details and book appointment tap here */
        val drschedule = findViewById<LinearLayout>(R.id.layoutfinance)
        drschedule.setOnClickListener{
            startActivity(Intent(this,DrScheduleActivity::class.java))
            finish()
        }

        /** for complain or suggestions tap here */
        val report = findViewById<LinearLayout>(R.id.layouthealth)
        report.setOnClickListener{
            startActivity(Intent(this,ReportActivity::class.java))
            finish()
        }


        /** for access data from database */
        loadnotice()
        loadUsername()

    }
    private fun loadUsername() {
        lateinit var mAuth: FirebaseAuth
        var databaseReference :  DatabaseReference
        var database: FirebaseDatabase
        mAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        databaseReference = database?.reference!!.child("profile")
        val user = mAuth.currentUser
        val userreference = databaseReference?.child(user?.uid!!)
        val firstnameText = findViewById<TextView>(R.id.username)

        userreference?.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                firstnameText.text = snapshot.child("firstname").value.toString()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        val logoutButton = findViewById<TextView>(R.id.imageMenu)
        logoutButton.setOnClickListener {
            mAuth.signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
        
    }
    private fun loadnotice() {
        lateinit var mAuth: FirebaseAuth
        var databaseReference :  DatabaseReference
        var database: FirebaseDatabase
        mAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        databaseReference = database?.reference!!.child("bill")
        val user = mAuth.currentUser
        val userreference = databaseReference?.child(user?.uid!!)
        val firstnameText = findViewById<TextView>(R.id.noticeboard)

        userreference?.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                firstnameText.setText(snapshot.child("text").toString())
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }

}