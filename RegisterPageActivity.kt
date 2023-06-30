package com.car.app.modules.registerpage.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.car.app.R
import com.car.app.modules.CarDetailsActivity


class RegisterPageActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_register_page)
    val dbHelper = DBHelper(applicationContext)
    val register = this.findViewById<Button>(R.id.register);
    val view = this.findViewById<Button>(R.id.view);
    fun register():Boolean? {
      val fname = this.findViewById<EditText>(R.id.editTextText)
      val lname = this.findViewById<EditText>(R.id.editTextText2)
      val email = this.findViewById<EditText>(R.id.editTextTextEmailAddress)
      val pwd = this.findViewById<EditText>(R.id.editTextTextPassword)
      val mob = this.findViewById<EditText>(R.id.editTextPhone)
      val house = this.findViewById<EditText>(R.id.editTextText4)
      val city = this.findViewById<EditText>(R.id.editTextText5)
      val state = this.findViewById<EditText>(R.id.editTextText6)
      val pin = this.findViewById<EditText>(R.id.editTextText7)
      return dbHelper.registerUser(fname.text.toString(),lname.text.toString(),email.text.toString(),pwd.text.toString(),mob.text.toString(),house.text.toString(),city.text.toString(),state.text.toString(),pin.text.toString());
    }
    register.setOnClickListener {
        Toast.makeText(applicationContext, "Successfully Registered", Toast.LENGTH_SHORT).show()
        var intent = Intent(
          this, CarDetailsActivity::class.java
        )
        startActivity(intent)

    }
    view.setOnClickListener {
      val viewDBIntent = Intent(
        this, DatabaseView::class.java
      )
      startActivity(viewDBIntent)
    }
  }
}
