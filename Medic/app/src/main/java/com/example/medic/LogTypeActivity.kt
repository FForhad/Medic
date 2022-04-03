package com.example.medic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LogTypeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_type)

        /** init all the Buttons */
        val admin = findViewById<Button>(R.id.button8)
        val agent = findViewById<Button>(R.id.button9)
        val user = findViewById<Button>(R.id.button10)

        /** for admin */
        admin.setOnClickListener{
            startActivity(Intent(this,AdminActivity::class.java))
        }

        /** for agent */
        agent.setOnClickListener{
            startActivity(Intent(this,AgentActivity::class.java))
        }

        /** for user */
        user.setOnClickListener{
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}