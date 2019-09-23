package com.example1.app.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example1.app.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home_page.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.avatar
import java.util.Random

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
var auth = FirebaseAuth.getInstance()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(this, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        face.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.facebook.com/TheSemiColon33/")) )
        }
        share.setOnClickListener {
             val sent = Intent()
             sent.action = Intent.ACTION_SEND
             sent.putExtra(Intent.EXTRA_TEXT , "Download Semi-Colon Application from the following link")
            sent.type = "text/plain"
            startActivity(Intent.createChooser(sent,"choose the App : "))

        }
        //        getting the username
        email.text = auth?.currentUser?.email
        // make the avatar random
        var avatars = arrayOf(R.drawable.avatar1 , R.drawable.avatar2 , R.drawable.avatar3 , R.drawable.avatar4 , R.drawable.avatar5 , R.drawable.avatar6)
        avatar.setImageResource(avatars[random(avatars.size)])

        super.onActivityCreated(savedInstanceState)
    }
    fun random(a:Int):Int{
        var num = Random().nextInt(a)
        return num
    }
}