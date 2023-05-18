package com.bangkit.ewaste.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "M. Fidyan Fatra Aldino"
    }
    val text: LiveData<String> = _text
}