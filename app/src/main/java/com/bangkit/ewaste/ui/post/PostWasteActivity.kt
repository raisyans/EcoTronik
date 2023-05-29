package com.bangkit.ewaste.ui.post

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit.ewaste.databinding.ActivityPostWasteBinding

class PostWasteActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPostWasteBinding

    private lateinit var viewModel: PostWasteViewModel

    private lateinit var currentPhotoPath : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostWasteBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}