package com.example.medic

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ChildSpecialistActivity : AppCompatActivity() {
    /** for Child Specialist */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_child_specialist)

        /** init and action for doctor 1 */
        val dr1 = findViewById<Button>(R.id.btncall)
        dr1.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)/** direct call options */
            intent.data = Uri.parse("tel:880-2-8322691")
            startActivity(intent)
        }
        /** init and action for doctor 2 */
        val dr2 = findViewById<Button>(R.id.btncall1)
        dr2.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)/** direct call options */
            intent.data = Uri.parse("tel:880 1711350724")
            startActivity(intent)
        }
        /** init and action for doctor 3 */
        val dr3 = findViewById<Button>(R.id.btncall2)
        dr3.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)/** direct call options */
            intent.data = Uri.parse("tel:880-2-8318135")
            startActivity(intent)
        }
    }
}