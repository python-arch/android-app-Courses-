package com.example1.app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_android__course.*
import kotlinx.android.synthetic.main.activity_home_page.*
import java.util.*
import android.content.Intent
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.fragment_gallery.*

class Android_Course : AppCompatActivity() {
var auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android__course)
        email2.text = auth?.currentUser?.email
//        animation
        val dis = AnimationUtils.loadAnimation(this , R.anim.dis)
        val course1 = AnimationUtils.loadAnimation(this , R.anim.courses)
        val course2 = AnimationUtils.loadAnimation(this , R.anim.courses2)
        val course3 = AnimationUtils.loadAnimation(this , R.anim.courses3)
//        set the animation
        intro.startAnimation(course1)
        android_2.startAnimation(course1)
        xml.startAnimation(course2)
        import2.startAnimation(course2)
        first.startAnimation(course3)
        next.startAnimation(course3)
        fed.startAnimation(course1)
        todo.startAnimation(course1)
        // make the avatar random
        var avatars = arrayOf(R.drawable.avatar1 , R.drawable.avatar2 , R.drawable.avatar3 , R.drawable.avatar4 , R.drawable.avatar5 , R.drawable.avatar6)
        avatar2.setImageResource(avatars[random(avatars.size)])
        back_home.setOnClickListener {
            val int2 =  Intent(this, Home_page::class.java)
            startActivity(int2)
        }
//        shifting to the to-do list activity
        todo.setOnClickListener {
            startActivity(Intent(this , Todo_activity::class.java))
        }
    }
    fun random(a:Int):Int{
        var num = Random().nextInt(a)
        return num
    }

}
