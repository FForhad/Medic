package com.example.medic

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CardioSurgeryActivity : AppCompatActivity() {

    /** for CardioSurgery Specialist */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cardio_surgery)

        /** init and action for doctor 1 */
        val dr1 = findViewById<Button>(R.id.btncall)
        dr1.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)/** direct call options */
            intent.data = Uri.parse("tel:88029557932")
            startActivity(intent)
        }

        /** init and action for doctor 2 */
        val dr2 = findViewById<Button>(R.id.btncall1)
        dr2.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)/** direct call options */
            intent.data = Uri.parse("tel:88028617322")
            startActivity(intent)
        }

        /** init and action for doctor 3 */
        val dr3 = findViewById<Button>(R.id.btncall2)
        dr3.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)/** direct call options */
            intent.data = Uri.parse("tel:01782506448")
            startActivity(intent)
        }
    }
}