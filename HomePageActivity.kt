package com.car.app.modules.homepage.ui


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.car.app.R
import com.car.app.modules.homepage.data.viewmodel.HomePageVM
import com.car.app.modules.loginpage.ui.LoginPageActivity
import com.car.app.modules.registerpage.ui.RegisterPageActivity



class HomePageActivity : AppCompatActivity(){
  private val viewModel: HomePageVM by viewModels<HomePageVM>()
  override fun onCreate(savedInstanceState:Bundle?){
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home_page)
    val btnLogin = this.findViewById<Button>(R.id.btnLogin)
    btnLogin.setOnClickListener{
      var intent = Intent(
        this,LoginPageActivity::class.java
      )
      startActivity(intent)
    }
    val btnRegister = this.findViewById<Button>(R.id.btnRegister)
    btnRegister.setOnClickListener{
      var intent = Intent(
        this,RegisterPageActivity::class.java
      )
      startActivity(intent)
    }
  }

}
