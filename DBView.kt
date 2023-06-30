package com.car.app.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.car.app.R

class DBView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_db_view)
        val dbHelper = MyDBHelper(applicationContext)
        val fetchDataBtn = this.findViewById<Button>(R.id.fetch)
        val msg = this.findViewById<TextView>(R.id.message)
        val del = this.findViewById<Button>(R.id.del)
        val update = this.findViewById<Button>(R.id.change)
        fun getUsers(): String? {
            val res = dbHelper.car
            if(res == null) return null
            else return res
        }
        fetchDataBtn.setOnClickListener {
            val res = getUsers()
            if(res == null) Toast.makeText(applicationContext, "Unable to fetch data!", Toast.LENGTH_SHORT).show()
            else msg.setText(res)
        }
        del.setOnClickListener {
            val name = this.findViewById<EditText>(R.id.editTextText3).text.toString()
            dbHelper.deleteCar(name)
            Toast.makeText(applicationContext, "car details deleted!", Toast.LENGTH_SHORT).show()
        }
        update.setOnClickListener {
            val name = this.findViewById<EditText>(R.id.editTextText3).text.toString();
            val model = this.findViewById<EditText>(R.id.editTextText8).text.toString();
            val manc = this.findViewById<EditText>(R.id.editTextText9).text.toString();
            val year = this.findViewById<EditText>(R.id.editTextText10).text.toString();
            dbHelper.update(name, model, manc, year)
            Toast.makeText(applicationContext, "car details updated!", Toast.LENGTH_SHORT).show()
        }
    }
}
