package com.example.medic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class AdminHomeActivity : AppCompatActivity() {
    /** database access */
    lateinit var mAuth: FirebaseAuth
    var databaseReference :  DatabaseReference? = null
    var database: FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_home)

        mAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("bill")



        /** for updating the daily notifications */
        val notic = findViewById<EditText>(R.id.noticeboard)
        //val noticew = findViewById<EditText>(R.id.noticeboard)
        val save = findViewById<Button>(R.id.button11)


        save.setOnClickListener{
            databaseReference?.child("text")?.setValue(notic.text.toString())
            //cuSerDb?.child("textt")?.setValue(noticew.text.toString())
            Toast.makeText(this, "Update Success. ", Toast.LENGTH_LONG).show()
            finish()
        }

        /** for seats */
        val hosseat = findViewById<LinearLayout>(R.id.layoutGoal)
        hosseat.setOnClickListener{
            startActivity(Intent(this,SeatActivity::class.java))
            finish()
        }
        /** for drschedule portal */
        val drschedule = findViewById<LinearLayout>(R.id.layoutfinance)
        drschedule.setOnClickListener{
            startActivity(Intent(this,DrScheduleActivity::class.java))
            finish()
        }
        /** for checking report */
        val report = findViewById<LinearLayout>(R.id.layouthealth)
        report.setOnClickListener{
            startActivity(Intent(this,AdminReportActivity::class.java))
            finish()
        }
        /** for adding agents*/
        val agent = findViewById<LinearLayout>(R.id.addagent)
        agent.setOnClickListener{
            startActivity(Intent(this,AddAgentActivity::class.java))
            finish()
        }

        /** for logout */
        val logoutButton = findViewById<TextView>(R.id.imageMenu)
        logoutButton.setOnClickListener {
            startActivity(Intent(this, LogTypeActivity::class.java))
            finish()
        }


        //val databaseReference = FirebaseDatabase.getInstance().reference!!.child("notice")



        }

    }


