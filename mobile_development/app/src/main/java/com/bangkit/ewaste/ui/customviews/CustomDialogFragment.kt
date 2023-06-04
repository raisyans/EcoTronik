package com.bangkit.ewaste.ui.customviews

import android.content.Context
import android.content.Intent
import android.graphics.Camera
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.NavHostFragment
import com.bangkit.ewaste.R
import com.bangkit.ewaste.ui.form.FormActivity
import com.bangkit.ewaste.ui.post.CameraActivity
import com.bangkit.ewaste.ui.post.PostWasteActivity
import com.bangkit.ewaste.utils.ConstVal.KEY_FORM
import com.bangkit.ewaste.utils.ConstVal.KEY_SELECTED_IMAGE_URI
import com.bangkit.ewaste.utils.ConstVal.REQUEST_CODE
import com.bangkit.ewaste.utils.uriToFile
import java.io.File

class CustomDialogFragment : DialogFragment() {
    private var uploadFile: File? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.TransparentDialog)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_custom_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cameraButton = view.findViewById<ImageButton>(R.id.btn_camera)
        val mediaButton = view.findViewById<ImageButton>(R.id.btn_media)
        cameraButton.setOnClickListener {
            val intent = Intent(context, CameraActivity::class.java)
            startActivity(intent)
            dismiss()
        }
        mediaButton.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_GET_CONTENT
            intent.type = "image/*"
            val chooser = Intent.createChooser(intent, "Pilih Gambar")
            intent.putExtra(KEY_FORM, "auto")
            launchIntentGallery.launch(chooser)
        }
    }


    private val launchIntentGallery = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == AppCompatActivity.RESULT_OK) {
            val selectedImg: Uri = result.data?.data as Uri
            val file = uriToFile(selectedImg, requireContext())
            uploadFile = file
//            SEND IMAGE TO POST WASTE
            val intent = Intent(requireContext(), PostWasteActivity::class.java)
            intent.putExtra(KEY_SELECTED_IMAGE_URI, file.toURI().toString())
            startActivityForResult(intent, REQUEST_CODE)
        }
    }
}