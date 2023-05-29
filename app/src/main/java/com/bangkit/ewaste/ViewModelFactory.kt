package com.bangkit.ewaste

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bangkit.ewaste.ui.login.LoginViewModel
import com.bangkit.ewaste.ui.registration.RegistrationViewModel

class ViewModelFactory  (private val context: Context) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(RegistrationViewModel::class.java) -> {
              return RegistrationViewModel(context) as T
            }
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
              return LoginViewModel(context) as T
            }
//            modelClass.isAssignableFrom(LogoutViewModel::class.java)->{
//                return  LogoutViewModel(context) as T
//            }
            else -> throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }
}