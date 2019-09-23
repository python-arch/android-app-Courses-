package com.example1.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home_page.*
import kotlinx.android.synthetic.main.activity_home_page.avatar
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.user_info.*
import java.util.*

class Home_page : AppCompatActivity() {
var auth:FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        auth = FirebaseAuth.getInstance()

        // declare animation
        val dis = AnimationUtils.loadAnimation(this , R.anim.dis)
        val courses= AnimationUtils.loadAnimation(this , R.anim.courses)
        val courses2= AnimationUtils.loadAnimation(this , R.anim.courses2)
        val courses3= AnimationUtils.loadAnimation(this , R.anim.courses3)
//        set the animation
        discover.startAnimation(dis)
        android.startAnimation(courses)
        web.startAnimation(courses2)
        java.startAnimation(courses3)
        elec.startAnimation(courses)
        python.startAnimation(courses2)
        info.startAnimation(courses3)
//        getting the username
        username.text = auth?.currentUser?.email
        // make the avatar random
        var avatars = arrayOf(R.drawable.avatar1 , R.drawable.avatar2 , R.drawable.avatar3 , R.drawable.avatar4 , R.drawable.avatar5 , R.drawable.avatar6)
avatar.setImageResource(avatars[random(avatars.size)])
//        logout
        logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
                val int2 = Intent(this , login_screen::class.java)
                startActivity(int2)
                finish()
        }
//        shifting to the nav drawer
        info.setOnClickListener {
            var int = Intent(this , Nav::class.java)
            int.putExtra("name" , "About Us")
            startActivity(int)
        }
        android.setOnClickListener {
 startActivity(Intent(this , Android_Course::class.java))
        }
//        pop-up
//val dialog = AlertDialog.Builder(this)
//        val dialogView = layoutInflater.inflate(R.layout.custom_pop , null)
//        dialog.setView(dialogView)
////        dialog.setCancelable(false)
//        username.setOnClickListener {
//            dialog.show()
//        }
//        pop-up
        val pop_up = CustomDialog2(this)
//        email_d.text = username.text
//        email_d.text = auth?.currentUser?.email
        username.setOnClickListener {
            pop_up.show()
        }
//        avatar_d.setImageResource(avatars[random(avatars.size)])

    }


    override fun onStart() {
        super.onStart()
        if(auth?.currentUser == null){
            imageView5.visibility= View.INVISIBLE
            python.visibility= View.INVISIBLE
            imageView7.visibility= View.INVISIBLE
            elec.visibility= View.INVISIBLE
            avatar.visibility = View.INVISIBLE
            java.visibility = View.INVISIBLE
            web.visibility = View.INVISIBLE
            info.visibility = View.INVISIBLE
            android.visibility = View.INVISIBLE
            logout.visibility = View.INVISIBLE
            all.visibility = View.INVISIBLE
            discover.text= "You should sign in first to access this data..!!"
            discover.textAlignment = View.TEXT_ALIGNMENT_CENTER
            var int = Intent(this , login_screen::class.java)
            startActivity(int)
        }
    }
    fun random(a:Int):Int{
        var num = Random().nextInt(a)
        return num
    }

}
