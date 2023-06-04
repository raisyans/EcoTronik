package com.bangkit.ewaste.ui.form

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit.ewaste.databinding.ActivityFormBinding
import com.bangkit.ewaste.ui.customviews.CustomDialogFragment
import com.bangkit.ewaste.ui.customviews.CustomDialogManualFragment
import com.bangkit.ewaste.ui.post.CameraActivity
import com.bangkit.ewaste.utils.ConstVal
import com.bangkit.ewaste.utils.ConstVal.KEY_FORM
import com.bangkit.ewaste.utils.showToast

class FormActivity : AppCompatActivity() {

    private var _activityFormBinding : ActivityFormBinding? = null
    private val binding get() = _activityFormBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _activityFormBinding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(_activityFormBinding?.root)

        val typeForm = intent.getStringExtra(KEY_FORM)

        if (typeForm == "auto"){
            binding.fabAdd.setOnClickListener {
                val intent = Intent(this, CameraActivity::class.java)
                startActivity(intent)
                finish()
            }
        } else if (typeForm == "manual"){
            binding.fabAdd.setOnClickListener {
                val dialog = CustomDialogManualFragment()
                dialog.show(supportFragmentManager, "customDialog")
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        showToast("Form Disimpan di History")
    }

    companion object {
        fun start(context: Context, key : String) {
            val intent = Intent(context, FormActivity::class.java)
            intent.putExtra(KEY_FORM, key)
            context.startActivity(intent)
        }
    }
}