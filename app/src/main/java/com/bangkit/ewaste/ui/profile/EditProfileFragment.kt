package com.bangkit.ewaste.ui.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bangkit.ewaste.R
import com.bangkit.ewaste.databinding.FragmentEditProfileBinding

class EditProfileFragment : Fragment() {

    private var _binding : FragmentEditProfileBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel : EditProfileViewModel

    val args : EditProfileFragmentArgs by navArgs()


    companion object {
        fun newInstance() = EditProfileFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(EditProfileViewModel::class.java)

        _binding = FragmentEditProfileBinding.inflate(inflater, container, false)

        val root : View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvContentName.setText(args.name)
        binding.tvContentAddress.setText(args.alamat)
        binding.tvContentEmail.setText(args.email)
        binding.tvContentTelp.setText(args.noTelp)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}