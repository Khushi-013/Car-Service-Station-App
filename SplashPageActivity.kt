package com.car.app.modules.splashpage.ui

import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.car.app.R
import com.car.app.appcomponents.base.BaseActivity
import com.car.app.databinding.ActivitySplashPageBinding
import com.car.app.modules.homepage.ui.HomePageActivity
import com.car.app.modules.splashpage.`data`.viewmodel.SplashPageVM
import kotlin.String
import kotlin.Unit

class SplashPageActivity : BaseActivity<ActivitySplashPageBinding>(R.layout.activity_splash_page) {
  private val viewModel: SplashPageVM by viewModels<SplashPageVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.splashPageVM = viewModel
    Handler(Looper.getMainLooper()).postDelayed( {
      val destIntent = Intent(this, HomePageActivity::class.java)
      startActivity(destIntent)
      finish()
      }, 3000)
    }

    override fun setUpClicks(): Unit {
    }

    companion object {
      const val TAG: String = "SPLASH_PAGE_ACTIVITY"

    }
  }
