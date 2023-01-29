package com.example.localnotification.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.localnotification.R
import com.example.localnotification.databinding.ActivityMainBinding
import com.example.localnotification.ui.fragment.NotificationFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Эксперименты
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, NotificationFragment.newInstance())
                .commitNow()
        }
    }
}