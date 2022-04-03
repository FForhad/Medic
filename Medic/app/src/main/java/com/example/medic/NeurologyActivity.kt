package com.example.medic

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class NeurologyActivity : AppCompatActivity() {
    /** for neurology Specialist */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_neurology)

        /** init and action for doctor 1 */
        val dr1 = findViewById<Button>(R.id.btncall)
        dr1.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)/** direct call options */
            intent.data = Uri.parse("tel:8809613787801")
            startActivity(intent)
        }
        /** init and action for doctor 2 */
        val dr2 = findViewById<Button>(R.id.btncall1)
        dr2.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)/** direct call options */
            intent.data = Uri.parse("tel:8801731956033")
            startActivity(intent)
        }
    }
}