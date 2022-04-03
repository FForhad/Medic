package com.example.medic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        /** initing variables */
        val admin = findViewById<EditText>(R.id.editTextTextPersonName2)
        val adminpass = findViewById<EditText>(R.id.editTextTextPassword)
        val lgad = findViewById<Button>(R.id.button7)

        /** for initing the admin access */
        lgad.setOnClickListener{
            if(admin.text.toString()=="Forhad" && adminpass.text.toString()=="1109028"){

                startActivity(Intent(this,AdminHomeActivity::class.java))
            }
            else if(admin.text.toString()=="Zubaer" && adminpass.text.toString()=="1109023"){

                startActivity(Intent(this,AdminHomeActivity::class.java))
            }
            else if(admin.text.toString()=="Sakib" && adminpass.text.toString()=="1109031"){

                startActivity(Intent(this,AdminHomeActivity::class.java))
            }
            else if(admin.text.toString()=="Fardin" && adminpass.text.toString()=="1109008"){

                startActivity(Intent(this,AdminHomeActivity::class.java))
            }
        }
    }
}