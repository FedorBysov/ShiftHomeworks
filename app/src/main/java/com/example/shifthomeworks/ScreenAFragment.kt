package com.example.shifthomeworks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shifthomeworks.databinding.FragmentScreenABinding


class ScreenAFragment : Fragment() {


    private var _binding: FragmentScreenABinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScreenABinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNextScreen.setOnClickListener { setupClick() }

    }

    private fun setupClick() {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, ScreenBFragment.newInstanceScreenB())
                .addToBackStack(null)
                .commit()

    }


    companion object{
        fun newInstanceScreenA(): ScreenAFragment {
            return ScreenAFragment().apply{}
            }
        }
}
