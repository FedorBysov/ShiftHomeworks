package com.example.shifthomeworks.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.shifthomeworks.R
import com.example.shifthomeworks.databinding.FragmentListConatctsBinding
import com.example.shifthomeworks.presentation.adapter.AdapterContact
import javax.inject.Inject


class ListContactsFragment : Fragment() {

    private lateinit var _binding: FragmentListConatctsBinding
    private val binding
        get() = _binding!!
    private lateinit var viewModel: ListContactsViewModel
    private lateinit var mainAdapter: AdapterContact

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as AppApplication).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListConatctsBinding.inflate(layoutInflater)
        return binding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this,viewModelFactory )[ListContactsViewModel::class.java]

        setupAdapter()
        viewModel.contactList.observe(requireActivity()) {
            Log.d("TEST_LOADING_LIVE_DATA", "${it.toString()}")
            mainAdapter.submitList(it)
        }

    }

    private fun setupAdapter() {
        mainAdapter = AdapterContact()
        binding.listRV.adapter = mainAdapter
        binding.listRV.recycledViewPool.setMaxRecycledViews(
            AdapterContact.POOL_VIEW_ACTIV,
            AdapterContact.POOL_VIEW_DISABLE
        )
    }

}