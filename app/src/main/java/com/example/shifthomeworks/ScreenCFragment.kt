package com.example.shifthomeworks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.shifthomeworks.databinding.FragmentScreenBBinding
import com.example.shifthomeworks.databinding.FragmentScreenCBinding


class ScreenCFragment : Fragment() {

    private var _binding: FragmentScreenCBinding? = null
    private val binding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentScreenCBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNextScreen.setOnClickListener { setupClick() }

    }


    private fun setupClick() {
        requireActivity().supportFragmentManager

            .beginTransaction()
            .replace(R.id.fragment, ScreenAFragment.newInstanceScreenA())
            //.addToBackStack(null)
            .commit()
        requireActivity().supportFragmentManager
            .popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)



    }

    companion object{
        fun newInstanceScreenC(): ScreenCFragment {
            return ScreenCFragment().apply{}
        }


    }

}