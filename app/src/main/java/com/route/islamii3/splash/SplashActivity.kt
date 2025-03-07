package com.route.islamii3.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.route.islamii3.R
import com.route.islamii3.home.HomeActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed(
            {val intent = Intent(this@SplashActivity,HomeActivity::class.java)
                startActivity(intent)
                finish()
            }

            ,3000)

    }
}