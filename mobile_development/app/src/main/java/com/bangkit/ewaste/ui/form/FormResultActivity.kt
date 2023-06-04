package com.bangkit.ewaste.ui.form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit.ewaste.R
import com.bangkit.ewaste.databinding.ActivityFormResultBinding

class FormResultActivity : AppCompatActivity() {
    private var _activityFormResultBinding : ActivityFormResultBinding? = null
    private val binding get() = _activityFormResultBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _activityFormResultBinding = ActivityFormResultBinding.inflate(layoutInflater)
        setContentView(_activityFormResultBinding?.root)
    }
}