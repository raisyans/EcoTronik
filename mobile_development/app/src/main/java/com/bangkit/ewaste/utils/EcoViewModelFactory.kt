package com.bangkit.ewaste.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bangkit.ewaste.di.Injection
import com.bangkit.ewaste.ui.post.PostWasteViewModel

class EcoViewModelFactory(private val context : Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(PostWasteViewModel::class.java) -> {
                PostWasteViewModel(Injection.Injection.provideRepository(context)) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }
}