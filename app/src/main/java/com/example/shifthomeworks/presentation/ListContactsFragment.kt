package com.example.shifthomeworks.presentation

import android.content.ContentResolver
import android.content.Context
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.test.core.app.ActivityScenario.launch
import com.example.shifthomeworks.databinding.FragmentListContactsBinding
import com.example.shifthomeworks.presentation.adapter.AdapterContact
import java.util.jar.Manifest
import javax.inject.Inject
import kotlin.streams.toList


class ListContactsFragment : Fragment() {

    private lateinit var _binding: FragmentListContactsBinding
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
        _binding = FragmentListContactsBinding.inflate(layoutInflater)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory)[ListContactsViewModel::class.java]


        setupAdapter()
        viewModel.contactList.observe(requireActivity()) {
            Log.d("TEST_LOADING_LIVE_DATA", "${it.toString()}")
            mainAdapter.submitList(it)
        }






        binding.btnAdd.setOnClickListener {

            checkPermissionsAndLoadContacts()
            isPermissionGranted(
                requireContext(), android.Manifest.permission.READ_CONTACTS
            ) {
                if (it) {
                    viewModel.deleteALl()
//
                    val cursor: Cursor? = activity?.contentResolver?.query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        arrayOf(
                            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                            ContactsContract.CommonDataKinds.Phone.NUMBER
                        ),
                        null,
                        null,
                        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
                    )

                    cursor?.use {
                        val nameIndex =
                            cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
                        val numberIndex =
                            cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)

                        while (cursor.moveToNext()) {
                            val name = cursor.getString(nameIndex)
                            val number = cursor.getString(numberIndex)
                            viewModel.addShopItem(name, number)
                        }
                    }


                } else {
                    shouldShowRequestPermissionRationale(android.Manifest.permission.READ_CONTACTS)
                }
            }
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

    inline fun isPermissionGranted(context: Context, permission: String, call: (Boolean) -> Unit) {
        if (ContextCompat.checkSelfPermission(
                context,
                permission
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            call.invoke(true)
        } else {
            call.invoke(false)
        }


    }

    val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            // Разрешение предоставлено, можно загружать контакты
        } else {
            // Разрешение не предоставлено, обработайте этот случай
            Toast.makeText(
                requireContext(),
                "Разрешение на чтение контактов не предоставлено",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun checkPermissionsAndLoadContacts() {
        when {
            ContextCompat.checkSelfPermission(
                requireContext(), android.Manifest.permission.READ_CONTACTS
            ) == PackageManager.PERMISSION_GRANTED -> {
                // Разрешение уже предоставлено, загрузите контакты
            }

            shouldShowRequestPermissionRationale(android.Manifest.permission.READ_CONTACTS) -> {
                // В этом блоке можно показать объясняющий UI, почему требуется доступ
                Toast.makeText(
                    context,
                    "Необходим доступ к контактам для отображения",
                    Toast.LENGTH_LONG
                ).show()
                requestPermissionLauncher.launch(android.Manifest.permission.READ_CONTACTS)
            }

            else -> {
                // Запрос разрешения
                requestPermissionLauncher.launch(android.Manifest.permission.READ_CONTACTS)
            }
        }
    }


}