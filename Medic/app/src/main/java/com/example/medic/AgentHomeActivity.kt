package com.example.medic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class AgentHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agent_home)

        /** for seats define from agent */
            val hosseat = findViewById<LinearLayout>(R.id.layoutGoal)
            hosseat.setOnClickListener{
                startActivity(Intent(this,SeatAgentActivity::class.java))
                finish()
            }
            /**(val report = findViewById<LinearLayout>(R.id.layouthealth)
            report.setOnClickListener{
                startActivity(Intent(this,ReportActivity::class.java))
                finish()
            }*/
        loadUsername()
        }
    private fun loadUsername() {


        /** database access */
        lateinit var mAuth: FirebaseAuth
        var databaseReference :  DatabaseReference? = null
        var database: FirebaseDatabase? = null
        mAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        databaseReference = database?.reference!!.child("agentprofile")

        /** initing variables */
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

        /** for logout */
        val logoutButton = findViewById<TextView>(R.id.imageMenu)
        logoutButton.setOnClickListener {
            mAuth.signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

    }
    private fun loadnotice() {
        lateinit var mAuth: FirebaseAuth

        var databaseReference :  DatabaseReference? = null
        var database: FirebaseDatabase? = null
        mAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("bill")

        val notice = findViewById<TextView>(R.id.noticeboard)
        //notice.text = databaseReference?.root.toString()

        var getdata = object :ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {

                /** calling all the data from available agents and print them together */
                var sb = StringBuilder()
                for (i in snapshot.children){
                    var one = i.child("text").getValue()
                    sb.append("\n\t$one\n\n")
                }
                notice.setText(sb)
            }
        }
        databaseReference.addValueEventListener(getdata)
        databaseReference.addListenerForSingleValueEvent(getdata)
    }
    }
