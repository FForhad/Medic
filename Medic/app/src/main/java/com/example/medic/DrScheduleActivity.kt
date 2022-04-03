package com.example.medic

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DrScheduleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dr_schedule)

        /** for cardiology doctor init and actions */
        val cardiology = findViewById<Button>(R.id.image2)
        cardiology.setOnClickListener{
            startActivity(Intent(this, CardiologyActivity::class.java))
        }
        /** for cardio_surgery doctor init and actions */
        val cardio_Surgery = findViewById<Button>(R.id.image3)
        cardio_Surgery.setOnClickListener{
            startActivity(Intent(this, CardioSurgeryActivity::class.java))
        }
        /** for Kidney_specialist doctor init and actions */
        val kidney_specialist = findViewById<Button>(R.id.image4)
        kidney_specialist.setOnClickListener{
            startActivity(Intent(this, KidneySpecialistActivity::class.java))
        }
        /** for Child_Specialist doctor init and actions */
        val child_specialist = findViewById<Button>(R.id.image5)
        child_specialist.setOnClickListener{
            startActivity(Intent(this, ChildSpecialistActivity::class.java))
        }
        /** for newrology doctor init and actions */
        val neurology = findViewById<Button>(R.id.image6)
        neurology.setOnClickListener{
            startActivity(Intent(this, NeurologyActivity::class.java))
        }
        /** for dentist init and actions */
        val dentist = findViewById<Button>(R.id.image7)
        dentist.setOnClickListener{
            startActivity(Intent(this, DentistActivity::class.java))
        }
        /** for psychiatrist doctor init and actions */
        val psychiatrist = findViewById<Button>(R.id.image8)
        psychiatrist.setOnClickListener{
            startActivity(Intent(this, PsychiatristActivity::class.java))
        }

        /** for back to dash-board */
        val back = findViewById<Button>(R.id.button16)
        psychiatrist.setOnClickListener{
            startActivity(Intent(this, DashActivity::class.java))
        }

    }
}