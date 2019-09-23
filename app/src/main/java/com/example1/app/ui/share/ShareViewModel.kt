package com.example1.app.ui.share

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "You can support Us by sharing the Application and follow us on social media"
    }
    val text: LiveData<String> = _text
}