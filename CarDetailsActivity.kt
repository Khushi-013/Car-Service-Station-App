package com.car.app.modules

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.car.app.R

class CarDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_details)
        val button = this.findViewById<Button>(R.id.button);
        val button2 = this.findViewById<Button>(R.id.button2);
        fun register():Boolean? {
            val name = this.findViewById<EditText>(R.id.editTextText3);
            val model = this.findViewById<EditText>(R.id.editTextText8);
            val manc = this.findViewById<EditText>(R.id.editTextText9);
            val year = this.findViewById<EditText>(R.id.editTextText10);
            return true
        }
        button.setOnClickListener {
            if(register() == true) Toast.makeText(applicationContext, "Details Submitted Successfully", Toast.LENGTH_SHORT).show()
        }
        button2.setOnClickListener {
            val intent = Intent(
                this, DBView::class.java
            )
            startActivity(intent)
        }
    }

}
