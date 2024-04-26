package com.example.shifthomeworks.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.shifthomeworks.R
import com.example.shifthomeworks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                // Разрешение предоставлено, можно загружать контакты

            } else {
                // Разрешение не предоставлено, обработайте этот случай
                Toast.makeText(applicationContext, "Разрешение на чтение контактов не предоставлено", Toast.LENGTH_LONG).show()
            }
        }



        fragmentTransactions(ListContactsFragment())
    }

    fun fragmentTransactions(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, fragment)
            //.addToBackStack(null)
            .commit()
    }
}