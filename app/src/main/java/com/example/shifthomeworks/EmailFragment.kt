package com.example.shifthomeworks

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shifthomeworks.databinding.FragmentEmailBinding
import java.util.Timer
import kotlin.concurrent.schedule


class EmailFragment : Fragment() {

    private var _binding: FragmentEmailBinding? = null
    private val binding
        get() = _binding!!




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEmailBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val animation = Animation()

        binding.button.setOnClickListener {
            if (binding.editText.text.isEmpty()) {
                animation.povorot(binding.button)
            } else {
                animation.progressBar(binding.root, R.layout.progress_bar, requireContext())
                Timer().schedule(1000) {
                    requireActivity().supportFragmentManager.popBackStack()
                }
            }
        }


    }



}