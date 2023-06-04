package com.bangkit.ewaste.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _name = MutableLiveData<String>().apply {
        value = "M. Fidyan Fatra Aldino"
    }
    val name: LiveData<String> = _name
}