package com.example.localnotification.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.localnotification.databinding.FragmentNotificationBinding
import com.example.localnotification.ui.utils.MyNotificationService
import com.example.localnotification.ui.utils.editText

class NotificationFragment : Fragment() {

    private lateinit var binding: FragmentNotificationBinding
    private lateinit var service: MyNotificationService

     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setUpListener()
    }

    private fun initialize() {
        service = MyNotificationService(requireContext())
    }

    private fun setUpListener() {
        binding.fabNotification.setOnClickListener {
            val edText = binding.etDescription.text.toString().trim()
            editText = edText
            service.showNotification()
        }
    }
}