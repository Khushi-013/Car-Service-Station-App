package com.car.app.modules.loginpage.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.car.app.R
import com.car.app.modules.CarDetailsActivity


class LoginPageActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login_page)


    val emailTextView = findViewById<EditText>(R.id.txtEmail)
    val passwordTextView = findViewById<EditText>(R.id.txtPasswordOne)
    val btnLoginOne = findViewById<Button>(R.id.btnLoginOne)

    btnLoginOne.setOnClickListener {
        Toast.makeText(applicationContext, "Welcome to Access", Toast.LENGTH_LONG).show()
        val intent = Intent(this, CarDetailsActivity::class.java)
        startActivity(intent)
    }
  }
}
