package com.example.aadk3sampleapp3.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aadk3sampleapp3.viewmodel.PaymentsViewModel

class SignUpFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        PaymentsViewModel().isPaymentDone.observe(viewLifecycleOwner) { isDone ->
            if (isDone) {
                // Show Payment Success Page
            } else {
                // Show Payment Failed Page
            }
        }
        // Register that callback
        // Add our functionality in that callback
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}
