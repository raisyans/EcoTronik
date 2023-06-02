package com.bangkit.ewaste.ui.home

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.bangkit.ewaste.R
import com.bangkit.ewaste.databinding.FragmentHomeBinding
import com.bangkit.ewaste.ui.customviews.CustomDialogFragment
import com.bangkit.ewaste.ui.form.FormActivity
import com.bangkit.ewaste.utils.createCustomTempFile

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.tvName
        homeViewModel.name.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnScanner.setOnClickListener {
            val dialog = CustomDialogFragment()
            dialog.show(parentFragmentManager, "customDialog")
        }
        binding.btnForm.setOnClickListener {
            FormActivity.start(requireContext(), "manual")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}