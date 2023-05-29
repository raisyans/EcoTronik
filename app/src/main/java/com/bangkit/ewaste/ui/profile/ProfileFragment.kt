package com.bangkit.ewaste.ui.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.bangkit.ewaste.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: ProfileViewModel

    companion object {
        fun newInstance() = ProfileFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.user.observe(viewLifecycleOwner) {
            binding.tvName.text = it.name
            binding.tvContentName.text = it.name
            binding.tvContentAddress.text = it.alamat
            binding.tvContentEmail.text = it.email
            binding.tvContentTelp.text = it.telp
        }
        binding.ibEditProfile.setOnClickListener {
            val name = binding.tvContentName.text
            val alamat = binding.tvContentAddress.text
            val email = binding.tvContentEmail.text
            val telp = binding.tvContentTelp.text
            val action =
                ProfileFragmentDirections
                    .actionNavigationProfileToEditProfileFragment(
                        name.toString(), alamat.toString(), email.toString(), telp.toString()
                    )
            Navigation.findNavController(view).navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}