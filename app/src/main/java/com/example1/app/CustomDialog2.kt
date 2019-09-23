package com.example1.app

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window

class CustomDialog2(context: Context) : Dialog(context) {
init{
    setCancelable(true)
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.user_info)
    }

}