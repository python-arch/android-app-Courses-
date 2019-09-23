package com.example1.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login_screen2.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class signUp : AppCompatActivity() {
    var auth : FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        auth = FirebaseAuth.getInstance()
        new_acc.setOnClickListener {
reg()
        }
    }
    private fun reg(){
        var email = user2.text.toString()
        var password = pass2.text.toString()
        if (password.isNotEmpty() && email.isNotEmpty()) {
            p1.visibility = View.VISIBLE
            auth?.createUserWithEmailAndPassword(email, password)
                ?.addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(applicationContext, "please check your E-mail..!", Toast.LENGTH_LONG).show()
                        p1.visibility = View.GONE
                        sendverification()
                    } else {
                        Toast.makeText(
                            applicationContext,
                            it.exception?.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
        }else{
            Toast.makeText(applicationContext, "please enter a valid data..!", Toast.LENGTH_LONG).show()
        }
    }
    private fun sendverification () {
        val user = auth?.currentUser
        user?.sendEmailVerification()?.addOnCompleteListener {
            if(it.isSuccessful){
                val loginIntent = Intent(this , login_screen::class.java)
                startActivity(loginIntent)
                finish()
            }else{
                Toast.makeText(applicationContext, "please try again ..!", Toast.LENGTH_LONG).show()
            }
        }
    }
}
