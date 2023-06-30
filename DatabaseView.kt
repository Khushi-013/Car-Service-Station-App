package com.car.app.modules.registerpage.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.car.app.R

class DatabaseView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database_view)
        val dbHelper = DBHelper(applicationContext)
        val view = this.findViewById<Button>(R.id.View)
        val delete = this.findViewById<Button>(R.id.Delete)
        val update = this.findViewById<Button>(R.id.Update)
        fun getUsers(): String? {
            val res = dbHelper.users
            if(res == null) return null
            else return res
        }
        view.setOnClickListener {
            val res = getUsers()
            if(res == null) Toast.makeText(applicationContext, "Unable to fetch data!", Toast.LENGTH_SHORT).show()
        }
        delete.setOnClickListener {
            val mob = this.findViewById<EditText>(R.id.editTextPhone).text.toString()
            dbHelper.deleteUser(mob)
            Toast.makeText(applicationContext, "user deleted!", Toast.LENGTH_SHORT).show()
        }
        update.setOnClickListener {
            val fname = this.findViewById<EditText>(R.id.editTextText)
            val lname = this.findViewById<EditText>(R.id.editTextText2)
            val email = this.findViewById<EditText>(R.id.editTextTextEmailAddress)
            val pwd = this.findViewById<EditText>(R.id.editTextTextPassword)
            val mob = this.findViewById<EditText>(R.id.editTextPhone)
            val house = this.findViewById<EditText>(R.id.editTextText4)
            val city = this.findViewById<EditText>(R.id.editTextText5)
            val state = this.findViewById<EditText>(R.id.editTextText6)
            val pin = this.findViewById<EditText>(R.id.editTextText7)
            dbHelper.update(mob, fname,lname, email, pwd,house,city,state,pin)
            Toast.makeText(applicationContext, "user updated!", Toast.LENGTH_SHORT).show()
        }
    }
}
