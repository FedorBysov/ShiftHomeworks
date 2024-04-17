package com.example.shifthomeworks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shifthomeworks.databinding.FragmentScreenBBinding


class ScreenBFragment : Fragment() {

    private var _binding: FragmentScreenBBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentScreenBBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNextScreen.setOnClickListener { setupClick() }

    }

    private fun setupClick() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, ScreenCFragment.newInstanceScreenC())
            .addToBackStack(null)
            .commit()

    }


    companion object{
        fun newInstanceScreenB(): ScreenBFragment {
            return ScreenBFragment().apply{}
        }


    }

}