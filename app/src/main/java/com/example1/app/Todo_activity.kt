package com.example1.app

import CustomDialogClass
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_todo_activity.*

class Todo_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_activity)
        fab.setOnClickListener { view ->
val dialog = CustomDialogClass(this)
            dialog.show()
        }
    }

}
