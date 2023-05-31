package com.bangkit.ewaste.ui.post

import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit.ewaste.databinding.ActivityPostWasteBinding
import com.bangkit.ewaste.utils.ConstVal.KEY_PICTURE
import com.bangkit.ewaste.utils.ConstVal.KEY_SELECTED_IMAGE_URI
import java.io.File

class PostWasteActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPostWasteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostWasteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent

        val pictureFile = intent.getSerializableExtra(KEY_PICTURE) as? File

        if (pictureFile != null) {
            val bitmap = BitmapFactory.decodeFile(pictureFile.path)
            binding.imgPreview.setImageBitmap(bitmap)
        }

        val imageUriString = intent.getStringExtra(KEY_SELECTED_IMAGE_URI)
        if (imageUriString != null) {
            val imageUri = Uri.parse(imageUriString)
            binding.imgPreview.setImageURI(imageUri)
        }
    }

}