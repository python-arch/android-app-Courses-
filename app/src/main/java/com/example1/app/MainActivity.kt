package com.example1.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onDestroy() {
        super.onDestroy()
        overridePendingTransition(R.anim.fade_in , R.anim.fade_out)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logo.startAnimation(AnimationUtils.loadAnimation(this , R.anim.splash_in))
        Handler().postDelayed({
            logo.startAnimation(AnimationUtils.loadAnimation(this , R.anim.splash_out))
            Handler().postDelayed({
                logo.visibility = View.GONE
                startActivity(Intent(this , Home_page::class.java))
                finish()
            } , 1000)
        },1000)
    }
}
