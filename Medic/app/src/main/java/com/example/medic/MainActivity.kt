package com.example.medic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login = findViewById<Button>(R.id.button2) /** init logbtn */
        val signup = findViewById<Button>(R.id.button) /** init regbtn */


        /** here the register path */
        signup.setOnClickListener{
            startActivity(Intent(this,RegActivity::class.java))
            Toast.makeText(applicationContext, "Only for user registration", Toast.LENGTH_SHORT).show()
            finish()
        }


        /** here the login path */
        login.setOnClickListener{
            startActivity(Intent(this,LogTypeActivity::class.java))
        }

    }
}