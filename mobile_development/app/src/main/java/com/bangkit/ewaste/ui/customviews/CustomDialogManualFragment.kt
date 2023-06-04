package com.bangkit.ewaste.ui.customviews

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import com.bangkit.ewaste.R
import com.bangkit.ewaste.utils.showToast

class CustomDialogManualFragment : DialogFragment() {

    private lateinit var spinner: Spinner

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = requireActivity().layoutInflater
        val dialogView = inflater.inflate(R.layout.fragment_custom_dialog_manual, null)

        builder.setView(dialogView)
            .setPositiveButton(null, null)
            .setNegativeButton(null, null)

        dialogView.findViewById<Button>(R.id.btn_post_waste).setOnClickListener {
            context?.showToast("Berhasil Submit")
            dismiss()
        }

        spinner = dialogView.findViewById(R.id.option_waste)
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.option_waste,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        return builder.create()
    }

}