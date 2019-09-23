package com.example1.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login_screen2.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class login_screen : AppCompatActivity() {
    var auth : FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen2)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        auth = FirebaseAuth.getInstance()
        btn_log_in.setOnClickListener{
           login()
        }
        btn_sign_up.setOnClickListener {
            startActivity(Intent(this, signUp::class.java))
            finish()
        }

    }
private fun login(){
    var email = user.text.toString()
    var password = pass.text.toString()
    if (password.isNotEmpty() && email.isNotEmpty()) {
        auth?.signInWithEmailAndPassword(email, password)
            ?.addOnCompleteListener {
                if (it.isSuccessful) {
                   verifyAddress()
                } else {
                    Toast.makeText(this, it.exception?.message, Toast.LENGTH_LONG).show()
                }
            }
        finish()
    }else{
        Toast.makeText(this , "please Enter a valid data ..!" , Toast.LENGTH_LONG).show()
    }
}
    private fun verifyAddress(){
val user = auth?.currentUser
        if(user!!.isEmailVerified){
            val int = Intent(this, Home_page::class.java)
            startActivity(int)
        }else{
            Toast.makeText(this , "please verify your E-mail ..!" , Toast.LENGTH_LONG).show()
        }
    }
}
